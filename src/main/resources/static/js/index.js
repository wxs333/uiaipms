layui.use(['form', 'jquery'], function () {
    var form = layui.form;
    var $ = layui.$;

    changeCode($);

    form.on('submit(login)', function (data) {
        $.post(
            '/user/login',
            data.field,
            function (result) {
                layer.msg(result);
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
        $(".layui-word-aux img").attr('src', '/user/code?date=' + new Date());
    });
}