<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>字典列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 数据字典 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemin" class="input-text Wdate" style="width:186px;">
		-
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemax" class="input-text Wdate" style="width:186px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入字典代码" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜字典</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a href="javascript:;" onclick="dic_add('添加字典详情','${ctx}/admin/sys/dic/add','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加字典详情</a></span> <span class="r">共有数据：<strong>12</strong> 条</span>
	</div>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="10">字典详情列表</th>
			</tr>
			<tr class="text-c">
				<th width="5%"><input type="checkbox" name="" value=""></th>
				<th width="5%">字典标识</th>
				<th width="10%">字典编码</th>
				<th width="10%">值</th>
				<th width="10%">名称</th>
				<th width="5%">排序</th>
				<th width="15%">创建时间</th>
				<th width="15%">修改时间</th>
				<th width="10%">是否有效</th>
				<th width="15%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${dicList}" varStatus="id">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${id.index+1}</td>
					<td>${item.dic_code}</td>
					<td>${item.dic_value}</td>
					<td>${item.dic_label}</td>
					<td>${item.orders}</td>
					<td><fmt:formatDate value="${item.create_date}" pattern="yyyy-MM-dd hh:mm"/> </td>
					<td><fmt:formatDate value="${item.update_date}" pattern="yyyy-MM-dd hh:mm"/> </td>
					<td>
						<c:if test="${item.is_valid==false}"><input class="btn btn-danger size-S radius" type="button" value="无效"></c:if>
						<c:if test="${item.is_valid==true}"><input class="btn btn-success size-S radius" type="button" value="有效"></c:if>
					</td>
					<td class="td-manage">
						<a title="编辑" href="javascript:;" onclick="dic_edit('字典详情编辑','${ctx}/admin/sys/dic/update/${item.id}','2','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-secondary-outline radius">编辑</button>
						</a>
					</td>
				</tr>
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
/*资源-编辑*/
function dic_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*资源-添加*/
function dic_add(title,url,w,h){
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