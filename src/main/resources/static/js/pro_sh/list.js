layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table ,$);
    // 行工具栏事件监听
    _table.on('tool(pro-sh)', function (obj) {
        if (obj.event === "sh") {
            // 弹出填写理由页面
            openReason(_layer, _table, $, obj);
        } else if (obj.event === "preview") {
            wordPreview($, obj.data.proLocation, obj.data.wordName.split(".")[0] + ".pdf");
        }
    });
    // 头工具事件监听
    _table.on("toolbar(pro-sh)", function (obj) {
        if ("personal" === obj.event) {
            // 弹出记录显示页面
            openHistory($, _layer);
        }
    });

});

/**
 * 初始化表格
 */
function tableRender(_table, $) {
    _table.render({
        elem: '#pro-sh',
        height: 550,
        toolbar: "#tool",
        defaultToolbar: [],
        url: "/api/pr/listNotDeal?id=" + $("#userId").val(),
        page: true,
        cols: [[ // 表头
            {field: 'prId', title: '审核记录id', align: "center", hide: 'true'},
            {field: 'proLocation', title: '文档路径', align: "center", hide: 'true'},
            {field: 'stuName', title: '申请人', align: "center"},
            {field: 'proName', title: '项目名', align: "center"},
            {field: 'wordName,', title: '项目文档', align: "center", event: "preview", templet: "#word"},
            {field: 'tutorName', title: '审批人', align: "center"},
            {field: 'reason', title: '审批理由', align: "center"},
            {field: 'updateTime', title: '审批时间', align: "center"},
            {field: '', title: "操作", minWidth: '150', align: "center", toolbar: "#rowTool"}
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

/**
 * 表格重载
 */
function reloadTable(_table) {
    _table.reload('pro-sh',
        {
            page: {
                curr: 1
            }
        });
}

/**
 * 审核页面
 */
function openReason(_layer, _table, $, obj) {
    _layer.open({
        type: 2,
        title: "项目审核",
        content: '/pr/sh?prId=' + obj.data.prId + "&proName=" + obj.data.proName + "&userId=" + $("#userId").val(),
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function f() {
            // 重载表格
            reloadTable(_table);
        }
    });
}

/**
 * 历史记录页面
 */
function openHistory($, _layer) {
    _layer.open({
        type: 2,
        title: "个人审核记录",
        content: "/pr/history?userId=" + $("#userId").val(),
        area: ['1200px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}