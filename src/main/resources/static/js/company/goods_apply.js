layui.use(['form'], function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 初始化select框
    initSelect($, _layer, _form);
    // 表单提交监听
    _form.on('submit', function (data) {
        // 向后台传输数据
        goodsApply($, _layer, data.field);
        return false;
    })
});

/**
 *初始化select框
 */
function initSelect($, _layer, _form) {
    // 获取数据
    $.get(
        '/api/goods/getAllGoods',
        {},
        function (res) {
            if ('success' === res.code) {
                // 初始化
                var html = '<option value="">请选择</option>';
                $.each(res.data, function (index, item) {
                    html += '<option value=' + item.goodsId + '>' + item.goodsName + '(剩余：' + item.goodsNum + ')</option>';
                });
                $('#goods').html(html);
                _form.render('select');
            } else {
                _layer.msg('发生系统错误，请联系管理员', {icon: 2, time: 1000, offset: '200px'});
            }
        }
    );
}

/**
 * 物品申请提交
 */
function goodsApply($, _layer, data) {
    $.post(
        '/api/out/add',
        data,
        function (res) {
            var icon = 'success' === res.code ? 1 : 2;
            _layer.msg(res.message, {icon: icon, time: 1000, offset: '200px'}, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    )
}