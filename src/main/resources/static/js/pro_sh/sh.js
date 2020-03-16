layui.use("form", function () {
    var _form = layui.form;
    var _layer = layui.layer;
    var $ = layui.$;
    // 表单提交监听
    _form.on("submit", function (data) {
        // 数据提交
        if ($("#event").val() === "yes") {
            add($, _layer, data.field);
        } else {
            updateStatus($, _layer,data.field)
        }

        return false;
    });
});

/**
 * 新增审核记录
 *
 */
function add($, _layer, data) {
    $.post(
        "/api/pr/add",
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(
                res.message,
                {time: 2000, icon: icon, offset: '200px'},
                function () {
                    close(_layer);
                });
        }
    );
}


/**
 * 审批记录修改状态
 */
function updateStatus($, _layer, data) {
    $.post(
        "/api/pa/update",
        {"paId": data.paId, "review": 1, "reason": data.reason},
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(
                res.message,
                {time: 2000, icon: icon, offset: '200px'},
                function () {
                    close();
                });
        }
    );
}

/**
 * 关闭弹出层
 */
function close() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}