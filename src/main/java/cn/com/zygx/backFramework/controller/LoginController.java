package cn.com.zygx.backFramework.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.base.DAOException;
import cn.com.zygx.backFramework.common.guava.base.ObjectsUtil;
import cn.com.zygx.backFramework.common.jackson.JsonUtil;
import cn.com.zygx.backFramework.common.tree.Node;
import cn.com.zygx.backFramework.common.tree.Tree;
import cn.com.zygx.backFramework.controller.bind.annotation.CurrentUser;
import cn.com.zygx.backFramework.model.Resources;
import cn.com.zygx.backFramework.model.Role;
import cn.com.zygx.backFramework.model.User;
import cn.com.zygx.backFramework.service.PasswordHelper;
import cn.com.zygx.backFramework.service.ResourcesService;
import cn.com.zygx.backFramework.service.RoleService;
import cn.com.zygx.backFramework.service.SysMenuService;
import cn.com.zygx.backFramework.service.UserService;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private PasswordHelper passwordHelper;
    
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourcesService resourcesService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	
	
	/***************************************************************
	 *                                                             *
	 *                       登录页面                                                                                *               
	 *                                                             * 
	 ****************************************************************/
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "shiro/login";
	}
	
	@RequestMapping("/admin/index")
	public String index(ModelMap model) throws IllegalArgumentException, IllegalAccessException{
		Node node=new Node();
		node.setIs_valid(Constant.VALIAD);
		List<Node> nodes = sysMenuService.query(node);
		Tree tree=new Tree(nodes,nodes.get(0));
		Node build = tree.build();
		for(Node chil:build.getChildren()){
			System.out.println(ObjectsUtil.stringhelper(chil));
		}
		model.addAttribute("node", JsonUtil.toJsonString(build));
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/shiroAuth",method=RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request){
		Map<String,Object> map=Maps.newHashMap();
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		String rememberMe=(String)request.getParameter("rememberMe");
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		String emsg=null;
		try {
			if(Objects.equal(rememberMe, "true")){
				token.setRememberMe(true); //记住我
			}
			subject.login(token);
			/*
			 * Shiro 提供的会话可以用于JavaSE/JavaEE 环境，不依赖于任何底层容器，可以独立使用，是完整的会话模块，可直接替换Web容器的Session管理
			 */
			Session session = subject.getSession(); //默认如果没有创建sesssion会主动创建一个
			String id=(String)session.getId(); //当前会话的唯一标识。
			String host = session.getHost(); //Subject的主机地址，该地址是通过HostAuthenticationToken.getHost()提供的。
			long timeOut=session.getTimeout();
			System.out.println("ID:"+id+"=== host:"+host+"==timeOut:"+timeOut);
			
			
		} catch (UnknownAccountException e) {
			emsg="用户名出错！";
		}catch (IncorrectCredentialsException e) {
			emsg="密码出错！";
		}catch (LockedAccountException e) {
			emsg="您的账户已被锁定，请联系管理员！";
		}catch (AuthenticationException  e) {
			emsg="其他错误："+e.getMessage();
		}
		if(emsg!=null){
			map.put("success", false);
			map.put("emsg", emsg);
		}else{
			map.put("success", true);
		}
		if(request.getParameter("forceLogout")!=null){
			map.put("success", false);
			map.put("emsg", "您已经被管理员强制退出，请重新登录");
		}
		return map;
	}
	
	
	@RequestMapping("/admin/welcome")
	public String welcome(){
		
		return "common/welcome";
	}
	
	
	/***************************************************************
	 *                                                             *
	 *                       用户页面                                                                                *               
	 *                                                             * 
	 ****************************************************************/
	
	//user list
	@RequestMapping(value="admin/user/list",method=RequestMethod.GET)
	public String admin(HttpServletRequest request,ModelMap model){
		List<User> users = userService.listUser();
		for(User user:users){
			StringBuffer roleName=new StringBuffer();
			List<Role> roles = roleService.listByUseRole(user.getId());
			if(roles!=null&&roles.size()>0){
				for(Role role:roles){
					roleName.append(role.getName()).append(" |");
				}
			}
			user.setRoles(roleName.toString().substring(0, roleName.toString().length()-1));
		}
		model.addAttribute("users", users);
		return "shiro/user/list";
	}
	
	
	//add
	@RequestMapping(value="admin/user/add")
	public String add(HttpServletRequest request,ModelMap model,@CurrentUser()Object object) throws IllegalArgumentException, IllegalAccessException{
		System.out.println(ObjectsUtil.stringhelper((User)object));
		/*
		 * 获取系统的所有角色
		 */
		List<Role> roles = roleService.listRole();
		model.addAttribute("roles", roles);
		return "shiro/user/add";
	}
	
	//addUser
	@ResponseBody
	@RequestMapping(value="admin/user/addUser",method=RequestMethod.POST)
	public Map<String,Object> addUser(HttpServletRequest request,ModelMap model,User user){
		Map<String,Object> map=Maps.newHashMap();
		String username = user.getUsername();
		String password=user.getPassword();
		String nickname=user.getNickname();
		if(PasswordHelper.isEmpty(username)){
			map.put("success", false);
			map.put("emsg", "用户名不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(nickname)){
			map.put("success", false);
			map.put("emsg", "昵称不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(password)){
			map.put("success", false);
			map.put("emsg", "密码不能为空！");
			return map;
		}
		//获取用户所拥有的角色数组
		String[] roleds = request.getParameterValues("roleId");
		List<String> rids=Arrays.asList(roleds);
		List<Integer> lint = new ArrayList<Integer>();
		for(String str:rids){
			if(!str.matches("^([0-9])+$")){
			     continue;
			  }
			  int i = Integer.parseInt(str); 
			  lint.add(i); 
		}

		//添加用户同时添加角色
		userService.add(user, lint);
		map.put("success", true);
		return map;
	}
	
	//用户修改界面
	@RequestMapping(value="admin/user/update/{userId}")
	public String update(HttpServletRequest request, @PathVariable("userId")String userId,ModelMap model){
		if(PasswordHelper.isEmpty(userId)){
			return "redirect:/admin/user/list";
		}
		User user = userService.selectByPrimaryKey(Integer.valueOf(userId));
		if(user==null){
			return "redirect:/admin/user/list";
		}
		List<Role> allRoles = roleService.listRole(); //所有角色
		List<Role> userRoles = roleService.listByUseRole(Integer.valueOf(userId));  //用户角色
		model.addAttribute("json_userRoles", JsonUtil.toJsonString(userRoles));
		model.addAttribute("json_allRoles", JsonUtil.toJsonString(allRoles));
		model.addAttribute("allRoles",allRoles);
		model.addAttribute("user", user);
		return "shiro/user/update";
	}
	
	//用户信息角色修改
	@ResponseBody
	@RequestMapping(value="admin/user/updateUser",method=RequestMethod.POST)
	public Map<String,Object> updateUser(HttpServletRequest request,ModelMap model,User user){
		Map<String,Object> map=Maps.newHashMap();
		String username = user.getUsername();
		String password=user.getPassword();
		String nickname=user.getNickname();
		if(PasswordHelper.isEmpty(username)){
			map.put("success", false);
			map.put("emsg", "用户名不能为空!");
			return map;
		}
		if(PasswordHelper.isEmpty(nickname)){
			map.put("success", false);
			map.put("emsg", "昵称不能为空!");
			return map;
		}
		if(PasswordHelper.isEmpty(password)){
			map.put("success", false);
			map.put("emsg", "密码不能为空!");
			return map;
		}
		user.setPassword(passwordHelper.md5(password, username)) ;// 密码为空
		//获取选中的用户所拥有的角色数组
		String[] roleds = request.getParameterValues("roleId");
		List<Integer> selRoles = new ArrayList<Integer>();
		if(roleds!=null){
			List<String> rids=Arrays.asList(roleds);
			for(String str:rids){
				if(!str.matches("^([0-9])+$")){
				     continue;
				  }
				  int i = Integer.parseInt(str); 
				  selRoles.add(i); 
			}
		}
		List<Integer> oldRoles = new ArrayList<Integer>();
		List<Role> dataRoles = roleService.listByUseRole(Integer.valueOf(user.getId()));  //用户角色
		for(Role r:dataRoles){
			oldRoles.add(r.getId());
		}
		//添加用户同时添加角色
		try {
			userService.updateUserInfo(user, selRoles,oldRoles);
			map.put("success",true);
			return map;
		} catch (DAOException e) {
			map.put("success", false);
			map.put("emsg","系统繁忙，请稍后重试！");
			return map;
		}
		
	}
	
	/*
	 * 禁用
	 */
	@ResponseBody
	@RequestMapping(value="admin/user/jy/{userId}",method=RequestMethod.POST)
	public Map<String,Object> user_jy(HttpServletRequest request,ModelMap model,@PathVariable("userId")String userId){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(userId)){
			map.put("success", false);
			map.put("emsg", "未获取到用户ID！");
			return map;
		}
		User user = userService.selectByPrimaryKey(Integer.valueOf(userId));
		if(user==null){
			map.put("success", false);
			map.put("emsg", "系统未获取到该用户！");
			return map;
		}
		user.setStatus(0);
		userService.update(user);
		map.put("success", true);
		return map;
	}
	
	
	/*
	 * 启用
	 */
	@ResponseBody
	@RequestMapping(value="admin/user/qy/{userId}",method=RequestMethod.POST)
	public Map<String,Object> user_qy(HttpServletRequest request,ModelMap model,@PathVariable("userId")String userId){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(userId)){
			map.put("success", false);
			map.put("emsg", "未获取到用户ID！");
			return map;
		}
		User user = userService.selectByPrimaryKey(Integer.valueOf(userId));
		if(user==null){
			map.put("success", false);
			map.put("emsg", "系统未获取到该用户！");
			return map;
		}
		user.setStatus(1);
		userService.update(user);
		map.put("success", true);
		return map;
	}
	
	
	//用户资源管理界面
	@RequestMapping(value="admin/user/listRes/{userId}")
	public String listRes(HttpServletRequest request,@PathVariable("userId")Integer userId,ModelMap model){
		if(PasswordHelper.isEmpty(userId)){
			return "redirect:/admin/user/list";
		}
		List<Resources> resources = userService.listAllResources(Integer.valueOf(userId));
		model.addAttribute("resources", resources);
		return "shiro/user/list_res";
	}
	
	
	
	
	/***************************************************************
	 *                                                             *
	 *                       角色页面                                                                                *               
	 *                                                             * 
	 ****************************************************************/
	//角色列表
	@RequestMapping(value="admin/role/list",method=RequestMethod.GET)
	public String role(HttpServletRequest request,ModelMap model){
		List<Role> roles = roleService.listRole();
		model.addAttribute("roles", roles);
		return "shiro/role/list";
	}
	
	//添加角色界面
	@RequestMapping(value="admin/role/add")
	public String role_add(HttpServletRequest request,ModelMap model){
		
		return "shiro/role/add";
	}
	
	//添加角色
	@ResponseBody
	@RequestMapping(value="admin/role/addRole",method=RequestMethod.POST)
	public Map<String,Object>  role_addRole(HttpServletRequest request,Role role,ModelMap model){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(role.getName())){
			map.put("success", false);
			map.put("emsg", "角色名称不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(role.getSn())){
			map.put("success", false);
			map.put("emsg", "角色命名SN不能为空！");
			return map;
		}
		roleService.insert(role);
		map.put("success", true);
		return map;
	}
	
	//更新角色页面
	@RequestMapping(value="admin/role/update/{roleId}")
	public String updateRole(HttpServletRequest request,@PathVariable("roleId")String roleId, ModelMap model){
		if(PasswordHelper.isEmpty(roleId)){
			return "redirect:/admin/role/list";
		}
		Role role = roleService.selectByPrimaryKey(Integer.valueOf(roleId));
		model.addAttribute("role", role);
		return "shiro/role/update";
	}
	
	//更新角色基本信息
	@ResponseBody
	@RequestMapping(value="admin/role/updateRole",method=RequestMethod.POST)
	public Map<String,Object> updateRole_Info(HttpServletRequest request,ModelMap model,Role role){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(role.getId())){
			map.put("success", false);
			map.put("emsg", "未获取到角色ID！");
			return map;
		}
		if(PasswordHelper.isEmpty(role.getName())){
			map.put("success", false);
			map.put("emsg", "角色名称不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(role.getSn())){
			map.put("success", false);
			map.put("emsg", "角色命名SN不能为空！");
			return map;
		}
		roleService.update(role);
		map.put("success", true);
		return map;
		
	}
	
	//角色资源设置
	@RequestMapping(value="admin/role/listRes/{roleId}")
	public String list_role_res(HttpServletRequest request,@PathVariable("roleId")String roleId, ModelMap model){
		if(PasswordHelper.isEmpty(roleId)){
			return "redirect:/admin/role/list";
		}
		List<Resources> roleRes = roleService.listRoleResources(Integer.valueOf(roleId)); //角色已经设置的资源
		List<Resources> allRes = resourcesService.listResource(); //所有资源
		model.addAttribute("json_allRes", JsonUtil.toJsonString(allRes));
		model.addAttribute("json_roleRes", JsonUtil.toJsonString(roleRes));
		model.addAttribute("allRes", allRes);
		model.addAttribute("roleId", roleId);
		return "shiro/role/list_res";
	}
	
	//角色资源更新
	@ResponseBody
	@RequestMapping(value="admin/role/updateRes",method=RequestMethod.POST)
	public Map<String,Object> updateUser(HttpServletRequest request,ModelMap model){
		 Map<String,Object> map=Maps.newHashMap();
		String roleId=request.getParameter("roleId");
		if(PasswordHelper.isEmpty(roleId)){
			map.put("success", false);
			map.put("emsg", "未获取到角色ID！");
			return map;
		}
		//获取选中的用户所拥有的角色数组
		String[] resIds = request.getParameterValues("resIds");
		List<Integer> selRes = new ArrayList<Integer>();
		if(resIds!=null){
			List<String> rids=Arrays.asList(resIds);
			for(String str:rids){
				if(!str.matches("^([0-9])+$")){
				     continue;
				  }
				  int i = Integer.parseInt(str); 
				  selRes.add(i); 
			}
		}
		List<Integer> oldRes = new ArrayList<Integer>();
		List<Resources> dataRes = roleService.listRoleResources(Integer.valueOf(roleId));  //角色原来的所有资源
		for(Resources r:dataRes){
			oldRes.add(r.getId());
		}
		try {
			roleService.updateRes(roleId,selRes,oldRes);//更新角色资源信息
			map.put("success", true);
			return map;
		} catch (DAOException e) {
			map.put("success", false);
			map.put("emsg", "！");
			return map;
		}
		
	}
	
	
	
	

	/***************************************************************
	 *                                                             *
	 *                       资源页面                                                                                *               
	 *                                                             * 
	 ****************************************************************/
	 //资源列表
	@RequestMapping(value="admin/res/list",method=RequestMethod.GET)
	public String res(HttpServletRequest request,ModelMap model){
		List<Resources> res = resourcesService.listResource();
		model.addAttribute("res", res);
		return "shiro/res/list";
	}
	
	//添加资源界面
	@RequestMapping(value="admin/res/add")
	public String res_add(HttpServletRequest request,ModelMap model){
		
		return "shiro/res/add";
	}
	
	//添加资源
	@ResponseBody
	@RequestMapping(value="admin/res/addRes")
	public Map<String,Object>  addRes(HttpServletRequest request,ModelMap model,Resources res){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(res.getName())){
			map.put("success", false);
			map.put("emsg", "资源名称不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(res.getUrl())){
			map.put("success", false);
			map.put("emsg", "资源路径不能为空！");
			return map;
		}
		resourcesService.insert(res);
		map.put("success", true);
		return  map;
	}
	
	
	//更新资源页面
	@RequestMapping(value="admin/res/update/{resId}")
	public String updateRes(HttpServletRequest request,@PathVariable("resId")String resId, ModelMap model){
		if(PasswordHelper.isEmpty(resId)){
			return "redirect:/admin/res/list";
		}
		Resources res = resourcesService.selectByPrimaryKey(Integer.valueOf(resId));
		model.addAttribute("res", res);
		return "shiro/res/update";
	}
	
	//更新资源信息
	@ResponseBody
	@RequestMapping(value="admin/res/updateRes",method=RequestMethod.POST)
	public Map<String,Object> updateRes_Info(HttpServletRequest request,ModelMap model,Resources res){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(res.getId())){
			map.put("success", false);
			map.put("emsg", "未获取到资源ID！");
			return map;
		}
		if(PasswordHelper.isEmpty(res.getName())){
			map.put("success", false);
			map.put("emsg", "资源名称不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(res.getUrl())){
			map.put("success", false);
			map.put("emsg", "资源路径不能为空！");
			return map;
		}
		resourcesService.update(res);
		map.put("success", true);
		return map;
		
	}
	
	
	
	/***************************************************************
	 *                                                             *
	 *                       错误页面                                                                                *               
	 *                                                             * 
	 ****************************************************************/
	
	//没有权限的页面
	@RequestMapping(value="unauth",method=RequestMethod.GET)
	public String unauth(HttpServletRequest request){
		
		return "shiro/error/unauth";
	}
	
	
	//未授权
	@RequestMapping(value="unroles",method=RequestMethod.GET)
	public String unroles(HttpServletRequest request){
		
		return "shiro/error/unroles";
	}
	
	
}
