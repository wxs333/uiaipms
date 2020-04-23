layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;

    _form.on("submit", function (data) {
        // 校验
        if ($("#password").val() !== data.field.password) {
            msg("", "两次密码不一致", null);
            return false;
        } else {
            update($, _layer, data.field);

        }
        return false;
    })
});

/**
 * 修改密码
 */
function update($, _layer, data) {
    $.post(
        "/api/user/updatePassword?userId=" + $("#userId").val(),
        data,
        function (res) {
            var icon = res.code === "success" ? 1 : 2;
            _layer.msg(res.message, {icon: icon, time: 1500}, function () {
                if (res.code === "success") {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    window.parent.location.href = "/user/index";
                }
            });
        }
    );
}