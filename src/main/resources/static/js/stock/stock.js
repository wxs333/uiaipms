layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;

    // 初始化表格
    tableRender(_table, 'into-log');
    // 表头工具栏监听
    _table.on('toolbar(table)', function (obj) {
        var event = obj.event;
        // 修改标题
        changeTitle($, event);
        if (event === 'into-log' || event === 'out-log') {
            // 重载表格
            tableRender(_table, event);
        } else {
            // 打开相应页面
            openHtml(_table, _layer, event);
        }

    });
});

/**
 * 初始化表格
 */
function tableRender(_table, event) {
    // 获取cols与url
    var data = getColsAndUrl(event);
    _table.render({
        elem: '#table',
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
    if (event === 'into-log') {
        data[0] = [ // 表头
            {field: 'adminName', title: '管理员', align: "center"},
            {field: 'goodsName', title: '物品', align: "center"},
            {field: 'goodsBrand', title: '品牌', align: "center"},
            {field: 'goodsModel', title: '型号', align: "center"},
            {field: 'goodsNum', title: '数量', align: "center"},
            {field: 'price', title: '入库价格', align: "center"},
            {field: 'updateTime', title: '更新时间', align: "center"},
            {field: 'createTime', title: '创建时间', align: "center"}
        ];
        data[1] = '/api/into/list';
    } else {
        data[0] = [ // 表头
            {field: 'adminName', title: '管理员', align: "center"},
            {field: 'goodsName', title: '物品', align: "center"},
            {field: 'applyNum', title: '数量', align: "center"},
            {field: 'address', title: '申请人', align: "center"},
            {field: 'updateTime', title: '更新时间', align: "center"},
            {field: 'createTime', title: '创建时间', align: "center"}
        ];
        data[1] = '/api/out/list';
    }
    return data;
}

/**
 * 打开页面
 */
function openHtml(_table, _layer, event) {
    var d = {};
    if ('into' === event) {
        d = {'title': '物品入库', 'content': '/sto/into', 'width': '800px'};
    } else if ('out' === event) {
        d = {'title': '出库审批', 'content': '/sto/out_list', 'width': '1200px'};
    } else if ('apply' === event) {
        d = {'title': '采购资金申请', 'content': '/sto/applyList', 'width': '1200px'};
    } else if ("statistics" === event) {
        d = {'title': '统计', 'content': '/sto/statistics', 'width': '1200px'};
    }
    doOpen(_table, _layer, d);
}

/**
 * 执行打开页面
 */
function doOpen(_table, _layer, data) {
    _layer.open({
        type: 2,
        title: data.title,
        content: data.content,
        area: [data.width, '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}

/**
 * 修改标题
 */
function changeTitle($, event) {
    if (event === 'into-log') {
        $('#title').text('入库记录');
    } else if (event === 'out-log') {
        $('#title').text('出库记录');
    }

}