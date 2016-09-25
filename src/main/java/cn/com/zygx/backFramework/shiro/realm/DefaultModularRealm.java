package cn.com.zygx.backFramework.shiro.realm;

import java.util.Map;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;
import cn.com.zygx.backFramework.common.Constant;

/**
 * 多个Realm统一入口
 * <p>User: wangyi
 * <p>Date: 2016-9-23
 * <p>Version: 1.0
 */
public class DefaultModularRealm extends ModularRealmAuthenticator{

	private Map<String,Object> definedRealms;
	
	/**
	 * 调用单个realm操作
	 */
	@Override
	protected AuthenticationInfo doSingleRealmAuthentication(Realm realm,
			AuthenticationToken token) {
		if(!realm.supports(token)){
			throw new ShiroException("token错误！");
		}
		AuthenticationInfo info = null; 
		try {
			info = realm.getAuthenticationInfo(token);
			if(info==null){
				throw new ShiroException("token不存在!");  
			}
		} catch (Exception e) {
			 throw new ShiroException("用户名或者密码错误!");  
		}
		
		return info;
	}

	
	@Override
	protected AuthenticationInfo doAuthenticate(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		this.assertRealmsConfigured();
		Realm realm=null;
		DefaultUsernamePasswordToken 	token=(DefaultUsernamePasswordToken)authenticationToken;
		if(token.getLoginType().equals(Constant.LOGIN_TYPE_REMOTE)){
			realm=(Realm)this.definedRealms.get(Constant.LOGIN_TYPE_REMOTE);
		}
		if(token.getLoginType().equals(Constant.LOGIN_TYPE_USER)){
			realm=(Realm)this.definedRealms.get(Constant.LOGIN_TYPE_USER);
		}
		if(realm==null){
			return null;
		}
		
		return this.doSingleRealmAuthentication(realm, token);
	}
	
	/**
	 * 判断realm是否为空
	 */
	@Override
	protected void assertRealmsConfigured() throws IllegalStateException {
		this.definedRealms=this.getDefinedRealms();
		if (CollectionUtils.isEmpty(this.definedRealms)) {  
            throw new ShiroException("值传递错误!");  
        }  
	}


	public Map<String, Object> getDefinedRealms() {
		return definedRealms;
	}


	public void setDefinedRealms(Map<String, Object> definedRealms) {
		this.definedRealms = definedRealms;
	}

	
	
	
	
	
}
