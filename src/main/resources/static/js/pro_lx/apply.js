layui.use("form", function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 表单提交事件监听
    _form.on("submit", function (data) {
        // 提交数据
        addProjectFinance($, _layer, data.field);
        // 阻止表单跳转
        return false;
    })
});

/**
 * 新增项目拨款记录
 */
function addProjectFinance($, _layer, data) {
    $.post(
        "/api/pf/add?userId=" + $("#userId").val(),
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 2000, icon: icon, offset: "200px"}, function () {
                //先得到当前iframe层的索引
                var index = parent.layer.getFrameIndex(window.name);
                //再执行关闭
                parent.layer.close(index);
            });
        }
    )
}