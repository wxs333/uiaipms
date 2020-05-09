layui.use("form", function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 表单提交监听
    _form.on("submit", function (data) {
        // 数据处理
        if (typeof(data.field.success) === "undefined") {
            data.field.success = "1"
        }
        // 数据提交
        add($, _layer, data.field);
        return false;
    });
});

/**
 * 结题
 */
function add($, _layer, data) {
    $.post(
        "/api/res/add?tutorId="+ $("#userId").val(),
        data,
        function (res) {
            msg(res.code, res.message, function () {
                close();
            })
        }
    )
}

/**
 * 关闭弹出层
 */
function close() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}