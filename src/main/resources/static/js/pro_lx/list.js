layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table);
    // 头工具栏事件监听
    _table.on('toolbar(pro-lx)', function (obj) {
        if (obj.event === "export") {
            // 数据导出
            window.location.href = "/api/pr/export";
        }
    });
    // 行工具栏事件监听
    _table.on('tool(pro-lx)', function (obj) {
        var event = obj.event;
        if ("lx" === event) {
            // 弹出确认框
            openConfirm($, _layer, _table, {"prId": obj.data.prId, "lx": 0});
        } else if ("apply" === event) {
            // 打开申请页面
            openApplyHtml(_layer, obj.data.proId);
        }
    })

});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#pro-lx',
        height: 570,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: "/api/pr/starting",
        page: true,
        cols: [[ // 表头
            {field: 'prId', title: '审核记录id', align: "center", hide: 'true'},
            {field: 'proId', title: '项目id', align: "center", hide: 'true'},
            {field: 'proName', title: '项目名称', align: "center"},
            {field: 'tutorName', title: '审核导师', align: "center"},
            {field: 'reason', title: '审核理由', align: "center"},
            {field: 'createTime', title: '审核时间', align: "center", templet: "#createTime"},
            {field: 'lx', title: '立项', align: "center", templet: "#lx"},
            {field: 'lxTime', title: '立项时间', align: "center", templet: "#lx_time"},
            {field: '', title: "操作", minWidth: '200', align: "center", toolbar: "#rowTool"}
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
 * 打开修改页面
 */
function openUpdateHtml(_layer, _table, id) {
    _layer.open({
        type: 2,
        title: "修改",
        content: "/goods/update?id=" + id,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function f() {
            reloadTable(_table);
        }

    });
}

/**
 * 表格重载
 * @param _table
 */
function reloadTable(_table) {
    _table.reload('pro-lx',
        {
            url: "/api/pr/starting",
            page: {
                curr: 1
            }
        });
}

/**
 * 弹出资金申请页面
 */
function openConfirm(_layer, data) {

}

/**
 * 修改状态
 */
function updateStatus($, _layer, _table, data) {
    $.post(
        "/api/pr/lx",
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(
                res.message,
                {time: 2000, icon: icon, offset: '200px'},
                function () {
                    reloadTable(_table);
                });
        }
    );
}

/**
 * 弹出资金输入框
 */
function openApplyHtml(_layer, proId) {
    _layer.open({
        type: 2,
        content: "/ps/apply?proId=" + proId,
        area: ["800px", "550px"],
        anim: 1,
        scrollbar: false,
        offset: "30px"
    });
}

