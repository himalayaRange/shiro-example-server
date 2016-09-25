package cn.com.zygx.backFramework.dao;

import org.apache.shiro.session.Session;

import cn.com.zygx.backFramework.db.mybatis.MyBatisRepository;

/**
 *  shiro会话持久化到数据库中或者持久化到redis中
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */
@MyBatisRepository
public interface MySessionDAO {

	//创建会话
	public void create(Session session)throws Exception;
	
	//删除会话
	public int delete(String sessionId)throws Exception;
	
	//修改会话
	public int update(Session session)throws Exception;
	
	//查询会话
	public Session readSession(String sessionId)throws Exception;
	
}
