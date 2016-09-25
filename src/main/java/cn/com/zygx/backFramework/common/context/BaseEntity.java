package cn.com.zygx.backFramework.common.context;

import java.util.Date;

/**
 * 基类
 * @author wangyi
 * @date 2016-7-15 上午11:43:25
 */
@SuppressWarnings("serial")
public class BaseEntity extends PageEntity {
	
    private Date create_date;

    private Date update_date;

    private Boolean is_valid;

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Boolean getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(Boolean is_valid) {
		this.is_valid = is_valid;
	}
    
    
	
}
