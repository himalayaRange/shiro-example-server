package cn.com.zygx.backFramework.dao;

import org.apache.ibatis.annotations.Param;
import cn.com.zygx.backFramework.common.base.FrameworkDao;
import cn.com.zygx.backFramework.db.mybatis.MyBatisRepository;
import cn.com.zygx.backFramework.model.Oauth2Client;

@MyBatisRepository
public interface OAuth2ClientDao extends FrameworkDao {

	Oauth2Client findByClientId(@Param("clientId")String clientId);// 根据客户端id 查找客户端
	Oauth2Client findByClientSecret(@Param("clientSecret")String clientSecret);//根据客户端安全KEY 查找客户端
	
}
