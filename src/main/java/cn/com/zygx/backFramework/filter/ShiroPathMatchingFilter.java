package cn.com.zygx.backFramework.filter;

import java.util.Arrays;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.PathMatchingFilter;

/**
 * shiro过滤器（匹配路径）
 * @author wangyi
   @date 2016-8-25
 *
 */
public class ShiroPathMatchingFilter extends PathMatchingFilter{

	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		System.out.println("path matching...");
		System.out.println(Arrays.toString((String[])mappedValue));
		return super.onPreHandle(request, response, mappedValue);
	}

	
}
