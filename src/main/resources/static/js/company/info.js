layui.use(['form', 'layer'], function () {
    var $ = layui.jquery;
    var _form = layui.form;
    var _layer = layui.layer;
    // 初始化表单
    initForm($, _form);
    // 表单提交按钮监听
    _form.on('submit', function (data) {
        // 数据提交
        update($, _layer, data.field);
        return false;
    });
});

/**
 * 表单数据提交
 */
function update($, _layer, data) {
    $.post(
        '/api/com/update',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            layer.msg(res.message, {icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    );
}

/**
 * 初始化表单
 */
function initForm($, _form) {
    $.get(
        '/api/com/info',
        {},
        function (res) {
            _form.val('info', res.data);
        }
    );
}