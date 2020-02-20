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
    // 监听系别select框
    _form.on('select(disc)', function (data) {
        getClazz($, _form, data.value, '');
    })

});

/**
 * 初始化表单
 */
function init(_form, $) {
    var id = $("#id").val();
    $.get(
        '/api/stu/getOne',
        {'id': id},
        function (res) {
            // 初始化select框
            initSelect($, _form, res.data.discId, res.clazzId);
            _form.val('update-form', res.data);
        }
    );
}

/**
 * 初始化select框
 */
function initSelect($, _form, discId, clazzId) {
    // 获取系
    getDiscipline($, _form, discId);
    // 获取班级
    getClazz($, _form, discId, clazzId);
}

/**
 * 修改信息
 */
function update($, _layer, data) {
    $.post(
        '/api/stu/update',
        data,
        function (res) {
            var icon = res.code === 'success'? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        }
    );
}

/**
 * 获取系
 */
function getDiscipline($, _form, discId) {
    $.get(
        '/api/admin/getDiscipline',
        {},
        function (res) {
            var html = '';
            $.each(res.data, function (index, item) {
                if (discId === item.discId) {
                    html += '<option value='+ item.discId +' selected>'+ item.discName +'</option>';
                } else {
                    html += '<option value='+ item.discId +'>'+ item.discName +'</option>';
                }
            });
            $('#disc').html(html);
        }
    );
}

/**
 * 获取班级
 */
function getClazz($, _form, discId, clazzId) {
    $.get(
        '/api/admin/getClazz',
        {'discId': discId},
        function (res) {
            $('#clazzId').html('');
            $.each(res.data, function (index, item) {
                if (clazzId === item.clazzId) {
                    $('#clazzId').append(new Option(item.clazzName, item.clazzId, true, true));
                } else {
                    $('#clazzId').append(new Option(item.clazzName, item.clazzId));
                }
            });
            _form.render('select');
        }
    );
}

