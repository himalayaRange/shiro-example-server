<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/views/jsp/common/base_head.jsp"%>
<link rel="stylesheet" href="${ctx}/static/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>菜单树</title>
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
</head>
<body class="pos-r">
<div class="pos-a" style="width:200px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5">
	<ul id="treeDemo" class="ztree">
	</ul>
</div>
<div style="margin-left:200;">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 菜单管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemin" class="input-text Wdate" style="width:186px;">
		-
		<input type="text" onfocus="WdatePicker({isShowClear:false,firstDayOfWeek:1,onpicked:weekDay})"  id="datemax" class="input-text Wdate" style="width:186px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入节点名称" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜菜单</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a href="javascript:;" onclick="tree_add('添加菜单节点','${ctx}/admin/sys/menu/add','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加菜单节点</a></span> <span class="r">共有数据：<strong>12</strong> 条</span>
	</div>
	<table class="table table-border table-bordered table-bg table-hover radius">
		<thead>
			<tr>
				<th scope="col" colspan="14">菜单节点列表</th>
			</tr>
			<tr class="text-c">
					<th width="5%"><input name="" type="checkbox" value=""></th>
					<th width="5%">节点ID</th>
					<th width="5%">父节点ID</th>
					<th width="10%">节点名称</th>
					<th width="10%">自定义图标</th>
					<th width="10%">链接</th>
					<th width="5%">打开方式</th>
					<th width="5%">排序</th>
					<th width="10%">创建时间</th>
					<th width="10%">修改时间</th>
					<th width="5%">是否展开</th>
					<th width="5%">节点属性</th>
					<th width="5%">是否隐藏</th>
					<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${nodeList}" varStatus="id"> 
				<tr class="text-c va-m">
					<td><input name="" type="checkbox" value=""></td>
					<td>${id.index+1}</td>
					<td>${item.parentId}</td>
					<td>${item.name}</td>
					<td>${item.iconSkin}</td>
					<td>${item.url}</td>
					<td>${item.target}</td>
					<td>${item.orders}</td>
					<td><fmt:formatDate value="${item.create_date}" pattern="yyyy-MM-dd hh:mm"/> </td>
					<td><fmt:formatDate value="${item.update_date}" pattern="yyyy-MM-dd hh:mm"/> </td>
					<td>
						<c:if test="${item.open==true}"><span class="label label-success radius">展开</span></c:if>
						<c:if test="${item.open==false}"><span class="label label-warning radius">关闭</span></c:if>
					</td>
					<td>
						<c:if test="${item.isParent==true}"><span class="label  label-danger  radius">父子节点</span></c:if>
						<c:if test="${item.isParent==false}"><span class="label label-secondary  radius">叶子节点</span></c:if>
					</td>
					<td>
						<c:if test="${item.isHidden==true}"><span class="label  label-danger  radius">隐藏</span></c:if>
						<c:if test="${item.isHidden==false}"><span class="label label-secondary  radius">显示</span></c:if>
					</td>
					<td>
						<a title="编辑" href="javascript:;" onclick="tree_edit('菜单树编辑','${ctx}/admin/sys/tree/update/${item.id}','2','800','500')" class="ml-5" style="text-decoration:none">
							<button type="button" class="btn btn-secondary-outline radius">编辑</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript" src="${ctx}/static/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
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
			}
		}
	};

	var zNodes=${nodes};
			
	$(document).ready(function(){
		var t = $("#treeDemo");
		t = $.fn.zTree.init(t, setting, zNodes);
	});
	
	/*菜单树-添加*/
	function tree_add(title,url,w,h){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
	
	/*菜单树-编辑*/
	function tree_edit(title,url,w,h){
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