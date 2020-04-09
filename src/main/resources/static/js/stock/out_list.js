layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;

    // 数据初始化
    tableRender(_table);
    // 行事件监听
    _table.on('tool(out-apply)', function (obj) {
        // 弹出确认框
        openConfirm(_layer, $, _table, obj.event, obj.data);
    })
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#out-apply',
        height: 450,
        defaultToolbar: [],
        url: '/api/out/apply', //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [[
            {field: 'stoId', title: 'ID', align: "center", hide: 'true'},
            {field: 'goodsId', title: '物品ID', align: "center", hide: 'true'},
            {field: 'address', title: '申请人', align: "center"},
            {field: 'goodsName', title: '物品', align: "center"},
            {field: 'goodsBrand', title: '品牌', align: "center"},
            {field: 'goodsModel', title: '型号', align: "center"},
            {field: 'applyNum', title: '数量', align: "center"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: '', title: '操作', align: "center", templet: '#option'}
        ]],
        parseData: function (res) { // 返回数据格式解析
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.records //解析数据列表
            };
        },
        request: {
            pageName: 'current' //页码的参数名称，
            , limitName: 'size' //每页数据量的参数名，
        }
    });
}

/**
 * 表格重载
 */
function reloadTable(_table) {
    _table.reload('out-apply', {
        url: '/api/out/apply',
        page: {
            curr: 1
        }
    });
}

/**
 * 提示框
 */
function openConfirm(_layer, $, _table, event, data) {
    var msg = event === "agree" ? "您确定同意吗？" : "您确定驳回吗？";
    _layer.confirm(msg, {icon: 3, title: '确认信息', offset: '80px'}, function (index) {
        var agree = event === 'agree' ? 0 : 1;
        // 数据提交
        doApply($, _layer, _table, {
            'stoId': data.stoId,
            'agree': agree,
            "applyNum": data.applyNum,
            "goodsId": data.goodsId
        });
        // 关闭提示框
        _layer.close(index);
    });
}

/**
 * 修改agree
 */
function doApply($, _layer, _table, data) {
    $.post(
        '/api/out/agree',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon, offset: '200px'},
                function () {
                    // 重载表格
                    reloadTable(_table);
                });
        }
    )
}