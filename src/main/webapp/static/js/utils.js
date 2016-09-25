/**
 * 初始化数字数据下拉框
 */
function init_int_sel(dom,start,end){
	var sel_html=$(dom);
	for(var i=start;i<=end;i++){
		sel_html.append('<option value='+i+'>'+i+'</option>');
	}
}


/*
 * 初始化是否有效
 * 1：有效 0,无效
 */
function init_valid_sel(dom){
	var sel_html=$(dom);
	sel_html.append('<option value="true">有效</option><option value="false">无效</option>');
}