/**
 * 加载依赖的模块
 */
layui.use('element', function() {
	var element = layui.element;
	navClick(element);

});

/**
 * 左侧菜单栏点击的响应时间
 * @param {Object} element element模块
 */
function navClick(element) {
	element.on('nav', function(elem) {
		console.log(elem.context.id);
	});
}