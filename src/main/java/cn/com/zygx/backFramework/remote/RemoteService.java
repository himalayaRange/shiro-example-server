package cn.com.zygx.backFramework.remote;

import java.io.Serializable;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.zygx.backFramework.service.AuthorizationService;
import com.github.wangyi.shiro.remote.PermissionContext;
import com.github.wangyi.shiro.remote.RemoteServiceInterface;

public class RemoteService implements RemoteServiceInterface {

	@Autowired
    private SessionDAO sessionDAO;
	
	@Autowired
	AuthorizationService authorizationService;
	
	@Override
	public Session getSession(String appKey, Serializable sessionId) {
		return sessionDAO.readSession(sessionId);
	}

	@Override
	public Serializable createSession(Session session) {
		return sessionDAO.create(session);
	}

	@Override
	public void updateSession(String appKey, Session session) {
		sessionDAO.update(session);
	}

	@Override
	public void deleteSession(String appKey, Session session) {
		sessionDAO.delete(session);
	}

    public PermissionContext getPermissions(String appKey, String username) {
        PermissionContext permissionContext = new PermissionContext();
        permissionContext.setRoles(authorizationService.findRoles(appKey, username));
        permissionContext.setPermissions(authorizationService.findPermissions(appKey, username));
        return permissionContext;
    }
}
