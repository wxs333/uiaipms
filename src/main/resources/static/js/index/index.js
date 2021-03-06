layui.use(['form', 'jquery'], function () {
    // 模块定义
    var form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 更换验证码
    changeCode($);
    // 打开注册页面
    $("#register").click(function () {
        openHtml(_layer, {"title": "学生注册", "content": "/user/stuRegister"})
    });
    $("#company").click(function () {
        openHtml(_layer, {"title": "企业入驻", "content": "/user/comRegister"})
    });

    form.on('submit(login)', function (data) {
        // 密码加密
        data.field.password = md5(data.field.password);
        login($, _layer, data.field);
        return false;
    });
    // 忘记密码
    $("#forget-password").click(function () {
        openHtml(_layer, {"title": "找回密码", "content": "/user/findPassword"})
    });
});

/**
 * 登录
 */
function login($, _layer, data) {
    $.post(
        '/api/user/login',
        data,
        function (result) {
            var icon = result.code === 'success' ? 1 : 2;
            _layer.msg(result.message, {time: 1500, icon: icon}, function () {
                if (result.code === "success") {
                    var data = result.data.split("-");
                    window.location.href = "/user/home?userId=" + data[0] + "&role=" + data[1];
                } else {
                    doChange($);
                }
            });
        }
    );
}

/**
 * 更换验证码
 * @param $ layUI内置的jQuery模块
 */
function changeCode($) {
    $("#changeCode").click(function () {
        doChange($);
    });
}

/**
 * 执行更换验证码
 */
function doChange($) {
    $("#img").attr('src', '/api/user/code?date=' + new Date());
}

/**
 * 打开页面
 */
function openHtml(_layer, data) {
    _layer.open({
        type: 2,
        title: data.title,
        content: data.content,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false
    });
}
