package cn.com.zygx.backFramework.model;


import cn.com.zygx.backFramework.common.context.BaseEntity;

/*
 * 字典表
 */
public class SysDic extends BaseEntity{
	
		private static final long serialVersionUID = 1123179555157693780L;

		private Integer id;

	    private String dic_code;

	    private Integer dic_value;

	    private String dic_label;

	    private Integer orders;


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

	    public Integer getDic_value() {
	        return dic_value;
	    }

	    public void setDic_value(Integer dic_value) {
	        this.dic_value = dic_value;
	    }

	    public String getDic_label() {
	        return dic_label;
	    }

	    public void setDic_label(String dic_label) {
	        this.dic_label = dic_label == null ? null : dic_label.trim();
	    }

	    public Integer getOrders() {
	        return orders;
	    }

	    public void setOrders(Integer orders) {
	        this.orders = orders;
	    }

	}