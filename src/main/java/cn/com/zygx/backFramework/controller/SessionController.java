package cn.com.zygx.backFramework.controller;

import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import cn.com.zygx.backFramework.common.Constant;

/**
 * 会话管理
 * <p>User: wangyi
 * <p>Date: 2016-9-21
 * <p>Version: 1.0
 */

@Controller
public class SessionController {

	/**
	 * sessionDAO shiro提供的会话持久化，可以持久化到mysql或者非关系型数据库如redis
	 */
	@Autowired
	private SessionDAO sessionDAO;
	
	/**
	 * 获取当前在线的回话列表
	 * @param @param model
	 * @param @return
	 */
	@RequestMapping("/admin/sessions/list")
	public String list(Model model){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		model.addAttribute("sessions",sessions);
		model.addAttribute("sessionCount", sessions.size());
		return "shiro/sessions/list";
	}

	
	/**
	 * 强制登出某个会话
	 * @param @param sessionId
	 * @param @param redirectAttributes
	 * @param @return
	 */
	@RequestMapping(value="/admin/sessions/{sessionId}/forceLogout",method=RequestMethod.POST)
	public String forceLogout(@PathVariable("sessionId")String sessionId,RedirectAttributes redirectAttributes){
		try {
			Session session = sessionDAO.readSession(sessionId);
			if(session!=null){
				session.setAttribute(Constant.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);
			}
		} catch (Exception e) {
			/**ignore*/
			redirectAttributes.addFlashAttribute("msg","强制退出成功");
		}
		
		return "redirect:/sessions";
	}
}
