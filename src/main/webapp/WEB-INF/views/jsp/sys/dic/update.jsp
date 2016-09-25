<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<title>编辑字典 - 系统管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="dic_update_form" method="post" accept-charset="utf-8">
	<input type="hidden"  name="id" value="${sys_dic.id}"/>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字典代码（英文）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="dic_code" id="dic_code" class="input-text"></select>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="dic_value" id="dic_value" class="input-text"></select>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off"  value="${sys_dic.dic_label}" placeholder="名称"  name="dic_label">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排序：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="orders" id="orders" class="input-text"></select>
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
			<button class="btn btn-primary radius" id="update_btn" type="button" >&nbsp;&nbsp;<i class="Hui-iconfont">&#xe632;&nbsp;&nbsp;</i>修改</button>
		</div>
	</div>
	</form>
</article>

<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript">
		$(function(){
			
			$.each(${json_sysDicMenu},function(index,ele){
				$("#dic_code").append('<option style="color:blue;font-size:16px" value="'+ele.dic_code+'">'+ele.dic_name+'****'+ele.dic_code+'</option>');
			});
			$("#dic_code").val("${sys_dic.dic_code}");
			
			init_int_sel($("#dic_value"),0,10);
			$("#dic_value").val(${sys_dic.dic_value});
			
			init_int_sel($("#orders"),0,10);
			$("#orders").val(${sys_dic.orders});
			
			init_valid_sel($("#is_valid"));
			$("#is_valid").val("${sys_dic.is_valid}");
			
			$("#update_btn").click(function(){
				show_loading('${ctx}');
				$.ajax({
					url:'${ctx}/admin/sys/dic/updateDic',
					type:'POST',
					data:$("#dic_update_form").serialize(),
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
