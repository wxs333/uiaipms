/**
 * 加载依赖的模块
 */
layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var $ = layui.$;
    var _layer = layui.layer;
    // 绑定点击事件
    $('#info').click(function () {
        // 弹出基本资料框
        var data = {"title": "基本资料", "url": "/stu/info"};
        openHtml(_layer, data);
    });
    // 菜单点击事件监听
    navClick(element, $, _layer);
    // 头像显示
    headImg($)
});

/**
 * 头像显示
 */
function headImg($) {
    $("#img").attr("src", "/api/user/headImg");
}

/**
 * 左侧菜单栏点击的响应事件
 */
function navClick(element, $, _layer) {
    element.on('nav', function (elem) {
        var id = elem.attr('id');
        // 更换页面
        changeHtml(id, $, _layer);
    });
}

/**
 * 更换页面
 */
function changeHtml(id, $, _layer) {
    var elem = $("#content");
    switch (id) {
        case "member":
            elem.attr("src", "/admin/member");
            break;
        case "authority":
            elem.attr("src", "/admin/authority");
            break;
        case "stock":
            elem.attr("src", "/sto/list");
            break;
        case "sto-fin":
            elem.attr("src", "/bf/list");
            break;
            case "pro-fin":
            elem.attr("src", "/pf/list");
            break;
        case "project-sb":
            elem.attr("src", "/pro/sb");
            break;
        case "project-sp":
            elem.attr("src", "/pro/sp");
            break;
        case "project-lx":
            elem.attr("src", "/ps/list");
            break;
        case "studio":
            elem.attr("src", "/stud/list");
            break;
        case "com-studio":
            elem.attr("src", "/com/myStudio");
            break;
        case "goods":
            elem.attr("src", "/goods/list");
            break;
        case "project-sh":
            elem.attr("src", "/pr/list");
            break;
        case "buy-funds-apply":
            var data = {
                "title": "采购资金申请", "url": "/bf/apply"
            };
            openHtml(_layer, data);
            break;

    }
}

/**
 * 弹出HTML页面
 */
function openHtml(_layer, data) {
    _layer.open({
        type: 2,
        title: data.title,
        content: data.url,
        area: ["1100px", "630px"],
        anim: 1,
        scrollbar: false,
        offset: ['50px', "300px"]
    });
}