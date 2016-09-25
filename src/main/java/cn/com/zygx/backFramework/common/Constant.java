package cn.com.zygx.backFramework.common;

/*
 * 系统常量
 */
public class Constant {
	
	/*
	 * 用户session信息
	 */
	public static final String SESSION_ADMIN="session_admin";
	
	/**
	 * 登出某个会话
	 */
	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
	
	public static final String URLSECURITY="security";

	//CURD异常返回值
	public static final Integer DB_ERROR = -1 ; 
	
	//数据是否有效
	public static final boolean VALIAD  = true;
	
	public static final boolean UVALIAD = false;

	//Shiro会话管理
	public static final String APP_SESSION="curr_session";
	

    public static String RESOURCE_SERVER_NAME = "shiro-project-server";
    
    public static final String INVALID_CLIENT_ID_DESCRIPTION = "客户端client_id验证失败";
    
    public static final String INVALID_CLIENT_SECRET_DESCRIPTION = "客户端安全KEY验证失败。";
    
    /**
     * 应用APPID
     */
    public static final String SERVER_APP_KEY = "645ba616-370a-43a8-a8e0-993e7a590cf0";
    
    /**
     * 多个realm登录的类型
     */
    public static final String LOGIN_TYPE_REMOTE="remoteRealm"; //远程服务Realm
    public static final String LOGIN_TYPE_USER="userRealm"; //当前系统登录realm
}
