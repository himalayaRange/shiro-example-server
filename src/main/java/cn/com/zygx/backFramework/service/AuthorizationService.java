package cn.com.zygx.backFramework.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.dao.AuthorizationDAO;
import cn.com.zygx.backFramework.model.Authorization;
import cn.com.zygx.backFramework.model.User;

@Service
public class AuthorizationService {

		 @Autowired
		 private AuthorizationDAO authorizationDao;
		 
		 @Autowired
		 private UserService userService;
	     
		 @Autowired
	     private RoleService roleService;
		 
		 @Autowired
		 private AppService appService;
	 
	 	public Authorization createAuthorization(Authorization authorization) {
	        return merge(authorization);
	    }

	    public Authorization updateAuthorization(Authorization authorization) {
	        return merge(authorization);
	    }

	    public Authorization merge(Authorization authorization) {
	        Authorization dbAuthorization = authorizationDao.findByAppUser(authorization.getApp_id(), authorization.getUser_id());
	        if(dbAuthorization ==  null) {//如果数据库中不存在相应记录 直接新增
	            return authorizationDao.createAuthorization(authorization);
	        }

	        if(dbAuthorization.equals(authorization)) {//如果是同一条记录直接更新即可
	            return authorizationDao.updateAuthorization(authorization);
	        }

	        for(Long roleId : authorization.getRoleIds()) {//否则合并
	            if(!dbAuthorization.getRoleIds().contains(roleId)) {
	                dbAuthorization.getRoleIds().add(roleId);
	            }
	        }

	        if(dbAuthorization.getRoleIds().isEmpty()) {//如果没有角色 直接删除记录即可
	            authorizationDao.deleteAuthorization(dbAuthorization.getId());
	            return dbAuthorization;
	        }
	        //否则更新
	        return authorizationDao.updateAuthorization(dbAuthorization);
	    }

	    public void deleteAuthorization(Long authorizationId) {
	        authorizationDao.deleteAuthorization(authorizationId);
	    }

	    public Authorization findOne(Long authorizationId) {
	        return authorizationDao.findOne(authorizationId);
	    }

	    public List<Authorization> findAll() {
	        return authorizationDao.findAll();
	    }

	    /**
	     * 根据用户名查找其角色
	     * @param username
	     * @return
	     */
	    public Set<String> findRoles(String appKey, String username) {
	        User user = userService.loadByUsername(username);
	        if(user == null) {
	            return Collections.EMPTY_SET;
	        }
	        Long appId = appService.findAppIdByAppKey(appKey);
	        if(appId == null) {
	            return Collections.EMPTY_SET;
	        }
	        Authorization authorization = authorizationDao.findByAppUser(appId, Long.valueOf(user.getId()));
	        if(authorization == null) {
	            return Collections.EMPTY_SET;
	        }
	        return roleService.findRoles(authorization.getRoleIds().toArray(new Long[0]));
	    }
	    
	    /**
	     * 根据用户名查找其权限
	     * @param username
	     * @return
	     */
	    public Set<String> findPermissions(String appKey, String username) {
	        User user = userService.loadByUsername(username);
	        if(user == null) {
	            return Collections.EMPTY_SET;
	        }
	        Long appId = appService.findAppIdByAppKey(appKey);
	        if(appId == null) {
	            return Collections.EMPTY_SET;
	        }
	        Authorization authorization = authorizationDao.findByAppUser(appId, Long.valueOf(user.getId()));
	        if(authorization == null) {
	            return Collections.EMPTY_SET;
	        }
	        return roleService.findPermissions(authorization.getRoleIds().toArray(new Long[0]));
	    }
}
