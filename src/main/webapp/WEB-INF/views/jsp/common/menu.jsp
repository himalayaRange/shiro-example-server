<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<shiro:hasPermission name="/admin/client/list">
						<li><a _href="${ctx}/admin/client/list" data-title="客户端管理" href="javascript:void(0)">客户端管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/sessions/list">
						<li><a _href="${ctx}/admin/sessions/list" data-title="会话管理" href="javascript:void(0)">会话管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/user/list">
						<li><a _href="${ctx}/admin/user/list"  data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/role/list">
						<li><a _href="${ctx}/admin/role/list" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/res/list">
						<li><a _href="${ctx}/admin/res/list" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
					</shiro:hasPermission>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<!-- 只允许管理员查看 -->
					<shiro:hasPermission name="/admin/druid">
						<li><a  data-title="系统监控" href="${ctx}/druid/index.html" target="_blank">系统监控</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/sys/dic/*">
					<li>
						<a data-title="数据字典" href="javascript:void(0)">数据字典</a>
						<ul>
							<li><a _href="${ctx}/admin/sys/dic/listMenu" data-title="字典菜单" href="javascript:void(0)">字典菜单</a></li>
							<li><a _href="${ctx}/admin/sys/dic/list" data-title="字典详情" href="javascript:void(0)">字典详情</a></li>
						</ul>
					</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/admin/sys/menu/tree">
						<li><a _href="${ctx}/admin/sys/menu/tree" data-title="菜单管理" href="javascript:void(0)">菜单管理</a></li>
						<!--<li><a _href="#" data-title="系统日志" href="javascript:void(0)">系统日志</a></li> -->
					</shiro:hasPermission>
				</ul>
			</dd>
		</dl>
	</div>
</aside>