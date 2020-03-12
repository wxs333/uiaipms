layui.use(['element', 'table'], function () {
    var _element = layui.element;
    var _table = layui.table;
    var _layer = layui.layer;

    // 初始化未审批项目的表格
    initNoApprTable(_table);
    // 监听选项卡切换
    _element.on('tab(sp)', function (data) {
        if (data.index === 0) {
            initNoApprTable(_table);
        } else {
            // 初始化已审批项目的表格
            initAppredTable(_table);
        }
    });
    // 监听未审批表格的行事
    _table.on('tool', function (obj) {
        // 打开审批页面
        openApproveHtml(_table, _layer, obj.data.proId, obj.data.proName);
    })
});

/**
 * 初始化未审批项目的表格
 */
function initNoApprTable(_table) {
    _table.render({
        elem: '#no-appr',
        url: '/api/pro/getNoAppr',
        height: 480,
        defaultToolbar: [],
        page: true,
        cols: col()[0],
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
 * 初始化已审批项目的表格
 */
function initAppredTable(_table) {
    _table.render({
        elem: '#appred',
        url: '/api/pa/getAppred',
        height: 480,
        defaultToolbar: [],
        page: true,
        cols: col()[1],
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
 * 表头
 */
function col() {
    var col = [];
    col[0] = [[
        {field: 'proId', title: 'id', align: "center", hide: 'true'},
        {field: 'proName', title: '标题', align: "center"},
        {field: 'proDesc', title: '描述', align: "center"},
        {field: 'proLocation', title: '材料路径', align: "center"},
        {field: 'updateTime', title: '更新时间', align: "center", templet: '#updateTime'},
        {field: 'createTime', title: '创建时间', align: "center", templet: '#createTime'},
        {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
    ]];
    col[1] = [[
        {field: 'proName', title: '标题', align: "center"},
        {field: 'proDesc', title: '描述', align: "center"},
        {field: 'proLocation', title: '材料路径', align: "center"},
        {field: 'approvalFlag', title: '是否通过', align: "center", templet: '#flag'},
        {field: 'reason', title: '原因', align: "center"},
        {field: 'updateTime', title: '审批时间', align: "center", templet: '#updateTime'}
    ]];
    return col;
}

/**
 * 打开审批页面页面
 */
function openApproveHtml(_table, _layer, proId, proName) {
    _layer.open({
        type: 2,
        title: "项目审批",
        content: '/pro/doSp?proId=' + proId + '&proName=' + proName,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '0px',
        end: function f() {
            _table.reload('no-appr',
                {
                    url: '/api/pro/getNoAppr',
                    page: {
                        curr: 1
                    }
                });
        }
    });
}