package cn.com.zygx.backFramework.model;

import cn.com.zygx.backFramework.common.context.BaseEntity;

/*
 * 字典菜单表
 */
public class SysDicMenu extends BaseEntity{

	private static final long serialVersionUID = 4289603821042023040L;

	private Integer id;

    private String dic_code;

    private String dic_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDic_code() {
        return dic_code;
    }

    public void setDic_code(String dic_code) {
        this.dic_code = dic_code == null ? null : dic_code.trim();
    }

    public String getDic_name() {
        return dic_name;
    }

    public void setDic_name(String dic_name) {
        this.dic_name = dic_name == null ? null : dic_name.trim();
    }

}