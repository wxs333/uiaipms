/**
 * 加载依赖的模块
 */
layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var $ = layui.$;
    var _layer = layui.layer;
    // 昵称，角色获取
    showNickname($);
    // 菜单点击事件监听
    navClick(element, $, _layer);
    // 头像显示
    headImg($);

    // 绑定点击事件
    click($, _layer);

});

/**
 * 绑定点击事件
 */
function click($, _layer) {
    $('#info').click(function () {
        var url = "";
        var role = $("#role").val();
        var userId = $("#userId").val();
        if (role === "admin") {
            url = "/admin/info?userId=" + userId;
        } else if (role === "student") {
            url = "/stu/info?userId=" + userId;
        } else if (role === "tutor") {
            url = "/tutor/info?userId=" + userId
        } else {
            url = "/com/info?userId=" + userId;
        }
        // 弹出基本资料框
        var data = {"title": "基本资料", "url": url, "width": "800px"};
        openHtml(_layer, data);
    });
    $('#update-img').click(function () {
        // 弹出修改头像框
        var data = {"title": "修改头像", "url": "/user/img?userId=" + $("#userId").val(), "width": "800px"};
        openHtml(_layer, data);
    });
    $("#update-passwd").click(function () {
        openPasswordHtml($, _layer);
    });

}

/**
 * 头像显示
 */
function headImg($) {
    $("#img").attr("src", "/api/user/headImg?userId=" + $("#userId").val());
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
    var userId = $("#userId").val();
    switch (id) {
        case "member":
            elem.attr("src", "/admin/member");
            break;
        case "authority":
            elem.attr("src", "/admin/authority");
            break;
        case "com-register":
            elem.attr("src", "/admin/comRegister");
            break;
        case "stock":
            elem.attr("src", "/sto/list?userId=" + userId);
            break;
        case "sto-fin":
            elem.attr("src", "/bf/list?userId=" + userId);
            break;
        case "pro-fin":
            elem.attr("src", "/pf/list?userId=" + userId);
            break;
        case "project-sb":
            openHtml(_layer, {"title": "创新创业项目申报", "url": "/pro/sb?userId=" + userId, "width": "1200px"});
            break;
        case "project-sp":
            elem.attr("src", "/pro/sp?userId=" + userId);
            break;
        case "project-lx":
            elem.attr("src", "/ps/list?userId=" + userId);
            break;
        case "studio":
            elem.attr("src", "/stud/list?userId=" + userId);
            break;
        case "com-studio":
            elem.attr("src", "/com/myStudio?userId=" + userId);
            break;
        case "studio-apply":
            openHtml(_layer, {"title": "工作室申请", "url": "/com/studioApply?userId=" + userId, "width": "800px"});
            break;
        case "goods":
            elem.attr("src", "/goods/list");
            break;
        case "project-sh":
            elem.attr("src", "/pr/list?userId=" + userId);
            break;
        case "buy-funds-apply":
            openHtml(_layer, {"title": "采购资金申请", "url": "/bf/apply?userId=" + userId, "width": "1200px"});
            break;
        case "my-pro":
            elem.attr("src", "/stu/myPro?userId=" + userId);
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
        area: [data.width, "570px"],
        anim: 3,
        scrollbar: false,
        offset: '60px'
    });
}

/**
 * 弹出修改密码HTML页面
 */
function openPasswordHtml($, _layer) {
    _layer.open({
        type: 2,
        title: "修改密码",
        content: "/user/password?userId=" + $("#userId").val(),
        area: ["800px", "570px"],
        anim: 1,
        scrollbar: false,
        offset: '60px'
    });
}

/**
 * 昵称，角色显示
 */
function showNickname($) {
    $.get(
        "/api/user/getNickname",
        {"userId": $("#userId").val()},
        function (res) {
            $("#nickname").text(res.message);
        }
    );
}