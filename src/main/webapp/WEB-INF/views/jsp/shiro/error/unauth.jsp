<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE html>
<html>
   <head>
     <title>无权访问</title>
     <%@include file="/WEB-INF/views/jsp/common/head.jsp"%>
     <link rel="shortcut icon" href="${ctx}/front/spring/favicon.ico"/>
   </head>
<body>
		<div style="position: relative;margin-top: 100px;margin-left: 25%">
			<img alt="" src="${ctx}/static/images/uauthc.jpg"/>
			<span style="color: red;font-size: 20px">您没有权限访问该页面，请先联系管理员!</span>
		</div>
</body>
</html>