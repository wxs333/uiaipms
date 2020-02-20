layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表格
    tableRender(_table);
    // 表头工具栏监听
    _table.on('toolbar(table)', function (data) {
        var event = data.event;
        // 记录分类查询
        if (event.split('-')[1] === 'log') {
            // 表格重加载
            reloadTable(_table, event);
        } else {
            // 弹出表单页面
            openHtml(_table, _layer, event);
        }
    });
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#table',
        height: 550,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: '/api/sto/list', //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [[ // 表头
            {field: 'adminName', title: '处理人', align: "center"},
            {field: 'stoType', title: '类型', align: "center"},
            {field: 'goodsName', title: '物品', align: "center"},
            {field: 'goodsNum', title: '数量', align: "center"},
            {field: 'comName', title: '申请人', align: "center"},
            {field: 'updateTime', title: '更新时间', align: "center", templet: '#updateTime'},
            {field: 'createTime', title: '创建时间', align: "center", templet: '#createTime'},
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
 * 表格重加载
 */
function reloadTable(_table, event) {
    var type = event === 'into-log' ? 1 : 0;
    _table.reload('table',
        {
            url: '/api/sto/list',
            page: {
                curr: 1
            },
            where: {
                'type': type
            }
        });
}
/**
 * 打开页面
 */
function openHtml(_table, _layer, event) {
    var d = {};
    if ('into' === event) {
        d = {'title': '入库', 'content': '/sto/into'};
        doOpen(_table, _layer, d);
    } else if ('edit' === event) {
        d = {'out': '出库', 'content': '/sto/out'};
        doOpen(_table, _layer, d);
    }
}

/**
 * 执行打开页面
 */
function doOpen(_table, _layer, data) {
    _layer.open({
        type: 2,
        title: data.title,
        content: data.content,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function f() {
            _table.reload('table',
                {
                    url: '/api/sto/list',
                    page: {
                        curr: 1
                    }
                });
        }
    });
}
