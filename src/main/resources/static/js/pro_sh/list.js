layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table);
    // 行工具栏事件监听
    _table.on('tool(pro-sh)', function (obj) {
            // 弹出填写理由页面
            openReason(_layer, _table, obj);

    });
    // 头工具事件监听
    _table.on("toolbar(pro-sh)", function (obj) {
        if ("personal" === obj.event) {
            // 弹出记录显示页面
            openHistory(_layer);
        }
    });

});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#pro-sh',
        height: 550,
        toolbar: "#tool",
        defaultToolbar: [],
        url: "/api/pa/list",
        page: true,
        cols: [[ // 表头
            {field: 'paId', title: '审批记录id', align: "center", hide: 'true'},
            {field: 'proName', title: '项目名', align: "center"},
            {field: 'proLocation', title: '项目材料', align: "center"},
            {field: 'tutorName', title: '审批人', align: "center"},
            {field: 'reason', title: '通过理由', align: "center"},
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
            url: "/api/pa/list",
            page: {
                curr: 1
            }
        });
}

/**
 * 审核页面
 */
function openReason(_layer, _table, obj) {
    var title = obj.event === "yes" ? "项目通过" : "项目驳回";
    _layer.open({
        type: 2,
        title: title,
        content: '/pr/sh?paId=' + obj.data.paId + "&proName=" + obj.data.proName + "&event=" + obj.event,
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
function openHistory(_layer) {
    _layer.open({
        type: 2,
        title: "个人审核历史记录",
        content: "/pr/history",
        area: ['1200px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}
