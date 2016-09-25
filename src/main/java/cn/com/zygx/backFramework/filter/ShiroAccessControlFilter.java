package cn.com.zygx.backFramework.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * Shiro过滤器
 * @author wangyi
   @date 2016-8-25
 *
 */
public class ShiroAccessControlFilter extends AccessControlFilter{

	//认证或者授权判断过滤器
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		System.out.println("check auth");
		return true;
	}

	//认证或者授权失败，即不允许继续操作，此处进行页面错误页面的跳转
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("find error!");
		return false;
	}

}
