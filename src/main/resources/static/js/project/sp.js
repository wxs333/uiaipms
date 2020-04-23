layui.use(['form'], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;

    // 项目审批
    _form.on('submit', function (data) {
        approve($, _layer, data.field);
        return false;
    });

});

/**
 * 项目审批
 */
function approve($, _layer, data) {
    $.post(
        '/api/pa/update?userId=' + $("#userId").val(),
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1000, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        }
    )
}