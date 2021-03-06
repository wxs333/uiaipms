layui.use("table", function () {
    var _table = layui.table;
    var _layer = layui.layer;
    var $ = layui.$;
    // 初始化
    tableRender(_table, "not");
    // 表头工具监听
    _table.on("toolbar(sto-fin)", function (obj) {
        var event = obj.event;
        if (event === "export") {
            window.location.href = "/api/bf/export";
        } else if ("statistics" === event) {
            statistics(_layer);
        } else {
            // 修改标题
            changeTitle($, event);
            // 加载数据
            tableRender(_table, event);
        }

    });
    // 行工具监听
    _table.on("tool(sto-fin)", function (obj) {
        // 打开审批页面
        openConfirmHtml(_layer, _table, $, obj);
    });
});

/**
 * 初始化表格
 */
function tableRender(_table, event) {
    // 获取cols与url
    var data = getColsAndUrl(event);
    _table.render({
        elem: '#sto-fin',
        height: 500,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: data[1], //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [data[0]],
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
 * 获取不同的表头和url
 */
function getColsAndUrl(event) {
    var data = [];
    if (event === 'not') {
        data[0] = [ // 表头
            {field: 'bfaId', title: 'id', align: "center", hide: true},
            {field: 'applyUserName', title: '申请人', align: "center"},
            {field: 'applyMount', title: '申请金额', align: "center"},
            {field: 'applyReason', title: '申请理由', align: "center"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: '', title: '操作', align: "center", toolbar: "#rowTool"}
        ];
        data[1] = '/api/bf/listNoDeal';
    } else if (event === "yes") {
        data[0] = [ // 表头
            {field: 'applyUserName', title: '申请人', align: "center"},
            {field: 'applyMount', title: '申请金额', align: "center"},
            {field: 'applyReason', title: '申请理由', align: "center"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: 'dealUserName', title: '处理人', align: "center"},
            {field: 'bfaAgree', title: '处理结果', align: "center", templet: "#agree"},
            {field: 'bfaReason', title: '结果说明', align: "center"},
            {field: 'updateTime', title: '处理时间', align: "center"}
        ];
        data[1] = '/api/bf/listDeal';
    }
    return data;
}

/**
 * 修改标题
 */
function changeTitle($, event) {
    if (event === 'not') {
        $('#title').text('待审批记录');
    } else if (event === 'yes') {
        $('#title').text('已审批记录');
    }

}

/**
 * 确认页面
 */
function openConfirmHtml(_layer, _table, $, obj) {
    _layer.open({
        type: 2,
        title: "采购资金申请审批",
        content: "/bf/sp?bfaId=" + obj.data.bfaId + "&applyMount=" + obj.data.applyMount + "&userId=" + $("#userId").val(),
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function () {
            _table.reload('sto-fin',
                {
                    url: getColsAndUrl(event)[1],
                    page: {
                        curr: 1
                    }
                });
        }
    });
}

/**
 * 统计页面
 */
function statistics(_layer) {
    _layer.open({
        type: 2,
        title: "库存拨款记录统计",
        content: "/bf/statistics",
        area: ['1000px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}