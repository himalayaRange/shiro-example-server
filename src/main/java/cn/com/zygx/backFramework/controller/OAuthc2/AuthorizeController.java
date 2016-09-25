package cn.com.zygx.backFramework.controller.OAuthc2;

import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.service.OAuthClientService;
import cn.com.zygx.backFramework.service.OAuthService;
import com.google.common.base.Objects;

/**
 * 授权控制器
 * <p>User: wangyi
 * <p>Date: 2016-9-9
 * <p>Version: 1.0
 */
@Controller
public class AuthorizeController {

	@Autowired
	private OAuthService oAuthService;
	
	@Autowired
	private OAuthClientService clientService;
	
	//*授权
	@RequestMapping("/authorize")
	public Object authorize(HttpServletRequest request,Model model) throws URISyntaxException, OAuthSystemException{
		try {
			//构建OAuth授权请求
			OAuthAuthzRequest oauthRequest  = new OAuthAuthzRequest(request);
			
			//检查传入客户端的ID是都正确
			if(!oAuthService.checkClientId(oauthRequest.getClientId())){
				OAuthResponse response=OAuthResponse
							.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
							.setError(OAuthError.TokenResponse.INVALID_CLIENT)
							.setErrorDescription(Constant.INVALID_CLIENT_ID_DESCRIPTION)
							.buildJSONMessage();
				return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
			}
			
			//验证是否登录，未登录则跳转到登录页面
			Subject subject=SecurityUtils.getSubject();
			if(!subject.isAuthenticated()){
				if(!login(subject, request)){
					//登录失败
					model.addAttribute("client", clientService.findByClientId(oauthRequest.getClientId()));
					return "oauth2login";
				}
			}
			
			
			//生成授权码
			String username = null;
			User user=(User)subject.getPrincipal();
			if(user!=null){
				username=user.getUsername();
			}
			String authorizationCode = null;
			//responseType目前仅支持CODE，另外还有TOKEN
			String responseType=oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
			if(Objects.equal(responseType, ResponseType.CODE.toString())){
				OAuthIssuerImpl  oAuthIssuerImpl  =new OAuthIssuerImpl (new MD5Generator());
				authorizationCode = oAuthIssuerImpl.authorizationCode();
				//添加 授权-->username的关联管理，此处只是放在缓存中处理，实际环境中进行持久化
				oAuthService.addAuthCode(authorizationCode, username);
			}
			
			//进行OAuth响应构建
            OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
                    OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);
            //设置授权码
            builder.setCode(authorizationCode);
            //得到到客户端重定向地址
            String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
			
            
            //构建响应
            final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
            
            //根据OAuthResponse返回ResponseEntity响应
            HttpHeaders header=new HttpHeaders();
            header.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(header, HttpStatus.valueOf(response.getResponseStatus()));
            
		} catch (OAuthProblemException e) {
			//出错处理
			String redirectUri = e.getRedirectUri();
			if(OAuthUtils.isEmpty(redirectUri)){
				 //告诉客户端没有传入redirectUri直接报错
				return new ResponseEntity("OAuth callback url needs to be provided by client!!!", HttpStatus.NOT_FOUND);
			}
			
			//返回错误消息（如?error=）
			 final OAuthResponse response =
	                    OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND)
	                            .error(e).location(redirectUri).buildQueryMessage();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
		}
	}
	
	
	private boolean login(Subject subjet,HttpServletRequest request){
		if(Objects.equal("get", request.getMethod())){
			return false;
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
			return false;
		}
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try {
			subjet.login(token);
			return true;
		} catch (UnknownAccountException e) {
			request.setAttribute("error", "用户名信息错误！");
			return false;
		} catch (IncorrectCredentialsException e) {
			request.setAttribute("error", "密码凭证不正确！");
			return false;
		} catch (LockedAccountException e) {
			request.setAttribute("error", "您的账户已被锁定！");
			return false;
		}catch (Exception e) {
			request.setAttribute("error", "登录失败:" + e.getClass().getName());
			return false;
		}
	}
}
