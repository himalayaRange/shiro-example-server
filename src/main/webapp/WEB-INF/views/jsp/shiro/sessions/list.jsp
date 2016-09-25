<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>在线用户列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 在线用户列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemin" class="input-text Wdate" style="width:186px;">
		-
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemax" class="input-text Wdate" style="width:186px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入SESSIONID" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜在线用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		 <span class="r">共有数据：<strong>12</strong> 条</span>
	</div>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="7">在线用户列表</th>
			</tr>
			<tr class="text-c">
				<th width="10"><input type="checkbox" name="" value=""></th>
				<th width="10%">会话ID</th>
				<th width="10%">用户名</th>
				<th width="15%">主机地址</th>
				<th width="15%">最后访问时间</th>
				<th width="15%">已强制退出</th>
				<th width="25%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessions}" varStatus="id">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${item.id}</td>
					<td>${fun:principal(session)}</td>
					<td>${session.host}</td>
					<td ><fmt:formatDate value="${session.lastAccessTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${fun:isForceLogout(session) ? '是' : '否'}</td>
					<td class="td-manage">
						 <c:if test="${not fun:isForceLogout(session)}">
                       		 <a href="${ctx}/admin/sessions/${session.id}/forceLogout">强制退出</a>
                   		 </c:if>
					</td>
				
				</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
</body>
</html>