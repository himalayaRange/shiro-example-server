package cn.com.zygx.backFramework.shiro.realm;

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
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.service.AuthorizationService;
import cn.com.zygx.backFramework.service.UserService;

/**
 * 对外服务登录realm
 * @author wangyi
   @date 2016-8-23
 *
 */
@Component
public class RemoteRealm  extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorizationService authorizationService;
	/*
	 * 授权
	 * Q1:用户访问的权限是通过数据库进行授权的，通过shiro的缓存解决效率问题
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
			String username = (String)principals.getPrimaryPrincipal();

	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	        authorizationInfo.setRoles(authorizationService.findRoles(Constant.SERVER_APP_KEY, username));
	        authorizationInfo.setStringPermissions(authorizationService.findPermissions(Constant.SERVER_APP_KEY, username));
	        return authorizationInfo;
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
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),this.getName());
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
