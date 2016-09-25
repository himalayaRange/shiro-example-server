package cn.com.zygx.backFramework.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.ISysDicDao;
import cn.com.zygx.backFramework.model.SysDic;

@Service
public class SysDicService implements BaseService<SysDic>{

	private static final String classDesc="字典表";
	
	@Autowired
	private ISysDicDao SysDicDao;

	
	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.SysDicDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(SysDic entity) {
		try {
			return this.SysDicDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(SysDic entity) {
		try {
			return this.SysDicDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(SysDic entity) {
		try {
			return this.SysDicDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(SysDic entity) {
		try {
			return this.SysDicDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public SysDic selectByPrimaryKey(Integer id) {
		try {
			return (SysDic) this.SysDicDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<SysDic> query(SysDic entity) {
		try {
			return this.SysDicDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(SysDic entity) {
		return null;
	}


}
