/**
 * 加载依赖的模块
 */
layui.use('element', function () {
    var element = layui.element;
    var $ = layui.$;
    navClick(element, $);
    // 绑定点击事件
    click($);
});

/**
 * 左侧菜单栏点击的响应时间
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
            elem.attr("src", "");
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

/**
 * 绑定点击事件
 */
function click($) {
    $('#info').click(function () {
            $("#content").attr("src", "/stu/info");
        }
    );
}