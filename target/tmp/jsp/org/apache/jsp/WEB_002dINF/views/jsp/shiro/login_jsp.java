package org.apache.jsp.WEB_002dINF.views.jsp.shiro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/WEB-INF/views/tag.jsp");
    _jspx_dependants.add("/WEB-INF/tid/shiro-functions.tld");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/jsp/common/foot_js.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("     <title>用户登录</title>\r\n");
      out.write("     ");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<!-- å¼å¥ Bootstrap -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- HTML5 Shim å Respond.js ç¨äºè®© IE8 æ¯æ HTML5åç´ ååªä½æ¥è¯¢ -->\r\n");
      out.write("<!-- æ³¨æï¼ å¦æéè¿ file://  å¼å¥ Respond.js æä»¶ï¼åè¯¥æä»¶æ æ³èµ·ææ -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("   <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("   <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("<![endif]-->");
      out.write("\r\n");
      out.write("     <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/spring/favicon.ico\"/>\r\n");
      out.write("     <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/css/supersized.css\">\r\n");
      out.write("\t <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/css/login.css\">\r\n");
      out.write("\t <style type=\"text/css\">\r\n");
      out.write("\t \t /* 以下遮罩层为demo.用户可自行设计实现 */\r\n");
      out.write("        #mask {\r\n");
      out.write("            display: none;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-color: rgba(0, 0, 0, 0.5);\r\n");
      out.write("            overflow: auto;\r\n");
      out.write("        }\r\n");
      out.write("        /* 可自行设计实现captcha的位置大小 */\r\n");
      out.write("        .popup-mobile {\r\n");
      out.write("            position: relative;\r\n");
      out.write("        }\r\n");
      out.write("        #popup-captcha-mobile {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            display: none;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            top: 50%;\r\n");
      out.write("            transform: translate(-50%, -50%);\r\n");
      out.write("            -webkit-transform: translate(-50%, -50%);\r\n");
      out.write("            z-index: 9999;\r\n");
      out.write("        }\r\n");
      out.write("\t </style>\r\n");
      out.write("   </head>\r\n");
      out.write("   \r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"page-container\">\r\n");
      out.write("\t<div class=\"main_box\">\r\n");
      out.write("\t\t<div class=\"login_box\">\r\n");
      out.write("\t\t\t<div class=\"login_logo\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/images/login/logo.png\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login_form\">\r\n");
      out.write("\t\t\t\t<form action=\"#\" id=\"login_form\" accept-charset=\"utf-8\"   method=\"post\" class=\"login\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"j_username\" class=\"t\">用户名：</label> \r\n");
      out.write("\t\t\t\t\t\t<input id=\"username\" name=\"username\"  value=\"\" autocomplete=\"off\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t class=\"form-control x319 in\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"j_password\" class=\"t\">密　码：</label> \r\n");
      out.write("\t\t\t\t\t\t<input id=\"password\" value=\"\"  autocomplete=\"off\" name=\"password\" type=\"password\" \r\n");
      out.write("\t\t\t\t\t\t class=\"password form-control x319 in\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"t\"></label>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"j_remember\" class=\"m\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"j_remember\" name=\"rememberMe\" value=\"true\" type=\"checkbox\" value=\"true\">&nbsp;一周免登陆!</label>\r\n");
      out.write("\t\t\t\t\t\t<span style=\"color: red\">");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group space\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"t\"></label>　　　\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"  id=\"submit_btn\"  \r\n");
      out.write("\t\t\t\t\t\tclass=\"btn btn-primary btn-lg\">&nbsp;登&nbsp;录&nbsp; </button>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"&nbsp;重&nbsp;置&nbsp;\" class=\"btn btn-default btn-lg\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- 极速验证，本次采用手机端 -->\r\n");
      out.write("\t\t\t\t\t<div id=\"mask\"></div>\r\n");
      out.write("    \t\t\t\t<div id=\"popup-captcha-mobile\"></div>\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">Copyright &copy; 2016 - 2020 <a href=\"#\">系统登陆</a></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Javascript -->\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/supersized.3.2.7.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/supersized-init.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/login.js\"></script>\r\n");
      out.write("<!-- 引入封装了failback的接口--initGeetest -->\r\n");
      out.write("<script src=\"http://static.geetest.com/static/tools/gt.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(\"#mask\").click(function () {\r\n");
      out.write("        $(\"#mask, #popup-captcha-mobile\").hide();\r\n");
      out.write("    });\r\n");
      out.write("    $(\"#submit_btn\").click(function () {\r\n");
      out.write("        $(\"#mask, #popup-captcha-mobile\").show();\r\n");
      out.write("    });\r\n");
      out.write("    var handlerPopupMobile = function (captchaObj) {\r\n");
      out.write("        // 将验证码加到id为captcha的元素里\r\n");
      out.write("        captchaObj.appendTo(\"#popup-captcha-mobile\");\r\n");
      out.write("        //拖动验证成功后两秒(可自行设置时间)自动发生跳转等行为\r\n");
      out.write("        captchaObj.onSuccess(function () {\r\n");
      out.write("            var validate = captchaObj.getValidate();\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"mobile-geetest/validate\", // 进行二次验证\r\n");
      out.write("                type: \"post\",\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                data: {\r\n");
      out.write("                    // 二次验证所需的三个值\r\n");
      out.write("                    username: $('#username').val(),\r\n");
      out.write("                    password: $('#password').val(),\r\n");
      out.write("                    rememberMe: $('#j_remember').val(),\r\n");
      out.write("                    geetest_challenge: validate.geetest_challenge,\r\n");
      out.write("                    geetest_validate: validate.geetest_validate,\r\n");
      out.write("                    geetest_seccode: validate.geetest_seccode\r\n");
      out.write("                },\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("                    if (data && (data.status === \"success\")) {\r\n");
      out.write("                    \t//提示信息  URL 跳转时间\r\n");
      out.write("\t\t\t\t\t\tshow_msg(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\",'登录成功咯！  正在为您跳转...','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/index',1500);\r\n");
      out.write("                    } else {\r\n");
      out.write("                    \tshow_err_msg(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\",data.emsg);\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html\r\n");
      out.write("    };\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        // 获取id，challenge，success（是否启用failback）\r\n");
      out.write("        url: \"mobile-geetest/register?t=\" + (new Date()).getTime(), // 加随机数防止缓存\r\n");
      out.write("        type: \"get\",\r\n");
      out.write("        dataType: \"json\",\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("            // 使用initGeetest接口\r\n");
      out.write("            // 参数1：配置参数\r\n");
      out.write("            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件\r\n");
      out.write("            initGeetest({\r\n");
      out.write("                gt: data.gt,\r\n");
      out.write("                challenge: data.challenge,\r\n");
      out.write("                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注\r\n");
      out.write("                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config\r\n");
      out.write("            }, handlerPopupMobile);\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- <script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t//提交表单\r\n");
      out.write("\t\t$('#submit_btn').click(function(){\r\n");
      out.write("\t\t\tshow_loading(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/shiroAuth',\r\n");
      out.write("\t\t\t\ttype:'POST',\r\n");
      out.write("\t\t\t\tdata:$(\"#login_form\").serialize(),\r\n");
      out.write("\t\t\t\tdataType:'json',\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\t\t\t//提示信息  URL 跳转时间\r\n");
      out.write("\t\t\t\t\t\tshow_msg(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\",'登录成功咯！  正在为您跳转...','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/index',1500);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\tshow_err_msg(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\",data.emsg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:function(data){\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script> -->\r\n");
      out.write("\r\n");
      out.write("<div style=\"text-align:center;\">\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty param.kickout}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&nbsp;&nbsp;&nbsp;&nbsp;您的账户被强制踢出！");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
