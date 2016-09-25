package cn.com.zygx.backFramework.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

/**
 *  因为是多项目登录，比如如果是从其他应用中重定向过来的，首先检查Session 中是否有
	authc.fallbackUrl属性，如果有就认为它是默认的重定向地址；否则使用Server 自己的
	successUrl作为登录成功后重定向到的地址。
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
public class ServerFormAuthenticationFilter extends FormAuthenticationFilter{

	 protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		 String fallbackUrl= (String)getSubject(request, response).getSession().getAttribute("authc.fallbackUrl");
		 if(StringUtils.isEmpty(fallbackUrl)){
			 fallbackUrl=getSuccessUrl();
		 }
		 WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
	 }
}
