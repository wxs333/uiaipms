layui.use(['form', 'jquery'], function () {
    // 模块定义
    var form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 更换验证码
    changeCode($);
    // 打开注册页面
    $("[name='register']").click(function() {
        openRegisterHtml(_layer)
    });

    form.on('submit(login)', function (data) {
        $.post(
            '/api/user/login',
            data.field,
            function (result) {
                console.log(result.message);
                _layer.msg(result.message,{time: 1000}, function () {
                    if (result.code === "success") {
                        window.location.href = "/user/home";
                    } else {
                        doChange($);
                    }
                });
            }
        );
        return false;
    });
});

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
    $(".layui-word-aux img").attr('src', '/api/user/code?date=' + new Date());
}

/**
 * 打开注册页面
 */
function openRegisterHtml(_layer) {
    _layer.open({
        type: 2,
        title: "学生注册",
        content: '/user/register',
        area: ['800px','550px'],
        anim: 1,
        scrollbar: false
    });
}
