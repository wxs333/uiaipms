layui.use(['form'], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表单
    init(_form, $);
    // 修改信息
    _form.on('submit', function (data) {
        update($, _layer, data.field);
        return false;
    });

});

/**
 * 初始化表单
 */
function init(_form, $) {
    var id = $("#id").val();
    $.get(
        '/api/com/getOne',
        {'id': id},
        function (res) {
            _form.val('update-form', res.data);
        }
    );
}

/**
 * 修改
 */
function update($, _layer, data) {
    $.post(
        '/api/com/update',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        }
    );
}