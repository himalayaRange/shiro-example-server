package cn.com.zygx.backFramework.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * 权限认证过滤器
 * @author wangyi
   @date 2016-8-25
 *
 */
public class ResourcesCheckFilter extends AccessControlFilter {

	private String errorUrl;//未授权跳转页面
	
	
	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		 Subject subject = getSubject(request, response);
		 String url = getPathWithinApplication(request);
		 System.out.println(url+"--------------");
		 //讲url和Realm已经授权的权限进行比较,授权则继续，未授权则执行onAccessDenied
		 return subject.isPermitted(url);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletResponse hsp=(HttpServletResponse)response;
		HttpServletRequest  hrq=(HttpServletRequest)request;
		hsp.sendRedirect(hrq.getContextPath()+this.getErrorUrl());
		return false;
	}

}
