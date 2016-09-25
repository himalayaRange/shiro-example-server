<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>添加字典菜单- 系统管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="dicMenu_add_form" method="post" accept-charset="utf-8">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字典代码（英文）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off"  placeholder="字典代码（只支持英文）"  name="dic_code">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字典名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off"  placeholder="字典名称"  name="dic_name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否有效：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="is_valid" id="is_valid" class="input-text"></select>
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<button class="btn btn-primary radius" id="add_btn" type="button" >&nbsp;&nbsp;<i class="Hui-iconfont">&#xe632;&nbsp;&nbsp;</i>添加</button>
		</div>
	</div>
	</form>
</article>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript">
		$(function(){
			init_valid_sel($("#is_valid"));
			
			$("#add_btn").click(function(){
				$.ajax({
					url:'${ctx}/admin/sys/dic/addDicMenu',
					type:'POST',
					data:$("#dicMenu_add_form").serialize(),
					dataType:'json',
					success:function(data){
						if(data.success){
							var index = parent.layer.getFrameIndex(window.name);//获取当前窗口的索引
					    	parent.layer.close(index);//关闭当前窗口 
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
