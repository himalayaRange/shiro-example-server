package cn.com.zygx.backFramework.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.dao.AppDAO;
import cn.com.zygx.backFramework.model.App;

/**
 * AppService
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
@Service
public class AppService {

  	@Autowired
    private AppDAO appDao;

    public App createApp(App app) {
        return appDao.createApp(app);
    }

    public App updateApp(App app) {
        return appDao.updateApp(app);
    }

    public void deleteApp(Long appId) {
        appDao.deleteApp(appId);
    }

    public App findOne(Long appId) {
        return appDao.findOne(appId);
    }

    public List<App> findAll() {
        return appDao.findAll();
    }

    public Long findAppIdByAppKey(String appKey) {
        return appDao.findAppIdByAppKey(appKey);
    }
}
