package cn.com.zygx.backFramework.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.com.zygx.backFramework.model.Resources;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.service.UserService;

/**
 * 自定义realm
 * @author wangyi
   @date 2016-8-23
 *
 */
@Component
public class UserRealm  extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	/*
	 * 授权
	 * Q1:用户访问的权限是通过数据库进行授权的，通过shiro的缓存解决效率问题
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
			User user=(User) (principals.getPrimaryPrincipal());
			System.out.println("-------"+user.getId()+"---"+user.getNickname());
			int uid = user.getId();
			//和spring集成后就可以自动注入 userService =(UserService)ShiroKit.getBean("userService");
			List<String> roles = userService.listRoleSNByUser(uid);    //登录用户所有角色
			List<Resources> res = userService.listAllResources(uid);  //登录用户的所有资源
			List<String> permissions=new ArrayList<String>();
			for(Resources rr:res){
				permissions.add(rr.getUrl());
			}
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			info.setRoles(new HashSet<String>(roles));
			info.setStringPermissions(new HashSet<String>(permissions));
			return info;
	}

	
	/*
	 * 认证
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
			/*
			 * 通过ApplicationContext动态获取
			 * userService =(UserService)ShiroKit.getBean("userService");
			 */
			//通过subject.login传入username,password
			String username=(String)token.getPrincipal();
			String password=new String((char[])token.getCredentials());
			System.out.println(userService+"-----------");
			User user = userService.login(username, password);
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
			info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername())); //设置盐值
			return info;
	}

	
	//清除授权信息,存的是对象
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		/*Cache<Object, AuthorizationInfo> cache = this.getAuthorizationCache();
		Set<Object> set = cache.keys();
		for(Object key:set){
			try {
				System.out.println("授权信息："+ObjectsUtil.stringhelper(key)+"--"+ObjectsUtil.stringhelper(cache.get(key)));
			} catch (CacheException | IllegalArgumentException
					| IllegalAccessException e) {
			}
		}*/
		System.out.println("=====清除授权信息======");
	}

	//清除认证信息，存的是用户名
	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		/*Cache<Object, AuthenticationInfo> cache = this.getAuthenticationCache();
		Set<Object> set = cache.keys();
		for(Object key:set){
			try {
				System.out.println("认证信息："+ObjectsUtil.stringhelper(key)+"--"+ObjectsUtil.stringhelper(cache.get(key)));
			} catch (CacheException | IllegalArgumentException
					| IllegalAccessException e) {
			}
		}*/
		User user=(User)principals.getPrimaryPrincipal();
		SimplePrincipalCollection spc=new SimplePrincipalCollection(user.getUsername(),this.getName());
		System.out.println("=======清除认证信息=======");
		super.clearCachedAuthenticationInfo(spc);
	}

	
	
}
