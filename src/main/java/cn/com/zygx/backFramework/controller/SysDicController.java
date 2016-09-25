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
import cn.com.zygx.backFramework.model.SysDic;
import cn.com.zygx.backFramework.model.SysDicMenu;
import cn.com.zygx.backFramework.service.PasswordHelper;
import cn.com.zygx.backFramework.service.SysDicMenuService;
import cn.com.zygx.backFramework.service.SysDicService;
import com.google.common.collect.Maps;

//字典管理
@Controller
public class SysDicController {
	
	@Autowired
	private SysDicService sysDicService;
	
	@Autowired
	private SysDicMenuService sysDicMenuService;

	
	@RequestMapping(value="/admin/sys/dic/listMenu",method=RequestMethod.GET)
	public String listSysMenuDic(HttpServletRequest request,SysDicMenu sysdicMenu,ModelMap model){
		List<SysDicMenu> dicMenuList = sysDicMenuService.query(sysdicMenu);
		model.addAttribute("dicMenuList", dicMenuList);
		return "sys/dic/menu_list";
	}
	
	
	@RequestMapping(value="/admin/sys/dic/addMenu",method=RequestMethod.GET)
	public String addSysDicMenu(HttpServletRequest request){
		
		return "sys/dic/menu_add";
	}
	
	@ResponseBody
	@RequestMapping(value="admin/sys/dic/addDicMenu",method=RequestMethod.POST)
	public Map<String,Object> insertSysDicMenu(HttpServletRequest request,SysDicMenu sysdicMenu){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(sysdicMenu.getDic_code())){
			map.put("success",false);
			map.put("emsg", "字典代码不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdicMenu.getDic_name())){
			map.put("success",false);
			map.put("emsg", "字典名称不能为空！");
			return map;
		}
		sysdicMenu.setUpdate_date(new Date());
		sysDicMenuService.insertSelective(sysdicMenu);
		map.put("success", true);
		return map;
	}
	
	@RequestMapping(value="/admin/sys/dic/updateMenu/{dicMenuId}",method=RequestMethod.GET)
	public String updateSysDicMenu(HttpServletRequest request,@PathVariable("dicMenuId")String dicMenuId,ModelMap model){
		if(!PasswordHelper.isEmpty(dicMenuId)){
			SysDicMenu sys_dic_menu = sysDicMenuService.selectByPrimaryKey(Integer.valueOf(dicMenuId));
			model.addAttribute("sys_dic_menu", sys_dic_menu);
		}
		
		return "sys/dic/menu_update";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/sys/dic/updateDicMenu",method=RequestMethod.POST)
	public Map<String,Object> editSysDicMenu(HttpServletRequest request,SysDicMenu sysdicMenu){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(sysdicMenu.getId())){
			map.put("success",false);
			map.put("emsg", "未获取到字典菜单ID！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdicMenu.getDic_code())){
			map.put("success",false);
			map.put("emsg", "字典代码不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdicMenu.getDic_name())){
			map.put("success",false);
			map.put("emsg", "字典名称不能为空！");
			return map;
		}
		sysdicMenu.setUpdate_date(new Date());
		sysDicMenuService.update(sysdicMenu);
		map.put("success", true);
		return map;
	}
	
	
	/***************************************************************************************************/
	
	
	@RequestMapping(value="/admin/sys/dic/list",method=RequestMethod.GET)
	public String listSysDic(HttpServletRequest request,SysDic sysdic,ModelMap model){
		List<SysDic> dicList = sysDicService.query(sysdic);
		model.addAttribute("dicList", dicList);
		return "sys/dic/list";
	}
	
	@RequestMapping(value="/admin/sys/dic/add",method=RequestMethod.GET)
	public String addSysDic(HttpServletRequest request,ModelMap model){
		/*
		 * 获取字典详情
		 */
		SysDicMenu menu=new SysDicMenu();
		menu.setIs_valid(Constant.VALIAD);//只获取有效的
		List<SysDicMenu> sysDicMenu = sysDicMenuService.query(menu);
		model.addAttribute("json_sysDicMenu",JsonUtil.toJsonString(sysDicMenu));
		return "sys/dic/add";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/admin/sys/dic/addDic",method=RequestMethod.POST)
	public Map<String,Object> insertSysDic(HttpServletRequest request,SysDic sysdic){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(sysdic.getDic_code())){
			map.put("success",false);
			map.put("emsg", "字典代码不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdic.getDic_label())){
			map.put("success",false);
			map.put("emsg", "名称不能为空！");
			return map;
		}
		sysdic.setUpdate_date(new Date());
		sysDicService.insertSelective(sysdic);
		map.put("success", true);
		return map;
	}
	
	@RequestMapping(value="/admin/sys/dic/update/{dicId}",method=RequestMethod.GET)
	public String updateSysDic(HttpServletRequest request,@PathVariable("dicId")String dicId,ModelMap model){
		if(!PasswordHelper.isEmpty(dicId)){
			SysDic sys_dic = sysDicService.selectByPrimaryKey(Integer.valueOf(dicId));
			model.addAttribute("sys_dic", sys_dic);
		}
		/*
		 * 获取字典详情
		 */
		SysDicMenu menu=new SysDicMenu();
		menu.setIs_valid(Constant.VALIAD);//只获取有效的
		List<SysDicMenu> sysDicMenu = sysDicMenuService.query(menu);
		model.addAttribute("json_sysDicMenu",JsonUtil.toJsonString(sysDicMenu));
		return "sys/dic/update";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/sys/dic/updateDic",method=RequestMethod.POST)
	public Map<String,Object> editSysDic(HttpServletRequest request,SysDic sysdic){
		Map<String,Object> map=Maps.newHashMap();
		if(PasswordHelper.isEmpty(sysdic.getId())){
			map.put("success",false);
			map.put("emsg", "未获取到字典ID！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdic.getDic_code())){
			map.put("success",false);
			map.put("emsg", "字典代码不能为空！");
			return map;
		}
		if(PasswordHelper.isEmpty(sysdic.getDic_label())){
			map.put("success",false);
			map.put("emsg", "名称不能为空！");
			return map;
		}
		sysdic.setUpdate_date(new Date());
		sysDicService.update(sysdic);
		map.put("success", true);
		return map;
	}
	
}
