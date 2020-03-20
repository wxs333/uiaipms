layui.use("form", function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 表单提交监听
    _form.on("submit", function (data) {
        add(_layer, $, data.field);
        return false;
    });
});

/**
 * 新增
 */
function add(_layer, $, data) {
    $.post(
        "/api/bf/add",
        data,
        function (res) {
            var icon = res.code === "success" ? 1 : 2;
            _layer.msg(
                res.message,
                {icon: icon, time: 2000},
                function () {
                    // 关闭
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            )
        }
    )
}