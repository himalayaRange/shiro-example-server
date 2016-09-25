package cn.com.zygx.backFramework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.zygx.backFramework.db.mybatis.MyBatisRepository;
import cn.com.zygx.backFramework.model.App;

@MyBatisRepository
public interface AppDAO {
 	public App createApp(App app);
  	
    public App updateApp(App app);
    
    public void deleteApp(@Param("appId")Long appId);

    public App findOne(@Param("appId")Long appId);
    
    public List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}
