package cn.com.zygx.backFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {
	
	private Cache cache;
	
	@Autowired
	private OAuthClientService clientService;
	
	//注入缓存
	@Autowired
	private void OAuthClientService(CacheManager  cacheManager){
		this.cache=cacheManager.getCache("code-cache");
	}
	
	// 添加auth code
	public void addAuthCode(String authCode, String username){
		cache.put(authCode, username);
	}
	
	//添加AccessToken
	public void addAccessToken(String accessToken,String username){
		cache.put(accessToken,username);
	}

	// 验证auth code是否有效
	public Boolean checkAuthCode(String authCode){
		
		return cache.get(authCode)!=null;
	}
	
	// 验证access token是否有效
	public Boolean checkAccessToken(String accessToken){
		
		return cache.get(accessToken)!=null;
	}
	
	// 根据auth code 获取用户名
	public String getUsernameByAuthCode(String authCode){
		return (String)cache.get(authCode).get();
	}
	
	// 根据access token获取用户名
	public String getUsernameByAccessToken(String accessToken){
		return (String)cache.get(accessToken).get();
	}
	
	//auth code / access token 过期时间
	public Long getExpireIn(){
		
		return 1800L;
	}
	
	// 检查客户端id 是否存在
	public Boolean checkClientId(String clientId){
		
		return clientService.findByClientId(clientId)!=null;
	}
	
	//检查客户端安全KEY是否存在
	public Boolean checkClientSecret(String clientSecret){
		
		return clientService.findByClientSecret(clientSecret)!=null;
	}
}
