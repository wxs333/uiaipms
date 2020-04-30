layui.use("form", function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 表单提交事件监听
    _form.on("submit", function (data) {
        // 提交数据
        updateProjectFinance($, _layer, data.field);
        // 阻止表单跳转
        return false;
    })
});

/**
 * 审批数据提交
 */
function updateProjectFinance($, _layer, data) {
    $.post(
        "/api/bf/update?userId=" + $("#userId").val(),
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon}, function () {
                //先得到当前iframe层的索引
                var index = parent.layer.getFrameIndex(window.name);
                //再执行关闭
                parent.layer.close(index);
            });
        }
    )
}