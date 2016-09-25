<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>角色列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemin" class="input-text Wdate" style="width:186px;">
		-
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemax" class="input-text Wdate" style="width:186px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入角色名称" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜角色</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a href="javascript:;" onclick="role_add('添加角色','${ctx}/admin/role/add','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a></span> <span class="r">共有数据：<strong>12</strong> 条</span>
	</div>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="5">角色列表</th>
			</tr>
			<tr class="text-c">
				<th width="5%"><input type="checkbox" name="" value=""></th>
				<th width="15%">ID</th>
				<th width="25%">角色名称</th>
				<th width="25%">角色SN</th>
				<th width="30%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${roles}" varStatus="id">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${id.index+1}</td>
					<td>${item.name}</td>
					<td>${item.sn}</td>
					<td class="td-manage">
						<a title="角色编辑" href="javascript:;" onclick="role_edit('角色编辑','${ctx}/admin/role/update/${item.id}','2','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-secondary-outline radius">编辑</button>
						</a>
						<a title="设置资源" href="javascript:;" onclick="role_res('设置资源','${ctx}/admin/role/listRes/${item.id}','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-success-outline radius">设置资源</button>
						</a>
					</td>
				
				</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*角色-增加*/
function role_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*角色-设置资源*/
function role_res(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*角色-编辑*/
function role_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

</script>
</body>
</html>