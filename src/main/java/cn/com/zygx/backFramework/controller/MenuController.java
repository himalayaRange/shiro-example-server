package cn.com.zygx.backFramework.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.zygx.backFramework.common.Constant;
import cn.com.zygx.backFramework.common.jackson.JsonUtil;
import cn.com.zygx.backFramework.common.tree.Node;
import cn.com.zygx.backFramework.service.PasswordHelper;
import cn.com.zygx.backFramework.service.SysMenuService;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

@Controller
public class MenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping(value="/admin/sys/menu/tree",method=RequestMethod.GET)
	public String tree(HttpServletRequest request,ModelMap model){
		Node node=new Node();
		node.setIs_valid(Constant.VALIAD);
		System.out.println(sysMenuService);
		List<Node> nodes = sysMenuService.query(node);
		model.addAttribute("nodeList", nodes);
		model.addAttribute("nodes", JsonUtil.toJsonString(nodes));
		return "sys/menu/tree";
	}
	
	@RequestMapping(value="/admin/sys/menu/add",method=RequestMethod.GET)
	public String addTree(HttpServletRequest request,ModelMap model){
		Node node=new Node();
		node.setIs_valid(Constant.VALIAD);
		List<Node> nodes = sysMenuService.query(node);
		model.addAttribute("nodes", JsonUtil.toJsonString(nodes));
		
		return "sys/menu/tree_add";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/sys/menu/addTree",method=RequestMethod.POST)
	public Map<String,Object> addTreeNode(HttpServletRequest request,ModelMap model,Node node){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(node.getParentId())){
			map.put("success", false);
			map.put("emsg", "请选择父节点！");
			return map;
		}
		if(PasswordHelper.isEmpty(node.getName())){
			map.put("success", false);
			map.put("emsg", "请输入节点名称！");
			return map;
		}
		if(Objects.equal("on", node.getIconSkin())){
			node.setIconSkin(null);
		}
		node.setCreate_date(new Date());
		node.setUpdate_date(new Date());
		sysMenuService.insertSelective(node);
		map.put("success", true);
		return map;
	}
	
	
	@RequestMapping(value="/admin/sys/tree/update/{nodeId}",method=RequestMethod.GET)
	public String editTree(HttpServletRequest request,ModelMap model,@PathVariable("nodeId")String nodeId){
		if(!PasswordHelper.isEmpty(nodeId)){
			Node node = sysMenuService.selectByPrimaryKey(Integer.valueOf(nodeId));
			model.addAttribute("node",node);
		}
		Node node=new Node();
		node.setIs_valid(Constant.VALIAD);
		List<Node> nodes = sysMenuService.query(node);
		model.addAttribute("nodes", JsonUtil.toJsonString(nodes));
		return "sys/menu/tree_update";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/sys/tree/updateTree",method=RequestMethod.POST)
	public Map<String,Object> editMenuTree(HttpServletRequest request, Node node){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(node.getId())){
			map.put("success", false);
			map.put("emsg", "未获取到节点ID！");
			return map;
		}

		if(PasswordHelper.isEmpty(node.getParentId())){
			map.put("success", false);
			map.put("emsg", "请选择父节点！");
			return map;
		}
		if(PasswordHelper.isEmpty(node.getName())){
			map.put("success", false);
			map.put("emsg", "请输入节点名称！");
			return map;
		}
		if(Objects.equal("on", node.getIconSkin())){
			node.setIconSkin(null);
		}
		Node curr = sysMenuService.selectByPrimaryKey(Integer.valueOf(node.getId()));
		if(PasswordHelper.isEmpty(curr)){
			map.put("success", false);
			map.put("emsg", "未获取到该数据！");
			return map;
		}
		node.setUpdate_date(new Date());
		sysMenuService.update(node);
		map.put("success", true);
		return map;
	}
}
