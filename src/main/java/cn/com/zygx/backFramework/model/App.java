package cn.com.zygx.backFramework.model;

import cn.com.zygx.backFramework.common.context.BaseEntity;
/**
 * 应用App
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
public class App extends BaseEntity{
	
	private static final long serialVersionUID = 8745572882161009567L;

	private Long id;

    private String name;

    private String app_key;

    private String app_secret;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key == null ? null : app_key.trim();
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret == null ? null : app_secret.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}