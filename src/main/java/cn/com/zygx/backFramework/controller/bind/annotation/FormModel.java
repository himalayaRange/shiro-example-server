package cn.com.zygx.backFramework.controller.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表单数据绑定
 * 对于多个对象，可以通过 p.param ....
 *  * <form action="index" method="post">
	<input type="text" name="p.name" />
	<input type="text" name="name" />
	<input type="text" name="p.age" />
	<input type="text" name="weight" />
	<input type="text" name="p.height" />
	<input type="submit" value="提交"/>
	</form>
 * <p>User: wangyi
 * <p>Date: 2016-9-14
 * <p>Version: 1.0
 */

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormModel {
	
	String value() ;
	
}
