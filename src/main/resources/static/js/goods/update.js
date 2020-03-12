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
        '/api/goods/getOne',
        {'id': id},
        function (res) {
            // 给表单赋值
            _form.val('update-form', res.data);
            // 初始化select框
            initSelect($, _form, res.data.unitId);

        }
    );
}

/**
 * 初始化select框
 */
function initSelect($, _form, unitId) {
    // 获取数据
    $.get(
        "/api/into/unit",
        {},
        function (res) {
            var html = "<option value=''>请选择</option>";
            $.each(res.data, function (i, item) {
                if (item.unitId === unitId) {
                    html += "<option value=" + item.unitId + " selected>" + item.unitName + "</option>"
                } else {
                    html += "<option value=" + item.unitId + ">" + item.unitName + "</option>"
                }
                $("#unit").html(html);
                _form.render("select");
            })
        }
    );
}

/**
 * 修改信息
 */
function update($, _layer, data) {
    $.post(
        '/api/goods/update',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1000, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        }
    );
}
