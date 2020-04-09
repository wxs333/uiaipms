layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;

    // 初始化
    tableRender(_table, $);
});

/**
 * 初始化表格
 */
function tableRender(_table, $) {
    _table.render({
        elem: '#history',
        height: 455,
        defaultToolbar: [],
        url: "/api/pf/history",
        where: {"proId": $("#proId").val()},
        page: true,
        cols: [[ // 表头
            {field: 'tutorName', title: '申请人', align: "center"},
            {field: 'pfAmount', title: '申请金额', align: "center"},
            {field: 'applyReason', title: '申请理由', align: "center"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: 'deal', title: '是否处理', align: "center", templet: "#deal"},
            {field: 'adminName', title: '处理人', align: "center"},
            {field: 'agree', title: '处理结果', align: "center", templet: "#agree"},
            {field: 'reviewReason', title: '结果说明', align: "center"},
            {field: 'updateTime', title: '处理时间', align: "center"}
        ]],
        limits: [10, 20, 30],
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



