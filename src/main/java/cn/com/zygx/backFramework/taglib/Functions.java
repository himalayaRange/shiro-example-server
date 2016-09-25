package cn.com.zygx.backFramework.taglib;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.util.CollectionUtils;
import cn.com.zygx.backFramework.common.Constant;

/**
 * 自定义标签
 * <p>User: wangyi
 * <p>Date: 2016-9-21
 * <p>Version: 1.0
 */

public class Functions {

	public static boolean in(Iterable iterable,Object element ){
		  if(iterable == null) {
	            return false;
	        }
	        return CollectionUtils.contains(iterable.iterator(), element);
	}
	
	public static String principal(Session session) {
        PrincipalCollection principalCollection =(PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        
        return (String)principalCollection.getPrimaryPrincipal();
    }
	
	 public static boolean isForceLogout(Session session) {
	        return session.getAttribute(Constant.SESSION_FORCE_LOGOUT_KEY) != null;
	    }
	 
}
