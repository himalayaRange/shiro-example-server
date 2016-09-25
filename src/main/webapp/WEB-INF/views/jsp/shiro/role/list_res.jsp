<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>角色资源设置 - 管理员管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="#" method="post" id="set_res_form" accept-charset="utf-8">
	<input type="hidden" name="roleId" value="${roleId}"/>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="5">资源列表</th>
			</tr>
			<tr class="text-c">
				<th width="5%">序号</th>
				<th width="30%">资源名称</th>
				<th width="40%">资源URL</th>
				<th width="20%">资源权限字符串</th>
				<th width="5%">资源选择</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${allRes}" varStatus="id">
				<tr class="text-c">
					<td>${id.index+1}</td>
					<td>${item.name}</td>
					<td>${item.url}</td>
					<td>${item.permission}</td>
					<td>
						<input type="checkbox" name="resIds" id="resId_${item.id}" value="${item.id}" /> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
				<tr>
					<td colspan="5" >
						<button style="position: relative;margin-left: 40%;" class="btn btn-primary radius" id="set_res_btn" type="button" ><i class="Hui-iconfont">&#xe632;</i>设置资源</button>
					</td>
				</tr>
		</tfoot>
	</table>
	</form>
</article>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript">
		$(function(){
			$.each(${json_allRes},function(index,ele){
				$.each(${json_roleRes},function(i,e){
					if(ele.id=e.id){
						var dom="resId_"+e.id;
						$("#"+dom).attr("checked",true);
					}
				});
			});
			
			$("#set_res_btn").click(function(){
					$.ajax({ 
						type: "Post",
						cache:false,
						async:false,
						url:"${ctx}/admin/role/updateRes",
						data:$("#set_res_form").serialize(),
						dataType: "json",
						success: function(data) {
							if(data.success){
								show_msg("${ctx}",'角色资源设置成功！ 等待页面刷新...','javascript:location.replace(location.href);',1000);
							}else{
								show_err_msg("${ctx}",data.emsg);
							}
						},
					 	error: function(err) { 
					 		show_err_msg("${ctx}","系统繁忙，请稍后再试!");
					    },
					} );  
			});
		});	
	</script>
</body>
</html>