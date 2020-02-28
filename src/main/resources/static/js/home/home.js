/**
 * 加载依赖的模块
 */
layui.use(['element','layer'], function () {
    var element = layui.element;
    var $ = layui.$;
    var _layer = layui.layer;
    // 绑定点击事件
    $('#info').click(function () {
        // 弹出基本资料框
        _layer.open({
            type: 2,
            title: "基本资料",
            content: '/stu/info',
            area: ['650px', '510px'],
            anim: 1,
            scrollbar: false,
            offset: '30px'
        });
    });
    navClick(element, $);
});

/**
 * 左侧菜单栏点击的响应事件
 */
function navClick(element, $) {
    element.on('nav', function (elem) {
        var id = elem.attr('id');
        changeHtml(id, $);
    });
}

/**
 * 更换页面
 */
function changeHtml(id, $) {
    var elem = $("#content");
    switch (id) {
        case "member":
            elem.attr("src", "/admin/member");
            break;
        case "authority":
            elem.attr("src", "/admin/authority");
            break;
        case "finance":
            elem.attr("src", "");
            break;
        case "stock":
            elem.attr("src", "/sto/list");
            break;
        case "project-sb":
            elem.attr("src", "/pro/sb");
            break;
        case "project-sp":
            elem.attr("src", "");
            break;
        case "project-lx":
            elem.attr("src", "");
            break;
        case "studio":
            elem.attr("src", "/stud/list");
            break;
    }
}