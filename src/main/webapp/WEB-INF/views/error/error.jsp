<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="Yigit Yigit Ce.[pulyavserdce.com]" />
<meta name="description" content="Site description" />
<meta name="keywords" content="keywords, keyword, seo, google" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" /> 
<meta name="apple-mobile-web-app-capable" content="yes" /> 
<title>页面丢失 : 404</title>
 <link rel="shortcut icon" type="image/x-icon" href="favicon.png" />
 <link rel="icon" type="image/x-icon" href="favicon.png" />
 <link rel="apple-touch-icon" href="favicon.png" />
 <link rel="apple-touch-startup-image" href="favicon.png" />
 </head> 
<body> 
   <div style="position: relative;margin-left: 25%;margin-top: 100px;" >
   		<img alt="" src="${ctx}/static/error/error.png">
   		<a href="${ctx}/admin/index" style="color: graytext;">返回首页</a>
   </div>
</body>
</html>
