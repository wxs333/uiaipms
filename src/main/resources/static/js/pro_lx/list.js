layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table, $);
    // 头工具栏事件监听
    _table.on('toolbar(pro-lx)', function (obj) {
        if (obj.event === "export") {
            // 数据导出
            window.location.href = "/api/ps/export?userId=" + $("#userId").val();
        }
    });
    // 行工具栏事件监听
    _table.on('tool(pro-lx)', function (obj) {
        var event = obj.event;
        if ("lx" === event) {
            // 弹出确认框
            openConfirm($, _layer, _table, {"psId": obj.data.psId, "lxFlag": 0});
        } else if ("apply" === event) {
            // 打开申请页面
            openApplyHtml(_layer, _table, $, obj.data.proId);
        } else if ("preview" === event) {
            // 文档预览
            wordPreview($, obj.data.proLocation, obj.data.wordName);
        } else if ("record" === event) {
            openRecordHtml(_layer, obj.data.proId);
        } else if ("end" === event) {
            // 弹出结题页面
            openEndHtml($, _layer, _table, obj.data.psId, obj.data.proId, obj.data.proName);
        }
    })

});

/**
 * 初始化表格
 */
function tableRender(_table, $) {
    _table.render({
        elem: '#pro-lx',
        height: 570,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: "/api/ps/list?userId=" + $("#userId").val(),
        page: true,
        cols: [[ // 表头
            {field: 'psId', title: '', align: "center", hide: 'true'},
            {field: 'proId', title: '', align: "center", hide: 'true'},
            {field: 'proLocation', title: '', align: "center", hide: 'true'},
            {field: 'stuName', title: '申请人', align: "center"},
            {field: 'proName', title: '项目名称', align: "center"},
            {field: 'wordName', title: '项目文档', align: "center", event: "preview", templet: "#word"},
            {field: 'paTutor', title: '审批导师', align: "center"},
            {field: 'paTime', title: '审批时间', align: "center"},
            {field: 'prTutor', title: '审核导师', align: "center"},
            {field: 'prTime', title: '审核时间', align: "center"},
            {field: 'lxFlag', title: '是否立项', align: "center", templet: "#lx"},
            {field: 'end', title: '是否结题', align: "center", templet: "#end"},
            {field: 'psTutor', title: '立项导师', align: "center"},
            {field: 'updateTime', title: '立项时间', align: "center"},
            {field: '', title: "操作", minWidth: '250', align: "center", toolbar: "#rowTool"}
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
 * @param _table
 */
function reloadTable(_table) {
    _table.reload('pro-lx',
        {
            page: {
                curr: 1
            }
        });
}

/**
 * 立项确认
 */
function openConfirm($, _layer, _table, data) {
    _layer.confirm("确定要将该项目立项？",
        {icon: 3, title: '确定提示', anim: 1},
        function (index) {
            _layer.close(index);
            lx($, _layer, _table, data);
        });
}

/**
 * 立项
 */
function lx($, _layer, _table, data) {
    $.post(
        "/api/ps/lx?userId=" + $("#userId").val(),
        data,
        function (res) {
            msg(res.code, res.message, function () {
                reloadTable(_table);
            })
        }
    )
}

/**
 * 弹出资金申请页面
 */
function openApplyHtml(_layer, _table, $, proId) {
    _layer.open({
        type: 2,
        title: "项目资金申请",
        content: '/ps/apply?proId=' + proId + "&userId=" + $("#userId").val(),
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}

/**
 * 资金申请历史记录
 * @param _layer
 * @param proId
 */
function openRecordHtml(_layer, proId) {
    _layer.open({
        type: 2,
        title: "资金申请历史记录",
        content: "/ps/finHistory?proId=" + proId,
        area: ["1200px", '560px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}

/**
 * 结题页面
 */
function openEndHtml($, _layer, _table, psId, proId, proName) {
    _layer.open({
        type: 2,
        title: "项目结题",
        content: "/ps/end?proId=" + proId + "&psId=" + psId + "&userId=" + $("#userId").val() + "&proName=" + proName,
        area: ["800px", '560px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function () {
            reloadTable(_table);
        }
    });
}
