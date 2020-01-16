layui.use('transfer', function () {
    var _transfer = layui.transfer;
    var $ = layui.$;
    // 数据加载
    renderTransfer(_transfer, $);
});

/**
 * 渲染穿梭框
 */
function renderTransfer(_transfer, $) {
    // 获取数据
    getRoles($, function (data) {
        // 渲染
        doRender(_transfer, data);
    }, $("#mark").val(), $("#username").val());
}

/**
 * 执行渲染
 */
function doRender(_transfer, data) {
    _transfer.render({
        elem: '#role'  // 绑定元素
        , title: ["角色", "已有"]
        , data: data.notHave
        , value: data.have // 右侧数据
        , id: 'role' // 定义索引
        , width: 350
        , height: 450
        , onchange: function (data, index) {
            getData(_transfer, data, index)
        },
        parseData: function (res) {
            return {
                'value': res.roleId,
                'title': res.roleName,
                'disabled': res.disable
            }
        }
    });
}

/**
 * 穿梭回调
 */
function getData(_transfer, data, index) {
    // 授权
    if (index === 0) {
        var $ = layui.$;

        $.post(
            '/api/admin/authority',
            {'mark': $('#mark').val(), 'username': $('#username').val(), 'data': data},
            function (res) {
                layer.msg(res.message);
            }
        )
    } else { // 回收权限
        if (_transfer.getData('role') == null) {
            layui.layer.msg("用户必须有一个角色", {time: 1000})
        }
    }

}

/**
 * 获取所有角色
 */
function getRoles($, fn, mark, username) {
    $.get(
        '/api/admin/getRoles',
        {'mark': mark, 'username': username},
        function (res) {
            fn(res.data);
        }
    );

}