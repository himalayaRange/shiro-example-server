package cn.com.zygx.backFramework.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.com.zygx.backFramework.db.mybatis.MyBatisRepository;
import cn.com.zygx.backFramework.model.Authorization;

@MyBatisRepository
public interface AuthorizationDAO {
	
	public Authorization createAuthorization(Authorization authorization);
    
	public Authorization updateAuthorization(Authorization authorization);
    
	public void deleteAuthorization(@Param("authorizationId")Long authorizationId);

    public Authorization findOne(@Param("authorizationId")Long authorizationId);
    
    public List<Authorization> findAll();

    public Authorization findByAppUser(@Param("appId")Long appId, @Param("userId")Long userId);
}
