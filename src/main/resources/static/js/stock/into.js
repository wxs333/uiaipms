layui.use(['form'], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化select框
    initSelect($, _form);
    // 入库
    _form.on('submit', function (data) {
        add($, _layer, data.field);
        return false;
    })
});

/**
 * 初始化select框
 */
function initSelect($, _form) {
    $.get(
        '/api/into/unit',
        {},
        function (res) {
            var html = '<option value="">请选择</option>';
            $.each(res.data, function (index, item) {
                html += '<option value=' + item.unitId + '>' + item.unitName + '</option>';
            });
            $('#unit').html(html);
            _form.render('select');
        }
    );
}

/**
 * 入库
 */
function add($, _layer, data) {
    $.post(
        '/api/goods/add',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon, offset: '200px'}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        }
    )
}