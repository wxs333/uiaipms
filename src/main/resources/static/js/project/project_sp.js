layui.use(['element', 'table'], function () {
    var _element = layui.element;
    var _table = layui.table;
    var _layer = layui.layer;
    var $ = layui.$;

    // 初始化未审批项目的表格
    initNoDealTable(_table, $);
    // 监听选项卡切换
    _element.on('tab(sp)', function (data) {
        if (data.index === 0) {
            initNoDealTable(_table, $);
        } else {
            // 初始化已审批项目的表格
            initPersonalTable(_table, $);
        }
    });
    // 监听未审批表格的行事
    _table.on('tool', function (obj) {
        var event = obj.event;
        if ("approve" === event) {
            // 打开审批页面
            openApproveHtml(_table, _layer, $, obj.data.paId, obj.data.proName);
        } else if ("preview" === event) {
            // 文档预览准备
            wordPreview($, obj.data.proLocation, obj.data.wordName);
        }

    });

});

/**
 * 初始化未审批项目的表格
 */
function initNoDealTable(_table, $) {
    _table.render({
        elem: '#no-deal',
        url: '/api/pro/listNoDeal?userId=' + $("#userId").val(),
        height: 485,
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
 * 初始化个人审批项目记录的表格
 */
function initPersonalTable(_table, $) {
    _table.render({
        elem: '#personal',
        url: '/api/pa/getPersonal?userId=' + $("#userId").val(),
        height: 485,
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
        {field: 'paId', title: '审批记录id', align: "center", hide: 'true'},
        {field: 'proLocation', title: '文档路径', align: "center", hide: 'true'},
        {field: 'stuName', title: '申请人', align: "center"},
        {field: 'proName', title: '标题', align: "center"},
        {field: 'proDesc', title: '描述', align: "center"},
        {field: 'wordName,', title: '项目文档', align: "center", event: "preview", templet: "#word"},
        {field: 'createTime', title: '申报时间', align: "center"},
        {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
    ]];
    col[1] = [[
        {field: 'proLocation', title: '文档路径', align: "center", hide: 'true'},
        {field: 'stuName', title: '申请人', align: "center"},
        {field: 'proName', title: '标题', align: "center"},
        {field: 'proDesc', title: '描述', align: "center"},
        {field: 'wordName', title: '项目文档', align: "center", event: "preview", templet: "#word"},
        {field: 'passFlag', title: '是否通过', align: "center", templet: '#flag'},
        {field: 'reason', title: '原因', align: "center"},
        {field: 'updateTime', title: '审批时间', align: "center"}
    ]];
    return col;
}

/**
 * 打开审批页面页面
 */
function openApproveHtml(_table, _layer, $, paId, proName) {
    _layer.open({
        type: 2,
        title: "项目审批",
        content: '/pro/doSp?paId=' + paId + '&proName=' + proName + "&userId=" + $("#userId").val(),
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '0px',
        end: function f() {
            _table.reload('no-deal',
                {
                    url: "/api/pro/listNoDeal?userId=" + $("#userId").val(),
                    page: {
                        curr: 1
                    }
                });
        }
    });
}