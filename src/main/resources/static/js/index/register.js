/**
 * 初始模块加载
 */
layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化select框
    initSelect($, _form);
    // 注册
    register(_form, $, _layer);
});

/**
 * 初始化select框
 */
function initSelect($, _form) {
    $.get(
        "/api/stu/clazz",
        {},
        function (res) {
            var html = "<option value=''>请选择</option>";
            $.each(res.data, function (i, elem) {
                html += "<option value=" + elem.clazzId + ">" + elem.clazzName + "</option>"
            });
            $("#clazz").html(html);
            _form.render("select");
        }
    );

}

/**
 * 注册
 */
function register(_form, $, _layer) {
    _form.on('submit', function (data) {
        // 密码加密
        data.field.password = md5(data.field.password);
        $.post(
            '/api/stu/register',
            data.field,
            function (res) {
                var icon = res.code === "success" ? 1 : 2;
                _layer.msg(res.message, {time: 1500, icon: icon}, function () {
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