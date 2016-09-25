package cn.com.zygx.backFramework.controller.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cn.com.zygx.backFramework.common.Constant;

/**
 * 绑定当前的登录用户
 * 
 * <p>User: wangyi
 * <p>Date: 2016-9-14
 * <p>Version: 1.0
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

	
	/**
	 * 当前用户在request中的名字
	 * @param @return
	 */
	
	String value() default Constant.APP_SESSION ;
	
	
}
