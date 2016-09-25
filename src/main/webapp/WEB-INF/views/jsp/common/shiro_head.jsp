<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div style="margin-top: 30px;font-size: 20px">
	<shiro:authenticated>
		<shiro:hasPermission name="/admin/res/list">
			<a href="${ctx}/admin/res/list">资源管理</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="/admin/role/list">
			<a href="${ctx}/admin/role/list">角色管理</a> 
		</shiro:hasPermission>
		<shiro:hasPermission name="/admin/user/list">
			<a href="${ctx}/admin/user/list">用户管理</a>
		</shiro:hasPermission>
		
		<span style="margin-right:30px;float: right;font-size: 14px" >
			欢迎<span style="position:relative;  margin-right: 10px;color: blue;"><shiro:principal property="nickname" /></span>
			<a href="${ctx}/logout">退出登录</a>
		</span>
	</shiro:authenticated>
	<shiro:guest>
		<a href="${ctx}/login" style="position: relative;margin-left: 10px;font-size: 20px">登陆系统</a>
	</shiro:guest>	
</div> 
