layui.use(['form', 'jquery'], function () {
    // 模块定义
    var form = layui.form;
    var $ = layui.$;
    // 更换验证码
    changeCode($);

    form.on('submit(login)', function (data) {
        $.post(
            '/api/user/login',
            data.field,
            function (result) {
                console.log(result.message);
                layer.msg(result.message,{time: 1000}, function () {
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
