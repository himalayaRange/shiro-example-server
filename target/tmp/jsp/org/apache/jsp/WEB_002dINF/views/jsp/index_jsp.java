package org.apache.jsp.WEB_002dINF.views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/WEB-INF/views/tag.jsp");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/base_head.jsp");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/navbar.jsp");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/menu.jsp");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/foot_js.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_principal_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_authenticated;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_hasPermission_name;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_shiro_principal_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_authenticated = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_hasPermission_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_shiro_principal_property_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_shiro_authenticated.release();
    _jspx_tagPool_shiro_hasPermission_name.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
String path = request.getContextPath();
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar ctx = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("</script>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/spring/favicon.ico\"/>\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/html5.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/respond.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/PIE_IE678.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui/css/H-ui.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui.admin/css/H-ui.admin.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/Hui-iconfont/1.0.7/iconfont.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/icheck/icheck.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui.admin/skin/default/skin.css\" id=\"skin\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui.admin/css/style.css\" />\r\n");
      out.write("<!--[if IE 6]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js\" ></script>\r\n");
      out.write("<script>DD_belatedPNG.fix('*');</script>\r\n");
      out.write("<![endif]-->");
      out.write("\r\n");
      out.write("<title>H-ui后台管理系统</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"H-ui.admin v2.4,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载\">\r\n");
      out.write("<meta name=\"description\" content=\"H-ui.admin v2.4，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 导航 -->\r\n");
      out.write("\n");
      out.write("\n");
      out.write("<header class=\"navbar-wrapper\">\n");
      out.write("\t<div class=\"navbar navbar-fixed-top\">\n");
      out.write("\t\t<div class=\"container-fluid cl\"> <a class=\"logo navbar-logo f-l mr-10 hidden-xs\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/index\">H-ui后台管理系统</a> <a class=\"logo navbar-logo-m f-l mr-10 visible-xs\" href=\"/aboutHui.shtml\">H-ui</a> <span class=\"logo navbar-slogan f-l mr-10 hidden-xs\">v1.0</span> <a aria-hidden=\"false\" class=\"nav-toggle Hui-iconfont visible-xs\" href=\"javascript:;\">&#xe667;</a>\n");
      out.write("\t\t\t<nav class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t<ul class=\"cl\">\n");
      out.write("\t\t\t\t\t<li class=\"dropDown dropDown_hover\"><a href=\"javascript:;\" class=\"dropDown_A\"><i class=\"Hui-iconfont\">&#xe600;</i> 新增 <i class=\"Hui-iconfont\">&#xe6d5;</i></a>\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropDown-menu menu radius box-shadow\">\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"article_add('添加资讯','article-add.html')\"><i class=\"Hui-iconfont\">&#xe616;</i> 资讯</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"picture_add('添加资讯','picture-add.html')\"><i class=\"Hui-iconfont\">&#xe613;</i> 图片</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"product_add('添加资讯','product-add.html')\"><i class=\"Hui-iconfont\">&#xe620;</i> 产品</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"member_add('添加用户','member-add.html','','510')\"><i class=\"Hui-iconfont\">&#xe60d;</i> 用户</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t<nav id=\"Hui-userbar\" class=\"nav navbar-nav navbar-userbar hidden-xs\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<ul class=\"cl\">\n");
      out.write("\t\t\t\t\t<li id=\"curr_time\" style=\"position: relative;margin-right: 10px\"></li>\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_authenticated_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t<li id=\"Hui-skin\" class=\"dropDown right dropDown_hover\"> <a href=\"javascript:;\" class=\"dropDown_A\" title=\"换肤\"><i class=\"Hui-iconfont\" style=\"font-size:18px\">&#xe62a;</i></a>\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropDown-menu menu radius box-shadow\">\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"default\" title=\"默认（黑色）\">黑色</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"blue\" title=\"蓝色\">蓝色</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"green\" title=\"绿色\">绿色</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"red\" title=\"红色\">红色</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"yellow\" title=\"黄色\">黄色</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:;\" data-val=\"orange\" title=\"绿色\">橙色</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</header>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 菜单 -->\r\n");
      out.write("\n");
      out.write("\n");
      out.write("<aside class=\"Hui-aside\">\n");
      out.write("\t<input runat=\"server\" id=\"divScrollValue\" type=\"hidden\" value=\"\" />\n");
      out.write("\t<div class=\"menu_dropdown bk_2\">\n");
      out.write("\t\t\n");
      out.write("\t\t<dl id=\"menu-admin\">\n");
      out.write("\t\t\t<dt><i class=\"Hui-iconfont\">&#xe62d;</i> 管理员管理<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>\n");
      out.write("\t\t\t<dd>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</dd>\n");
      out.write("\t\t</dl>\n");
      out.write("\t\t<dl id=\"menu-system\">\n");
      out.write("\t\t\t<dt><i class=\"Hui-iconfont\">&#xe62e;</i> 系统管理<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>\n");
      out.write("\t\t\t<dd>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<!-- 只允许管理员查看 -->\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_6(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_hasPermission_7(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</dd>\n");
      out.write("\t\t</dl>\n");
      out.write("\t</div>\n");
      out.write("</aside>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"dislpayArrow hidden-xs\"><a class=\"pngfix\" href=\"javascript:void(0);\" onClick=\"displaynavbar(this)\"></a></div>\r\n");
      out.write("<section class=\"Hui-article-box\" id=\"iframe-bodys\">\r\n");
      out.write("\t<div id=\"Hui-tabNav\" class=\"Hui-tabNav hidden-xs\">\r\n");
      out.write("\t\t<div class=\"Hui-tabNav-wp\">\r\n");
      out.write("\t\t\t<ul id=\"min_title_list\" class=\"acrossTab cl\">\r\n");
      out.write("\t\t\t\t<li class=\"active\"><span title=\"我的桌面\" data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/welcome\">我的桌面</span><em></em></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"Hui-tabNav-more btn-group\"><a id=\"js-tabNav-prev\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d4;</i></a><a id=\"js-tabNav-next\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d7;</i></a></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"iframe_box\" class=\"Hui-article\">\r\n");
      out.write("\t\t<div class=\"show_iframe\">\r\n");
      out.write("\t\t\t<div style=\"display:none\" class=\"loading\"></div>\r\n");
      out.write("\t\t\t<iframe scrolling=\"yes\" frameborder=\"0\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/welcome\"></iframe>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
      out.write("\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/jquery/jquery-1.11.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/images/tooltips.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/layer/2.1/layer.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/laypage/1.2/laypage.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/lib/My97DatePicker/WdatePicker.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui/js/H-ui.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/H-ui/static/h-ui.admin/js/H-ui.admin.js\"></script> \n");
      out.write("<script type=\"text/javaScript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/jquery.jclock.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/utils.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("\t$('#curr_time').jclock({withDate:true, withWeek:true, fontSize: '14px' });\n");
      out.write("});\n");
      out.write("function weekDay(){\n");
      out.write("\tvar date=$dp.cal.getP('y')+\"-\"+$dp.cal.getP('M')+\"-\"+$dp.cal.getP('d')+\" \"+showWeek($dp.cal.getP('w'));\n");
      out.write("\tthis.value=date;//this代表当前input框\n");
      out.write("\t}\n");
      out.write("\tfunction showWeek(week){\n");
      out.write("\tvar wk=\"\";\n");
      out.write("\tswitch(parseInt(week)){\n");
      out.write("\tcase 0:\n");
      out.write("\twk=\"星期日\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 1:\n");
      out.write("\twk=\"星期一\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 2:\n");
      out.write("\twk=\"星期二\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 3:\n");
      out.write("\twk=\"星期三\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 4:\n");
      out.write("\twk=\"星期四\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 5:\n");
      out.write("\twk=\"星期五\";\n");
      out.write("\tbreak;\n");
      out.write("\tcase 6:\n");
      out.write("\twk=\"星期六\";\n");
      out.write("\tbreak;\n");
      out.write("\t}\n");
      out.write("\treturn wk;\n");
      out.write("\t}\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*资讯-添加*/\r\n");
      out.write("function article_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*图片-添加*/\r\n");
      out.write("function picture_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*产品-添加*/\r\n");
      out.write("function product_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*用户-添加*/\r\n");
      out.write("function member_add(title,url,w,h){\r\n");
      out.write("\tlayer_show(title,url,w,h);\r\n");
      out.write("}\r\n");
      out.write("</script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var _hmt = _hmt || [];\r\n");
      out.write("(function() {\r\n");
      out.write("  var hm = document.createElement(\"script\");\r\n");
      out.write("  hm.src = \"//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911\";\r\n");
      out.write("  var s = document.getElementsByTagName(\"script\")[0]; \r\n");
      out.write("  s.parentNode.insertBefore(hm, s)})();\r\n");
      out.write("  var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\r\n");
      out.write("  document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E\"));\r\n");
      out.write("</script>\r\n");
      out.write("<!-- <script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tinstanceHTML($(\"#main_menu\"),");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${node}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(");\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("function instanceHTML(dom,obj){\r\n");
      out.write("\t var menu_html='';\r\n");
      out.write("\t menu_html+= '<dl id=\"menu-admin\">'+\r\n");
      out.write("\t\t \t'<dt><i class=\"Hui-iconfont\">&#xe62d;</i> '+obj.name+'<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>'+\r\n");
      out.write("\t     '<dd>'+\r\n");
      out.write("\t\t\t '<ul>'+getLi(obj.children)+'</ul>'+\r\n");
      out.write("\t     '</dd>'+\r\n");
      out.write("\t\t '</dl>';\r\n");
      out.write("\t\t $(dom).append(menu_html);\t \r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function getLi(lis){\r\n");
      out.write("\tvar li='';\r\n");
      out.write("\t$.each(lis,function(index,ele){\r\n");
      out.write("\t\tli+='<li><a _href=\"\"  data-title='+ele.name+' href=\"javascript:void(0)\">'+ele.name+'</a></li>';\r\n");
      out.write("\t});\r\n");
      out.write("\treturn li;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script> -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_shiro_authenticated_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:authenticated
    org.apache.shiro.web.tags.AuthenticatedTag _jspx_th_shiro_authenticated_0 = (org.apache.shiro.web.tags.AuthenticatedTag) _jspx_tagPool_shiro_authenticated.get(org.apache.shiro.web.tags.AuthenticatedTag.class);
    _jspx_th_shiro_authenticated_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_authenticated_0.setParent(null);
    int _jspx_eval_shiro_authenticated_0 = _jspx_th_shiro_authenticated_0.doStartTag();
    if (_jspx_eval_shiro_authenticated_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li>");
        if (_jspx_meth_shiro_principal_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write(" </li>\n");
        out.write("\t\t\t\t\t\t<li class=\"dropDown dropDown_hover\"> <a href=\"#\" class=\"dropDown_A\">");
        if (_jspx_meth_shiro_principal_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_authenticated_0, _jspx_page_context))
          return true;
        out.write(" <i class=\"Hui-iconfont\">&#xe6d5;</i></a>\n");
        out.write("\t\t\t\t\t\t<ul class=\"dropDown-menu menu radius box-shadow\">\n");
        out.write("\t\t\t\t\t\t\t<li><a href=\"#\">个人信息</a></li>\n");
        out.write("\t\t\t\t\t\t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/login\">切换账户</a></li>\n");
        out.write("\t\t\t\t\t\t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/logout\">退出</a></li>\n");
        out.write("\t\t\t\t\t\t</ul>\t\n");
        out.write("\t\t\t\t\t\t</li>\n");
        out.write("\t\t\t\t\t\t<li id=\"Hui-msg\"> <a href=\"#\" title=\"消息\"><span class=\"badge badge-danger\">1</span><i class=\"Hui-iconfont\" style=\"font-size:18px\">&#xe68a;</i></a> </li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_authenticated_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_authenticated_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_authenticated.reuse(_jspx_th_shiro_authenticated_0);
      return true;
    }
    _jspx_tagPool_shiro_authenticated.reuse(_jspx_th_shiro_authenticated_0);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_0 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    _jspx_th_shiro_principal_0.setProperty("nickname");
    int _jspx_eval_shiro_principal_0 = _jspx_th_shiro_principal_0.doStartTag();
    if (_jspx_th_shiro_principal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_0);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_0);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_1(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_authenticated_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_1 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_authenticated_0);
    _jspx_th_shiro_principal_1.setProperty("username");
    int _jspx_eval_shiro_principal_1 = _jspx_th_shiro_principal_1.doStartTag();
    if (_jspx_th_shiro_principal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_1);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_1);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_0 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_0.setParent(null);
    _jspx_th_shiro_hasPermission_0.setName("/admin/client/list");
    int _jspx_eval_shiro_hasPermission_0 = _jspx_th_shiro_hasPermission_0.doStartTag();
    if (_jspx_eval_shiro_hasPermission_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/client/list\" data-title=\"客户端管理\" href=\"javascript:void(0)\">客户端管理</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_0);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_0);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_1 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_1.setParent(null);
    _jspx_th_shiro_hasPermission_1.setName("/admin/sessions/list");
    int _jspx_eval_shiro_hasPermission_1 = _jspx_th_shiro_hasPermission_1.doStartTag();
    if (_jspx_eval_shiro_hasPermission_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/sessions/list\" data-title=\"会话管理\" href=\"javascript:void(0)\">会话管理</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_1);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_1);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_2 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_2.setParent(null);
    _jspx_th_shiro_hasPermission_2.setName("/admin/user/list");
    int _jspx_eval_shiro_hasPermission_2 = _jspx_th_shiro_hasPermission_2.doStartTag();
    if (_jspx_eval_shiro_hasPermission_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/user/list\"  data-title=\"管理员列表\" href=\"javascript:void(0)\">管理员列表</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_2);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_2);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_3 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_3.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_3.setParent(null);
    _jspx_th_shiro_hasPermission_3.setName("/admin/role/list");
    int _jspx_eval_shiro_hasPermission_3 = _jspx_th_shiro_hasPermission_3.doStartTag();
    if (_jspx_eval_shiro_hasPermission_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/role/list\" data-title=\"角色管理\" href=\"javascript:void(0)\">角色管理</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_3);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_3);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_4 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_4.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_4.setParent(null);
    _jspx_th_shiro_hasPermission_4.setName("/admin/res/list");
    int _jspx_eval_shiro_hasPermission_4 = _jspx_th_shiro_hasPermission_4.doStartTag();
    if (_jspx_eval_shiro_hasPermission_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/res/list\" data-title=\"权限管理\" href=\"javascript:void(0)\">权限管理</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_4);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_4);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_5 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_5.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_5.setParent(null);
    _jspx_th_shiro_hasPermission_5.setName("/admin/druid");
    int _jspx_eval_shiro_hasPermission_5 = _jspx_th_shiro_hasPermission_5.doStartTag();
    if (_jspx_eval_shiro_hasPermission_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a  data-title=\"系统监控\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/druid/index.html\" target=\"_blank\">系统监控</a></li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_5);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_5);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_6 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_6.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_6.setParent(null);
    _jspx_th_shiro_hasPermission_6.setName("/admin/sys/dic/*");
    int _jspx_eval_shiro_hasPermission_6 = _jspx_th_shiro_hasPermission_6.doStartTag();
    if (_jspx_eval_shiro_hasPermission_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>\n");
        out.write("\t\t\t\t\t\t<a data-title=\"数据字典\" href=\"javascript:void(0)\">数据字典</a>\n");
        out.write("\t\t\t\t\t\t<ul>\n");
        out.write("\t\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/sys/dic/listMenu\" data-title=\"字典菜单\" href=\"javascript:void(0)\">字典菜单</a></li>\n");
        out.write("\t\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/sys/dic/list\" data-title=\"字典详情\" href=\"javascript:void(0)\">字典详情</a></li>\n");
        out.write("\t\t\t\t\t\t</ul>\n");
        out.write("\t\t\t\t\t</li>\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_6);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_6);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_7 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_7.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_7.setParent(null);
    _jspx_th_shiro_hasPermission_7.setName("/admin/sys/menu/tree");
    int _jspx_eval_shiro_hasPermission_7 = _jspx_th_shiro_hasPermission_7.doStartTag();
    if (_jspx_eval_shiro_hasPermission_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t<li><a _href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/admin/sys/menu/tree\" data-title=\"菜单管理\" href=\"javascript:void(0)\">菜单管理</a></li>\n");
        out.write("\t\t\t\t\t\t<!--<li><a _href=\"#\" data-title=\"系统日志\" href=\"javascript:void(0)\">系统日志</a></li> -->\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_7);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_7);
    return false;
  }
}
