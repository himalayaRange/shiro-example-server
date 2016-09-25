<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>OAuth2授权登录</title>
<meta name="keywords" content="H-ui.admin v2.4,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.4，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<style>
	.error{color:red;margin-left: 10px}
	.dlsq{position: relative;margin-top: 100px}
</style>
</head>
<body>

	<div class="codeView dlsq">
		<form action="" method="post" class="form form-horizontal" >
			<legend>OAuth2授权登录</legend>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">用户名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" name="username"   autocomplete="off" placeholder="用户名">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" name="password" autocomplete="off" placeholder="密码">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button class="btn btn-primary radius" id="add_btn" type="submit" >&nbsp;&nbsp;<i class="Hui-iconfont">&#xe632;&nbsp;&nbsp;</i>登录并授权</button>
					<span class="error">${error}</span>
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>