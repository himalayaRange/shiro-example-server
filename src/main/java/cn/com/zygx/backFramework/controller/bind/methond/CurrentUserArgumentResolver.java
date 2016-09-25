package cn.com.zygx.backFramework.controller.bind.methond;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import cn.com.zygx.backFramework.controller.bind.annotation.CurrentUser;

/**
 * 用于绑定当前用户的方法解析器
 * 
 * <p>User: wangyi
 * <p>Date: 2016-9-14
 * <p>Version: 1.0
 */

public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver{

	
	public CurrentUserArgumentResolver(){
		
	}
	
	/**
	 * 支持的注解 CurrentUser | FormModel
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.hasParameterAnnotation(CurrentUser.class)){
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
				CurrentUser currentUser = parameter.getParameterAnnotation(CurrentUser.class);
				Subject subject=SecurityUtils.getSubject();
				return subject.getSession().getAttribute(currentUser.value());
			}

}
