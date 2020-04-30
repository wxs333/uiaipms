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
    }, $("#mark").val(), $("#userId").val());
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
    var $ = layui.$;
    // 授权
    if (index === 0) {
        $.post(
            '/api/admin/authority',
            {'mark': $('#mark').val(), 'userId': $('#userId').val(), 'data': JSON.stringify(data)},
            function (res) {
                var icon = res.code === 'success' ? 1 : 2;
                layer.msg(res.message, {icon: icon});
            }
        )
    } else { // 回收角色
        if (_transfer.getData('role').length === 0) {
            layer.open({
                title: "提示信息",
                content: "用户必须有一个角色",
                icon: 2,
                anim: 1,
                yes: function (index, layero) {
                    getRoles($, function (data) {
                        // 渲染
                        doRender(_transfer, data);
                    }, $("#mark").val(), $("#userId").val());
                    layer.close(index);
                },
                cancel: function (index, layero) {
                    getRoles($, function (data) {
                        // 渲染
                        doRender(_transfer, data);
                    }, $("#mark").val(), $("#userId").val());
                    layer.close(index);
                }
            })
        } else {
            $.post(
                '/api/admin/revoke',
                {'userId': $('#userId').val(), 'data': JSON.stringify(data)},
                function (res) {
                    var icon = res.code === 'success' ? 1 : 2;
                    layer.msg(res.message, {icon: icon, time: 1500});
                }
            )
        }
    }

}

/**
 * 获取所有角色
 */
function getRoles($, fn, mark, userId) {
    $.get(
        '/api/admin/getRoles',
        {'mark': mark, 'userId': userId},
        function (res) {
            fn(res.data);
        }
    );

}