layui.use("table", function () {
    var _table = layui.table;
    // 初始化表格
    init(_table);
});

/**
 * 表格初始化
 */
function init(_table) {
    _table.render({
        elem: '#personal',
        height: 420,
        defaultToolbar: [],
        url: "/api/pr/personal",
        page: true,
        cols: [[ // 表头
            {field: 'proName', title: '项目名', align: "center"},
            {field: 'proDesc', title: '项目描述', align: "center"},
            {field: 'tutorName', title: '审批导师', align: "center"},
            {field: 'paReason', title: '审批理由', align: "center"},
            {field: 'review', title: '审核结果', align: "center", templet: "#review"},
            {field: 'reason', title: '审核理由', align: "center"},
            {field: 'createTime', title: '审核时间', align: "center", templet: "#createTime"}
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