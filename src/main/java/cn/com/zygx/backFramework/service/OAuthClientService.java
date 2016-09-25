package cn.com.zygx.backFramework.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.OAuth2ClientDao;
import cn.com.zygx.backFramework.model.Oauth2Client;

@Service
public class OAuthClientService implements BaseService<Oauth2Client>{
	
	private static final String classDesc="OAuth客户端";
	
	@Autowired
	private OAuth2ClientDao Oauth2ClientDao;

	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.Oauth2ClientDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(Oauth2Client entity) {
		try {
			return this.Oauth2ClientDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(Oauth2Client entity) {
		try {
			return this.Oauth2ClientDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(Oauth2Client entity) {
		try {
			return this.Oauth2ClientDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(Oauth2Client entity) {
		try {
			return this.Oauth2ClientDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Oauth2Client selectByPrimaryKey(Integer id) {
		try {
			return (Oauth2Client) this.Oauth2ClientDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public List<Oauth2Client> query(Oauth2Client entity) {
		try {
			return this.Oauth2ClientDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(Oauth2Client entity) {
		return null;
	}
	
	// 根据客户端id 查找客户端
	public Oauth2Client findByClientId(String clientId){
		return this.Oauth2ClientDao.findByClientId(clientId);
	}
	
	//根据客户端安全KEY 查找客户端
	public Oauth2Client findByClientSecret(String clientSecret){
		return this.Oauth2ClientDao.findByClientSecret(clientSecret);
	}

}
