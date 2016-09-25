package cn.com.zygx.backFramework.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 扩展UsernamepasswordToken,通过传入的类型来解决多个ream的认证和授权跳转
 * <p>User: wangyi
 * <p>Date: 2016-9-23
 * <p>Version: 1.0
 */
public class DefaultUsernamePasswordToken extends UsernamePasswordToken{
	
	private static final long serialVersionUID = -7172944738829227487L;

	/**
	 * 登录类型
	 */
	private String loginType;

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	/**
	 * 构造方法
	 * @param username
	 * @param password
	 */
	public DefaultUsernamePasswordToken(String username,String password){
		super(username,password);
	}
	
	public DefaultUsernamePasswordToken(){
		
	}
	
}
