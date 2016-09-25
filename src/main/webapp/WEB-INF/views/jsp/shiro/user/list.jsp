<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>会员列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemin" class="input-text Wdate" style="width:186px;">
		-
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemax" class="input-text Wdate" style="width:186px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入管理员名称" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a href="javascript:;" onclick="admin_add('添加管理员','${ctx}/admin/user/add','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span> <span class="r">共有数据：<strong>12</strong> 条</span>
	</div>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="7">管理员列表</th>
			</tr>
			<tr class="text-c">
				<th width="10"><input type="checkbox" name="" value=""></th>
				<th width="10%">ID</th>
				<th width="10%">用户名</th>
				<th width="15%">用户昵称</th>
				<th width="15%">角色</th>
				<th width="15%">启用状态</th>
				<th width="25%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${users}" varStatus="id">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${id.index+1}</td>
					<td>${item.username}</td>
					<td>${item.nickname}</td>
					<td >${item.roles}</td>
					<c:if test="${item.status==1}">
						<td class="td-status"><span class="label label-success radius">已启用</span></td>
					</c:if>
					<c:if test="${item.status==0}">
						<td class="td-status"><span class="label radius">已停用</span></td>
					</c:if>
					<td class="td-manage">
						<c:if test="${item.status==0}">
							<a style="text-decoration:none" onClick="admin_start('${item.id}')" href="javascript:;" title="启用">
							<button type="button" class="btn btn-success-outline radius">启用</button>
						</a> 
						</c:if>
						<c:if test="${item.status==1}">
							<a style="text-decoration:none" onClick="admin_stop('${item.id}')" href="javascript:;" title="停用">
							<button type="button" class="btn btn-danger-outline radius">禁用</button>
						</a> 
						</c:if>
						<a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','${ctx}/admin/user/update/${item.id}','2','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-secondary-outline radius">编辑</button>
						</a>
						<a title="访问资源权限" href="javascript:;" onclick="admin_res('资源访问权限','${ctx}/admin/user/listRes/${item.id}','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-success-outline radius">资源权限</button>
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
/*管理员-增加*/
function admin_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}


/*管理员-资源访问权限*/
function admin_res(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*管理员-编辑*/
function admin_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*管理员-停用*/
function admin_stop(userId){
	layer.confirm('确认要禁用该用户？',function(index){
		layer.closeAll();
		$.ajax({
			url:'${ctx}/admin/user/jy/'+userId,
			type:'POST',
			dataType:'json',
			success:function(data){
				if(data.success){
				      show_msg("${ctx}",'用户禁用成功！  正在为您跳转...','javascript:location.replace(location.href);',1000);
				}else {
					show_err_msg("${ctx}",data.emsg);
				}
			},
			error:function(data){
				show_err_msg("${ctx}","系统繁忙，请稍后再试!");
			}
		});
	});
}

/*管理员-启用*/
function admin_start(userId){
	layer.confirm('确认要启用该用户？',function(index){
		layer.closeAll();
		$.ajax({
			url:'${ctx}/admin/user/qy/'+userId,
			type:'POST',
			dataType:'json',
			success:function(data){
				if(data.success){
				      show_msg("${ctx}",'用户启用成功！  正在为您跳转...','javascript:location.replace(location.href);',1000);
				}else {
					show_err_msg("${ctx}",data.emsg);
				}
			},
			error:function(data){
				show_err_msg("${ctx}","系统繁忙，请稍后再试!");
			}
		});
	});
}

</script>
</body>
</html>