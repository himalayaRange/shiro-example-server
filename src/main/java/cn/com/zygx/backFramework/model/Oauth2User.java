package cn.com.zygx.backFramework.model;

import cn.com.zygx.backFramework.common.context.BaseEntity;

/**
 * 用户:存储认证/资源服务器的用户信息，即资源的拥有者
 * @author wangyi
   @date 2016-9-8
 *
 */
public class Oauth2User extends BaseEntity{
    
	private static final long serialVersionUID = -4459531238211084084L;

	private Long id;

    private String username;

    private String password;

    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}