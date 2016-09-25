package cn.com.zygx.backFramework.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.tree.Node;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.ISysMenuDao;

@Service
public class SysMenuService implements BaseService<Node>{

	private static final String classDesc="系统菜单表";
	
	@Autowired
	private ISysMenuDao SysMenuDao;

	
	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.SysMenuDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(Node entity) {
		try {
			return this.SysMenuDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(Node entity) {
		try {
			return this.SysMenuDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(Node entity) {
		try {
			return this.SysMenuDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(Node entity) {
		try {
			return this.SysMenuDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Node selectByPrimaryKey(Integer id) {
		try {
			return (Node) this.SysMenuDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<Node> query(Node entity) {
		try {
			return this.SysMenuDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(SysMenuService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(Node entity) {
		return null;
	}


}
