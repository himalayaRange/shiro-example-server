package org.zygx.shiro.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.com.zygx.backFramework.common.guava.base.ObjectsUtil;
import cn.com.zygx.backFramework.common.jackson.JsonUtil;
import cn.com.zygx.backFramework.model.Resources;
import cn.com.zygx.backFramework.model.Role;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.service.PasswordHelper;
import cn.com.zygx.backFramework.service.ResourcesService;
import cn.com.zygx.backFramework.service.RoleService;
import cn.com.zygx.backFramework.service.UserService;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class SpringTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourcesService resourcesService;
	
	@Autowired
	private PasswordHelper passwordHelper;
	
	//添加用户
	@Test
	public void userTest(){
		User user=new User();
		user.setUsername("ls");
		user.setPassword("123");
		user.setNickname("李四");
		user.setStatus(1);
		Integer insert = userService.insert(user);
		System.out.println("result:----"+insert);
	}
	
	//查询角色用户
	@Test
	public void testRoleUser() throws IllegalArgumentException, IllegalAccessException{
		
		for(User user:userService.listByRole(2)){
			System.out.println(ObjectsUtil.stringhelper(user));
		}
	}
	
	//查询用户的所有角色命名空间
	@Test
	public void testRoleSNByUser(){
		List<String> sns = userService.listRoleSNByUser(3);
		for(String sn:sns){
			System.out.println(sn);
		}
	}
	
	
	//添加角色
	@Test
	public void roleTest(){
		Role role=new Role();
		role.setName("审核组");
		System.out.println(roleService.insert(role));
	}
	
	//添加用户角色
	@Test
	public void testAddUserRole(){
		roleService.addUserRole(1, 2);
		roleService.addUserRole(2, 1);
		roleService.addUserRole(3, 2);
		roleService.addUserRole(3, 3);
	}
	
	@Test
	public void testRoleByUser() throws IllegalArgumentException, IllegalAccessException{
		List<Role> userRoles = roleService.listByUseRole(3);  //用户角色
		for(Role role:userRoles){
			System.out.println(ObjectsUtil.stringhelper(role));
		}
		System.out.println(JsonUtil.toJsonString(userRoles));
	}
	
	//添加资源
	@Test
	public void testAddResources(){
		Resources rs=new Resources();
		rs.setName("系统管理");
		rs.setUrl("/admin/*");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("用户管理");
		rs.setUrl("/admin/user/*");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("用户添加");
		rs.setUrl("/admin/user/add");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("用户删除");
		rs.setUrl("/admin/user/delete");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("角色管理");
		rs.setUrl("/admin/role/*");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("角色添加");
		rs.setUrl("/admin/role/add");
		resourcesService.insert(rs);
		
		rs=new Resources();
		rs.setName("角色修改");
		rs.setUrl("/admin/role/update");
		resourcesService.insert(rs);
	}
	
	//添加角色资源
	@Test
	public void testAddRoleResources(){
		roleService.addRoleResource(1, 1); //管理员
		
		roleService.addRoleResource(2, 2);//普通员工
		roleService.addRoleResource(2, 3);
		roleService.addRoleResource(2, 4);
		
		roleService.addRoleResource(3, 5); //测试组
		roleService.addRoleResource(3, 6); 
		roleService.addRoleResource(3, 7); 
	}
	
	//用户的访问所有资源
	@Test
	public void queryUserResources() throws IllegalArgumentException, IllegalAccessException{
		List<Resources> res = userService.listAllResources(3);
		for(Resources rs:res){
			System.out.println(ObjectsUtil.stringhelper(rs));
		}
	}
	
	//集合去重复
	@Test
	public void testList(){
		List<String> t1=Lists.newArrayList("A","B","Q","G");
		List<String> t2=Lists.newArrayList("A","B","C", "E", "D");
		List<String> deleteEle=Lists.newArrayList();
		List<String> addEle=Lists.newArrayList();
		deleteEle.addAll(t1);
		addEle.addAll(t2);
		deleteEle.removeAll(t2);
		addEle.removeAll(t1);
		
		System.out.println(deleteEle);
		System.out.println(addEle);
	}
	
	@Test
	public void testMd5() throws IllegalArgumentException, IllegalAccessException{
		System.out.println(ObjectsUtil.stringhelper(passwordHelper));
	}
	
}
