layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;

    _form.on("submit", function (data) {
        // 校验
        if ($("#password").val() !== data.field.password) {
            msg("", "两次密码不一致", null);
            return false;
        } else {
            update($, data.field);
        }
        return false;
    })
});

/**
 * 修改密码
 * @param $
 * @param data
 */
function update($, data) {
    $.post(
        "/api/user/updatePassword",
        data,
        function (res) {
            msg(res.code, res.message,function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    );
}