package cn.com.zygx.backFramework.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.BaseService;
import cn.com.zygx.backFramework.common.util.LoggerUtil;
import cn.com.zygx.backFramework.dao.IResourcesDao;
import cn.com.zygx.backFramework.model.Resources;

@Service
public class ResourcesService implements BaseService<Resources>{
	
	private static final String classDesc="资源表";
	
	@Autowired
	private IResourcesDao ResourcesDao;

	@Override
	public Integer deleteWL(Integer id) {
		try {
			return this.ResourcesDao.deleteWL(id);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("物理删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
		
	}

	@Override
	public Integer delete(Resources entity) {
		try {
			return this.ResourcesDao.delete(entity);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("状态删除异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer insert(Resources entity) {
		try {
			return this.ResourcesDao.insert(entity);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}
	
	@Override
	public Integer insertSelective(Resources entity) {
		try {
			return this.ResourcesDao.insertSelective(entity);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("插入异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Integer update(Resources entity) {
		try {
			return this.ResourcesDao.update(entity);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("更新异常").toString(), e);
			return Constant.DB_ERROR;
		}
	}

	@Override
	public Resources selectByPrimaryKey(Integer id) {
		try {
			return (Resources) this.ResourcesDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("主键查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public List<Resources> query(Resources entity) {
		try {
			return this.ResourcesDao.query(entity);
		} catch (Exception e) {
			LoggerUtil.info(ResourcesService.class, new StringBuffer().append(classDesc).append("list查询异常").toString(), e);
			return null;
		}
	}

	@Override
	public Map<String, Object> queryPage(Resources entity) {
		return null;
	}

	/***********************************/
	
	public List<Resources> listResource() {
		return this.ResourcesDao.listResource();
	}

	/**
	 * 根据资源id获取权限列表
	 * @param @param resourceIds
	 * @param @return
	 */
    public Set<String> findPermissions(Set<Resources> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Resources resource : resourceIds) {
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }
	

}
