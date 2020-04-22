/**
 * 初始模块加载
 */
layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 注册
    register(_form, $, _layer);
});

/**
 * 注册
 */
function register(_form, $, _layer) {
    _form.on('submit', function (data) {
        $.post(
            '/api/stu/register',
            data.field,
            function (res) {
                _layer.msg(res.message, {time: 1000}, function () {
                    if (res.code === "success") {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    }
                });
            }
        );
        // 阻值表单跳转
        return false;
    });
}