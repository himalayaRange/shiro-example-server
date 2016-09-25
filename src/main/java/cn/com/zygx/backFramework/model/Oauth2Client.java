package cn.com.zygx.backFramework.model;

import cn.com.zygx.backFramework.common.context.BaseEntity;
/**
 * 客户端信息：存储客户端ID和安全秘钥，进行授权的时候使用
 * @author wangyi
   @date 2016-9-8
 *
 */
public class Oauth2Client extends BaseEntity{

	private static final long serialVersionUID = 2785829691963738185L;

	private Long id;

    private String client_name;

    private String client_id;

    private String client_secret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name == null ? null : client_name.trim();
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id == null ? null : client_id.trim();
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret == null ? null : client_secret.trim();
    }
}