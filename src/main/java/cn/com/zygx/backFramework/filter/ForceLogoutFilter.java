package cn.com.zygx.backFramework.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import cn.com.zygx.backFramework.common.Constant;

public class ForceLogoutFilter extends AccessControlFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		  Session session = getSubject(request, response).getSession(false);
		  if(session==null){
			  //如果session为空，无需执行后续onAccessDenied方法
			  return true;
		  }
		  return session.getAttribute(Constant.SESSION_FORCE_LOGOUT_KEY) == null;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		try {
			getSubject(request, response).logout();
			return true;
		} catch (Exception e) {
			/**ignore exception*/
			String loginUrl = getLoginUrl()+(getLoginUrl().contains("?")?"&":"?")+"forceLogout=1";
			WebUtils.issueRedirect(request, response, loginUrl);
			return false;
		}
	}

}
