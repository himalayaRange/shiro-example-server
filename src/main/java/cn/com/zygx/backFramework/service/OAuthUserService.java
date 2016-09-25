package cn.com.zygx.backFramework.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.OAuth2UserDao;
import cn.com.zygx.backFramework.model.Oauth2User;

@Service
public class OAuthUserService implements BaseService<Oauth2User>{
	
	private static final String classDesc="OAuth用户表";
	
	@Autowired
	private OAuth2UserDao oAuth2UserDao;

	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.oAuth2UserDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(Oauth2User entity) {
		try {
			return this.oAuth2UserDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(Oauth2User entity) {
		try {
			return this.oAuth2UserDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(Oauth2User entity) {
		try {
			return this.oAuth2UserDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(Oauth2User entity) {
		try {
			return this.oAuth2UserDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Oauth2User selectByPrimaryKey(Integer id) {
		try {
			return (Oauth2User) this.oAuth2UserDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public List<Oauth2User> query(Oauth2User entity) {
		try {
			return this.oAuth2UserDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(Oauth2User entity) {
		return null;
	}

	public Oauth2User findByUsername(String username){
			return this.oAuth2UserDao.findByUsername(username);
	}

}
