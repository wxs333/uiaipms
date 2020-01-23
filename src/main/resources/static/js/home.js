/**
 * 加载依赖的模块
 */
layui.use('element', function() {
	var element = layui.element;
	var $ = layui.$;
	navClick(element, $);
});

/**
 * 左侧菜单栏点击的响应时间
 */
function navClick(element, $) {
	element.on('nav', function(elem) {
		var id = elem.attr('id');
		changeHtml(id, $);
	});
}
/**
 * 更换页面
 */
function changeHtml(id, $) {
	switch(id) {
		case "member":
			$("#content").attr("src", "/admin/member");
			break;
		case "authority":
			$("#content").attr("src", "/admin/authority");
			break;
		case "finance":
			$("#content").attr("src", "");
			break;
		case "stock":
			$("#content").attr("src", "");
			break;
		case "project-sb":
			$("#content").attr("src", "");
			break;
		case "project-sp":
			$("#content").attr("src", "");
			break;
		case "project-lx":
			$("#content").attr("src", "");
			break;
		case "studio":
			$("#content").attr("src", "");
			break;
	}
}
