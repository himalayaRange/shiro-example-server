package cn.com.zygx.backFramework.controller.sdk.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.common.base.Objects;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.controller.sdk.GeetestLib;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.shiro.realm.DefaultUsernamePasswordToken;


/**
 * 二次验证
 * 使用post方式，返回验证结果, request表单中必须包含challenge, validate, seccode
 */
public class VerifyLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 244554953219893949L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());
			
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		
		//用户名
		String username=request.getParameter(GeetestLib.fn_geetest_username);
		//和密码
		String password=request.getParameter(GeetestLib.fn_geetest_password);
		//记住我
		String rememberMe=request.getParameter(GeetestLib.fn_geetest_rememberMe); 
		
		//从session中获取gt-server状态
		int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
		
		//从session中获取userid
		String userid = (String)request.getSession().getAttribute("userid");
		
		int gtResult = 0;

		if (gt_server_status_code == 1) {
			//gt-server正常，向gt-server进行二次验证
				
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
			System.out.println(gtResult);
		} else {
			// gt-server非正常情况下，进行failback模式验证
				
			System.out.println("failback:use your own server captcha validate");
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
			System.out.println(gtResult);
		}


		if (gtResult == 1) {
			// 验证成功-->判断用户名和密码
			Subject subject=SecurityUtils.getSubject();
			/**此处使用进入多个realm认证器，通过Login_type跳转
			 * UsernamePasswordToken token=new UsernamePasswordToken(username, password);
			 */
			DefaultUsernamePasswordToken token=new DefaultUsernamePasswordToken(username, password);
			token.setLoginType(Constant.LOGIN_TYPE_USER);
			
			String emsg=null;
			PrintWriter out = response.getWriter();
			JSONObject data = new JSONObject();
			try {
				if(Objects.equal(rememberMe, "true")){
					token.setRememberMe(true); //记住我
				}
				subject.login(token);
				/*
				 * Shiro 提供的会话可以用于JavaSE/JavaEE 环境，不依赖于任何底层容器，可以独立使用，是完整的会话模块，可直接替换Web容器的Session管理
				 */
				Session session = subject.getSession(); //默认如果没有创建sesssion会主动创建一个
				String id=(String)session.getId(); //当前会话的唯一标识。
				String host = session.getHost(); //Subject的主机地址，该地址是通过HostAuthenticationToken.getHost()提供的。
				long timeOut=session.getTimeout();
				System.out.println("ID:"+id+"=== host:"+host+"==timeOut:"+timeOut);
				
				/*
				 * 用户登录成功后，shiro会把用户名，可以是对象，放入到session的attribute中
				 * 默认的key为DefaultSubjectContext.PRINCIPALS_SESSION_KEY
				 * User user=(User)subject.getPrincipal();
				   session.setAttribute(Constant.APP_SESSION,user);
				*/
				
			} catch (UnknownAccountException e) {
				emsg="用户名出错！";
			}catch (IncorrectCredentialsException e) {
				emsg="密码出错！";
			}catch (LockedAccountException e) {
				emsg="您的账户已被锁定，请联系管理员！";
			}catch (AuthenticationException  e) {
				emsg="其他错误："+e.getMessage();
			}
			if(emsg!=null){
				data.put("status", "fail");
				data.put("version", gtSdk.getVersionInfo());
				data.put("emsg", emsg);
			}else{
				data.put("status", "success");
				data.put("version", gtSdk.getVersionInfo());
			}
			out.println(data.toString());
		}
		else {
			// 验证失败
			JSONObject data = new JSONObject();
			try {
				data.put("status", "fail");
				data.put("version", gtSdk.getVersionInfo());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println(data.toString());
		}

	}
}
