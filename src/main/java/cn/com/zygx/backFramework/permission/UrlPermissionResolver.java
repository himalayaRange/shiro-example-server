package cn.com.zygx.backFramework.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/*
 * 解析自定义Permission
 */
public class UrlPermissionResolver implements PermissionResolver{

	@Override
	public Permission resolvePermission(String permissionString) {
		if(permissionString.startsWith("/")){
			return new UrlPermission(permissionString);
		}
		return new WildcardPermission(permissionString); //默认
	}

}
