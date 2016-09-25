<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/tag.jsp"%>
<!DOCTYPE html>
<html>
   <head>
     <title>用户登录</title>
     <%@include file="/WEB-INF/views/jsp/common/head.jsp"%>
     <link rel="shortcut icon" href="${ctx}/static/spring/favicon.ico"/>
     <link rel="stylesheet" href="${ctx}/static/css/supersized.css">
	 <link rel="stylesheet" href="${ctx}/static/css/login.css">
	 <style type="text/css">
	 	 /* 以下遮罩层为demo.用户可自行设计实现 */
        #mask {
            display: none;
            position: fixed;
            text-align: center;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            overflow: auto;
        }
        /* 可自行设计实现captcha的位置大小 */
        .popup-mobile {
            position: relative;
        }
        #popup-captcha-mobile {
            position: fixed;
            display: none;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            -webkit-transform: translate(-50%, -50%);
            z-index: 9999;
        }
	 </style>
   </head>
   
<body>
	<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="${ctx}/static/images/login/logo.png" >
			</div>
			<div class="login_form">
				<form action="#" id="login_form" accept-charset="utf-8"   method="post" class="login">
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label> 
						<input id="username" name="username"  value="" autocomplete="off" type="text"
						 class="form-control x319 in"/>
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" value=""  autocomplete="off" name="password" type="password" 
						 class="password form-control x319 in"/>
					</div>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input id="j_remember" name="rememberMe" value="true" type="checkbox" value="true">&nbsp;一周免登陆!</label>
						<span style="color: red"><c:if test="${not empty param.kickout}">&nbsp;&nbsp;&nbsp;&nbsp;您的账户被强制踢出！</c:if></span>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="button"  id="submit_btn"  
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp; </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
					<!-- 极速验证，本次采用手机端 -->
					<div id="mask"></div>
    				<div id="popup-captcha-mobile"></div>
    				
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2016 - 2020 <a href="#">系统登陆</a></div>
	</div>
</div>
<!-- Javascript -->
<%@include file="/WEB-INF/views/jsp/common/foot_js.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/supersized-init.js"></script>
<script type="text/javascript" src="${ctx}/static/js/login.js"></script>
<!-- 引入封装了failback的接口--initGeetest -->
<script src="http://static.geetest.com/static/tools/gt.js"></script>

<script>
    $("#mask").click(function () {
        $("#mask, #popup-captcha-mobile").hide();
    });
    $("#submit_btn").click(function () {
        $("#mask, #popup-captcha-mobile").show();
    });
    var handlerPopupMobile = function (captchaObj) {
        // 将验证码加到id为captcha的元素里
        captchaObj.appendTo("#popup-captcha-mobile");
        //拖动验证成功后两秒(可自行设置时间)自动发生跳转等行为
        captchaObj.onSuccess(function () {
            var validate = captchaObj.getValidate();
            $.ajax({
                url: "mobile-geetest/validate", // 进行二次验证
                type: "post",
                dataType: "json",
                data: {
                    // 二次验证所需的三个值
                    username: $('#username').val(),
                    password: $('#password').val(),
                    rememberMe: $('#j_remember').val(),
                    geetest_challenge: validate.geetest_challenge,
                    geetest_validate: validate.geetest_validate,
                    geetest_seccode: validate.geetest_seccode
                },
                success: function (data) {
                    if (data && (data.status === "success")) {
                    	//提示信息  URL 跳转时间
						show_msg("${ctx}",'登录成功咯！  正在为您跳转...','${ctx}/admin/index',1500);
                    } else {
                    	show_err_msg("${ctx}",data.emsg);
                    }
                }
            });
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
    $.ajax({
        // 获取id，challenge，success（是否启用failback）
        url: "mobile-geetest/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 使用initGeetest接口
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handlerPopupMobile);
        }
    });
</script>

<!-- <script type="text/javascript">
	$(function(){
		//提交表单
		$('#submit_btn').click(function(){
			show_loading("${ctx}");
			$.ajax({
				url:'${ctx}/shiroAuth',
				type:'POST',
				data:$("#login_form").serialize(),
				dataType:'json',
				success:function(data){
					if(data.success){
						//提示信息  URL 跳转时间
						show_msg("${ctx}",'登录成功咯！  正在为您跳转...','${ctx}/admin/index',1500);
						
					}else {
						show_err_msg("${ctx}",data.emsg);
					}
				},
				error:function(data){
				}
			});
		});
	});
</script> -->

<div style="text-align:center;">
</div>
</body>
</html>