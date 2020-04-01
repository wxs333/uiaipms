layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 监听第一步表单
    _form.on("submit(one)", function (data) {
        // 发送邮件
        sendEmail($, _layer, data.field.email);
        return false;
    });
    // 监听第二步表单
    _form.on("submit(two)", function (data) {
        // 验证码校验
        if (data.field.code !== $("#email-code").val()) {
            _layer.msg("验证码不正确", {time: 1500, icon: 2, anim: 6})
        } else {
            disableAndShow($, "", "#three");
        }
        return false;
    });
    // 监听第三步表单
    _form.on("submit(three)", function (data) {
        disableAndShow($, "", "#four");
        return false;
    });
    // 监听第四步表单
    _form.on("submit(four)", function (data) {
        // 校验
        if (data.field.password !== $("#new-password").val()) {
            _layer.msg("两次密码不一样", {time: 1500, icon: 2, anim: 6})
        } else {
            // 修改密码
            updatePassword($, _layer, data.field.password);
        }
        return false;
    });
});

/**
 * 发送邮件
 */
function sendEmail($,_layer, email) {
    var index = _layer.load(2);
    $.get(
        '/api/user/sendEmail',
        {"email": email},
        function (res) {
            _layer.close(index);
            if (res.code === "success") {
                msg(res.code, res.message, function () {
                    $("#email-code").val(res.data);
                    disableAndShow($, "#one", "#two");
                });
            }  else {
                msg(res.code, res.message, null);
            }

        }
    )
}

/**
 * 修改密码
 */
function updatePassword($, _layer, password) {
    $.post(
        "/api/user/updatePassword",
        {"password": password, "username": $("#username").val()},
        function (res) {
            msg(res.code, res.message, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    )
}
/**
 * 禁止此步输入框输入，和显示下一步
 */
function disableAndShow($, nowId, nextId) {
    if ("" !== nowId) {
        $(nowId + " .layui-inline .layui-input-inline input").attr("readonly", "true");
    }
    $(nextId).removeAttr("hidden");
}