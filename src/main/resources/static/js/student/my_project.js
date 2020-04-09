layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表格
    tableRender(_table);
    // 行工具栏监听
    _table.on('tool', function (obj) {
        console.log(obj.event);
        if ("preview" === obj.event) {
            // 文档预览
            wordPreview($, obj.data);
        } else if ("afresh" === obj.event) {
            var url = "/stu/afresh?proId=" + obj.data.proId + "&proName=" + obj.data.proName + "&proDesc=" + obj.data.proDesc;
            // 打开页面
            openHtml(_table, _layer, {"title": "项目重新申报", "url": url, "width": "1000px"})
        }
    })
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#my-pro',
        height: 570,
        defaultToolbar: [],
        url: '/api/pro/getPersonalPro', //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [[ // 表头
            {field: 'proId', title: '', align: "center", hide: 'true'},
            {field: 'proLocation', title: '', align: "center", hide: 'true'},
            {field: 'proName', title: '项目名', align: "center"},
            {field: 'wordName', title: '项目文档', align: "center", event: "preview", templet: "#word"},
            {field: 'proDesc', title: '项目描述', align: "center"},
            {field: 'createTime', title: '申报时间', align: "center"},
            {field: 'paFlag', title: '是否审批', align: "center", templet: "#pa"},
            {field: 'prFlag', title: '是否审核', align: "center", templet: "#pr"},
            {field: 'lxFlag', title: '是否立项', align: "center", templet: "#lx"},
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
 * 重加载表格
 */
function reload(_table) {
    _table.reload("my-pro", {
        page: {
            curr: 1
        }
    });
}

/**
 * 弹出HTML页面
 */
function openHtml(_table, _layer, data) {
    _layer.open({
        type: 2,
        title: data.title,
        content: data.url,
        area: [data.width, "530px"],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function () {
            reload(_table);
        }
    });
}