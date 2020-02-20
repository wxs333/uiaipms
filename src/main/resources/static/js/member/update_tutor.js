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
        '/api/tutor/getOne',
        {'id': id},
        function (res) {
            // 初始化select框
            initSelect($, _form, res.data.facultyId);
            _form.val('update-form', res.data);
        }
    );
}

/**
 * 初始化select框
 */
function initSelect($, _form, facultyId) {
    $.get(
        '/api/admin/getFaculty',
        {},
        function (res) {
            $.each(res.data, function (index, item) {
                if (facultyId === item.facId) {
                    $('#faculty').append(new Option(item.facName, item.facId, true, true));
                } else {
                    $('#faculty').append(new Option(item.facName, item.facId));
                }
            });
            _form.render('select');
        }
    );
}

/**
 * 修改信息
 */
function update($, _layer, data) {
    console.log(data);
    $.post(
        '/api/tutor/update',
        data,
        function (res) {
            var icon = res.code === 'success'? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            })
        }
    );
}

