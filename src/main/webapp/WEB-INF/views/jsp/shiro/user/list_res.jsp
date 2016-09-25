<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>管理员访问资源 - 管理员管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<div class="mt-20">
	<table class="table table-border table-bordered table-bg table-hover table-sort radius">
		<thead>
			<tr>
				<th scope="col" colspan="4">会员列表</th>
			</tr>
			<tr class="text-c">
				<th width="10%">序号</th>
				<th width="30%">资源名称</th>
				<th width="40%">资源URL</th>
				<th width="20%">资源权限字符串</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${resources}" varStatus="id">
				<tr class="text-c">
					<td>${id.index+1}</td>
					<td>${item.name}</td>
					<td>${item.url}</td>
					<td>${item.permission}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</article>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
</body>
</html>