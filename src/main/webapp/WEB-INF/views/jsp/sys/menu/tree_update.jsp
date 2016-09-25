<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<link rel="stylesheet" href="${ctx}/static/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<style type="text/css">
.ztree li span.button.pIcon01_ico_open{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/1_open.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.pIcon01_ico_close{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/1_close.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.pIcon02_ico_open, .ztree li span.button.pIcon02_ico_close{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/2.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon01_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/3.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon02_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/4.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon03_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/5.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon04_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/6.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon05_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/7.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon06_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/8.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon07_ico_docu{margin-right:2px; background: url(${ctx}/static/lib/zTree/v3/css/zTreeStyle/img/diy/9.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
</style>
<title>编辑菜单节点- 系统管理</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal"  id="tree_update_form" method="post" accept-charset="utf-8">
	<input type="hidden" name="id" value="${node.id}"/>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>父节点：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="hidden" id="parentId" name="parentId"/>
			<input type="text" readonly="readonly" id="parentIdText" class="input-text" onfocus="$('#menu_div').show()"   maxlength="64" autocomplete="off"  placeholder="父节点"  name="parentIdText">
			<div id="menu_div"  style="width:100%;display:none; left:0;top:0; bottom:0; border-right:1px solid #e5e5e5; background-color:#f5f5f5">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>节点名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" name="name" id="name" value="${node.name}" class="input-text"/>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否展开：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="open" id="open" class="input-text">
				<option value="0" <c:if test="${node.open==false}">selected</c:if>>关闭</option>
				<option value="1" <c:if test="${node.open==true}">selected</c:if>>展开</option>
			</select>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>自定义图标：</label>
		<div class="formControls col-xs-8 col-sm-9">
			
			<%@include file="/WEB-INF/views/jsp/common/tree_icon.jsp"%>
	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>链接：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" maxlength="200" value="${node.url}" name="url" id="url" class="input-text" />
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>链接打开方式：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="target" id="target" class="input-text">
				<option value="_blank" <c:if test="${node.target=='_blank'}">selected</c:if> >新窗口</option>
				<option value="_self"  <c:if test="${node.target=='_self'}">selected</c:if>>当前窗口</option>
			</select>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>节点属性：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="isParent" id="isParent" class="input-text">
				<option value="0" <c:if test="${node.isParent==false}">selected</c:if> >叶子节点</option>
				<option value="1" <c:if test="${node.isParent==true}">selected</c:if>>父节点</option>
			</select>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否隐藏：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<select name="isHidden" id="isHidden" class="input-text">
				<option value="0" <c:if test="${node.isHidden==false}">selected</c:if> >显示</option>
				<option value="1" <c:if test="${node.isHidden==true}">selected</c:if> >隐藏</option>
			</select>
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
<script type="text/javascript" src="${ctx}/static/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
	$(function(){
		 
		$("#parentId").attr("value",'${node.parentId}');
		
		if('${node.iconSkin}'!=''){
			$("input[type=radio][name=iconSkin][value="+'${node.iconSkin}'+"]").attr("checked",'checked');
		}
		
		init_int_sel($("#orders"),0,10);
		$("#orders").val("${node.orders}");
		
		init_valid_sel($("#is_valid"));
		$("#is_valid").val("${node.is_valid}");
		
		$("#update_btn").click(function(){
			show_loading('${ctx}');
			$.ajax({
				url:'${ctx}/admin/sys/tree/updateTree',
				type:'POST',
				data:$("#tree_update_form").serialize(),
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
		
	var setting = {
			view: {
				dblClickExpand: true,
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable:true,
					idKey: "id",
					pIdKey: "parentId",
					rootPId: ""
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("tree");
					if (treeNode.isParent) {
						//zTree.expandNode(treeNode);
						return false;
					} else {
						//demoIframe.attr("src",treeNode.file + ".html");
						return true;
					}
				},
				onDblClick:function(event, treeId, treeNode){
					//原则：叶子节点下不能建立叶子节点，父节点下才可以建立叶子节点
					if(treeNode.isParent){
						 $("#parentIdText").attr("value",treeNode.name);
						 $("#parentId").attr("value",treeNode.id);
						 console.log(treeNode.id+","+treeNode.name);
					 }else{
						 show_err_msg("${ctx}","不能选择叶子节点作为父节点！");
					 }
				}
			}
		};

		var zNodes=${nodes};
				
		$(document).ready(function(){
			var t = $("#treeDemo");
			t = $.fn.zTree.init(t, setting, zNodes);
			//zTreeObject获取并获取父类节点
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var parentNode=zTree.getNodeByParam("id","${node.parentId}",null);
			$("#parentIdText").attr("value",parentNode.name);
		});
		
		
</script>
</body>
</html>
