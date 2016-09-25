<%@ page contentType="text/html;charset=UTF-8" %>
<meta charset="utf-8">
<script type="text/javascript" src="${ctx}/static/js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx}/static/images/tooltips.js"></script>
<script type="text/javascript" src="${ctx}/static/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${ctx}/static/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="${ctx}/static/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${ctx}/static/H-ui/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx}/static/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javaScript" src="${ctx}/static/js/jquery.jclock.js"></script>
<script type="text/javascript" src="${ctx}/static/js/utils.js"></script>
<script type="text/javascript">
$(function(){
	$('#curr_time').jclock({withDate:true, withWeek:true, fontSize: '14px' });
});
function weekDay(){
	var date=$dp.cal.getP('y')+"-"+$dp.cal.getP('M')+"-"+$dp.cal.getP('d')+" "+showWeek($dp.cal.getP('w'));
	this.value=date;//this代表当前input框
	}
	function showWeek(week){
	var wk="";
	switch(parseInt(week)){
	case 0:
	wk="星期日";
	break;
	case 1:
	wk="星期一";
	break;
	case 2:
	wk="星期二";
	break;
	case 3:
	wk="星期三";
	break;
	case 4:
	wk="星期四";
	break;
	case 5:
	wk="星期五";
	break;
	case 6:
	wk="星期六";
	break;
	}
	return wk;
	}
</script>