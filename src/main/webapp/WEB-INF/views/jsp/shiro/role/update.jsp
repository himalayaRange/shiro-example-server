<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>编辑角色 - 管理员管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="role_update_form" method="post" accept-charset="utf-8">
	<input type="hidden"  name="id" value="${role.id}"/>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称（可以是中文）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off" value="${role.name}" placeholder="角色名称"  name="name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色命名SN（必须是英文）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off" value="${role.sn}" placeholder="角色命名SN"  name="sn">
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<button class="btn btn-primary radius" id="update_btn" type="button" >&nbsp;&nbsp;<i class="Hui-iconfont">&#xe632;&nbsp;&nbsp;</i>修改</button>
		</div>
	</div>
	</form>
</article>

<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#update_btn").click(function(){
			show_loading('${ctx}');
			$.ajax({
				url:'${ctx}/admin/role/updateRole',
				type:'POST',
				data:$("#role_update_form").serialize(),
				dataType:'json',
				success:function(data){
					if(data.success){
						var index = parent.layer.getFrameIndex(window.name);//获取当前窗口的索引
				    	parent.layer.close(index);//关闭当前窗口  
						//show_msg("${ctx}",'用户编辑成功！  正在为您跳转...','',1000);
					}else {
						show_err_msg("${ctx}",data.emsg);
					}
				},
				error:function(data){
					show_err_msg("${ctx}","系统繁忙，请稍后再试!");
				}
			});
		});
	});
		
</script>
</body>
</html>
