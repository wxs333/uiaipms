layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表格
    tableRender(_table);
    // 行工具栏监听
    _table.on('tool(list)', function (obj) {
        if (obj.event === 'sp') {
            // 打开修改页面
            openHtml(_table, _layer, $, obj.data.saId, obj.data.comId, obj.data.studId);
        }
    })
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#list',
        height: 440,
        defaultToolbar: [],
        url: '/api/sa/list', //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [[ // 表头
            {field: 'saId', title: 'id', align: "center", hide: 'true'},
            {field: 'comId', title: 'comId', align: "center", hide: 'true'},
            {field: 'studId', title: 'studId', align: "center", hide: 'true'},
            {field: 'studAddress', title: '地址', align: "center"},
            {field: 'studRoomNo', title: '房间号', align: "center"},
            {field: 'comName', title: '申请人', align: "center"},
            {field: 'applyReason', title: '申请理由', align: "center"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
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
 * 打开页面
 */
function openHtml(_table, _layer, $, id, comId, studId) {
    _layer.open({
        type: 2,
        title: "工作室申请审批",
        content: "/sa/sp?id=" + id + "&comId=" + comId + "&studId=" + studId + "&userId=" + $("#userId").val(),
        area: ['800px', '450px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function f() {
            _table.reload('list',
                {
                    url: '/api/sa/list',
                    page: {
                        curr: 1
                    }
                });
        }
    });
}