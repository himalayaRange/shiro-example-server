package cn.com.zygx.backFramework.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.ISysDicMenuDao;
import cn.com.zygx.backFramework.model.SysDicMenu;

@Service
public class SysDicMenuService implements BaseService<SysDicMenu>{

	private static final String classDesc="字典菜单表";
	
	@Autowired
	private ISysDicMenuDao SysDicMenuDao;

	
	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.SysDicMenuDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(SysDicMenu entity) {
		try {
			return this.SysDicMenuDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(SysDicMenu entity) {
		try {
			return this.SysDicMenuDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(SysDicMenu entity) {
		try {
			return this.SysDicMenuDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(SysDicMenu entity) {
		try {
			return this.SysDicMenuDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public SysDicMenu selectByPrimaryKey(Integer id) {
		try {
			return (SysDicMenu) this.SysDicMenuDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<SysDicMenu> query(SysDicMenu entity) {
		try {
			return this.SysDicMenuDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysDicMenuService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(SysDicMenu entity) {
		return null;
	}


}
