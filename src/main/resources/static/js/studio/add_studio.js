layui.use(['form'], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 给select框赋值
    initSelect(_form, $);
    // 修改信息
    _form.on('submit', function (data) {
        add($, _layer, data.field);
        return false;
    });

});

/**
 * 给select框赋值
 */
function initSelect(_form, $) {
    $.get(
        '/api/stud/getCompany',
        {},
        function (res) {
            var html = '<option value="">请选择</option>';
            $.each(res.data, function (index, item) {
                html += '<option value=' + item.comId + '>' + item.comName + '</option>';
            });
            $('#company').html(html);
            _form.render('select');
        }
    );
}

/**
 * 新增
 */
function add($, _layer, data) {
    $.post(
        '/api/stud/add',
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