layui.use(['form'], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 给表单赋值
    initForm(_form, $);
    // 修改信息
    _form.on('submit', function (data) {
        add($, _layer, data.field);
        return false;
    });

});

/**
 * 给表单赋值
 */
function initForm(_form, $) {
    var studId = $('#studId').val();
    $.get(
        '/api/stud/getOne',
        {'studId': studId},
        function (res) {
            // 给select框赋值
            console.log(res.data.comId);
            initSelect(_form, $, res.data.comId);
            _form.val('update-form', res.data);
        }
    );
}

/**
 * 给select框赋值
 */
function initSelect(_form, $, id) {
    $.get(
        '/api/stud/getCompany',
        {},
        function (res) {
            var html = '<option value="">请选择</option>';
            $.each(res.data, function (index, item) {
                if (item.comId === id) {
                    html += '<option value=' + item.comId + ' selected>' + item.comName + '</option>';
                } else {
                    html += '<option value=' + item.comId + '>' + item.comName + '</option>';
                }

            });
            $('#company').html(html);
            _form.render('select');
        }
    );
}

/**
 * 修改
 */
function add($, _layer, data) {
    $.post(
        '/api/stud/update',
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