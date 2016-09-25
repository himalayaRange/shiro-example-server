package cn.com.zygx.backFramework.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * shiro注解
 * @author wangyi
   @date 2016-8-26
 *
 */

@Controller
@RequestMapping("/admin")
public class AnnotationController {

	//需要AFDMIN角色
	@RequiresRoles(value="[ADMIN]")
	@RequestMapping("/annotation_role")
	public void annotation_role(){
		System.out.println("=========具有ADMIN角色才能访问！======");
	}
	
	//需要登陆
	@RequestMapping("/annotation_auth")
	@RequiresAuthentication
	public void annotation_auth(){
		System.out.println("============需要登陆============");
	}
	
	
}
