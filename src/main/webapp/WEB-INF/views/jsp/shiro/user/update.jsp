<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>编辑管理员 - 管理员管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="user_update_form" method="post" accept-charset="utf-8">
	<input type="hidden"  name="id" value="${user.id}"/>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off" value="${user.username}" placeholder="用户名"  name="username">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>昵称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off" value="${user.nickname}" placeholder="昵称"  name="nickname">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" autocomplete="off"  placeholder="新密码"  name="password">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">状态：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="status" size="1">
				<option value="1" <c:if test="${user.status==1}">selected</c:if> >启用</option>
				<option value="0" <c:if test="${user.status==0}">selected</c:if> >停用</option>
			</select>
			</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<c:forEach var="item" items="${allRoles}">
				<input type="checkbox" name="roleId" id="roleId_${item.id}" value="${item.id}">${item.name}</input>
			</c:forEach>
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
			$.each(${json_allRoles},function(index,ele){
				console.log(ele.id+"--------"+ele.name);
				$.each(${json_userRoles},function(i,e){
				if(ele.id==e.id){
					console.log(e.id+"----"+e.name);
					var dom="roleId_"+e.id;
					$("#"+dom).attr("checked",true);
				}
				});
			});
			$("#update_btn").click(function(){
				show_loading('${ctx}');
				$.ajax({
					url:'${ctx}/admin/user/updateUser',
					type:'POST',
					data:$("#user_update_form").serialize(),
					dataType:'json',
					success:function(data){
						if(data.success){
							var index = parent.layer.getFrameIndex(window.name);//获取当前窗口的索引
					    	parent.layer.close(index);//关闭当前窗口  
							///show_msg("${ctx}",'用户编辑成功！  正在为您跳转...','',1000);
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
