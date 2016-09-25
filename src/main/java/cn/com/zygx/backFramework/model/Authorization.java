package cn.com.zygx.backFramework.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import cn.com.zygx.backFramework.common.context.BaseEntity;

/**
 * 应用授权
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
public class Authorization extends BaseEntity{

	private static final long serialVersionUID = 816647809584007727L;

	private Long id;

    private Long user_id;

    private Long app_id;

    private List<Long> roleIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getApp_id() {
        return app_id;
    }

    public void setApp_id(Long app_id) {
        this.app_id = app_id;
    }

    public List<Long> getRoleIds() {
        if(roleIds == null) {
            roleIds = new ArrayList<Long>();
        }
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }


    public String getRoleIdsStr() {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }

    public void setRoleIdsStr(String roleIdsStr) {
        if(StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdStr));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorization that = (Authorization) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

}