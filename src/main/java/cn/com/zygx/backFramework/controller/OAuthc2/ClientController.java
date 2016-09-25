package cn.com.zygx.backFramework.controller.OAuthc2;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.com.zygx.backFramework.model.Oauth2Client;
import cn.com.zygx.backFramework.service.OAuthClientService;

/**
 * 客户端控制器
 * <p>User: wangyi
 * <p>Date: 2016-9-12
 * <p>Version: 1.0
 */
@Controller
public class ClientController {

	@Autowired
	private OAuthClientService oAuthClientService;
	@RequestMapping(value="admin/client/list",method=RequestMethod.GET)
	public String client(HttpServletRequest request,ModelMap model){
		
		List<Oauth2Client> clients = oAuthClientService.query(null);
		model.addAttribute("clients", clients);
		
		return "shiro/client/list";
	}
}
