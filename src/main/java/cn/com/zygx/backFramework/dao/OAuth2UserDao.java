package cn.com.zygx.backFramework.dao;

import org.apache.ibatis.annotations.Param;
import cn.com.zygx.backFramework.common.base.FrameworkDao;
import cn.com.zygx.backFramework.db.mybatis.MyBatisRepository;
import cn.com.zygx.backFramework.model.Oauth2User;

@MyBatisRepository
public interface OAuth2UserDao extends FrameworkDao {
	
	public Oauth2User findByUsername(@Param("username")String username);
	
	
}
