layui.use(['form', 'jquery'], function () {
    var form = layui.form;
    var $ = layui.$;

    changeCode($);

    form.on('submit(login)', function (data) {
        $.post(
            '/api/user/login',
            data.field,
            function (result) {
                layer.msg(result.message,{time: 1000}, function () {
                    if (result.code === "success") {
                        window.location.href = "/user/home";
                    } else {
                        changeCode($);
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
        $(".layui-word-aux img").attr('src', '/api/user/code?date=' + new Date());
    });
}
