layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table);
    // 头工具栏事件监听
    _table.on('toolbar(goods)', function (obj) {
        // 数据导出
        window.location.href = "/api/goods/export";
    });
    // 行工具栏事件监听
    _table.on('tool(goods)', function (obj) {
        var event = obj.event;
        if ("edit" === event) {
            // 打开修改页面
            openUpdateHtml(_layer, _table, obj.data.goodsId);
        } else {
            // 弹出确认框
            openConfirm($, _layer, _table, obj);
        }
    })

});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#goods',
        height: 570,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: "/api/goods/list",
        page: true,
        cols: [[ // 表头
            {field: 'goodsId', title: 'id', align: "center", hide: 'true'},
            {field: 'goodsName', title: '名称', align: "center"},
            {field: 'goodsBrand', title: '品牌', align: "center"},
            {field: 'goodsModel', title: '型号', align: "center"},
            {field: 'goodsNum', title: '剩余数量', align: "center"},
            {field: 'price', title: '入库单价(元)', align: "center"},
            {field: 'unitName', title: '单位', align: "center"},
            {field: 'ban', title: '状态', align: "center", templet: "#ban"},
            {field: 'updateTime', title: '更新时间', align: "center"},
            {field: 'createTime', title: '创建时间', align: "center"},
            {field: '', title: "操作", minWidth: '170', align: "center", toolbar: "#rowTool"}
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
    _table.reload('goods',
        {
            url: "/api/goods/list",
            page: {
                curr: 1
            }
        });
}

/**
 * 弹出确认框
 * @param $
 * @param _layer
 * @param obj
 */
function openConfirm($, _layer, _table, obj) {
    var msg = obj.event === "ban" ? "您确定要下架吗？" : "您确定要上架吗？";
    _layer.confirm(msg, {icon: 3, title: "确认信息", anim: 1}, function (index) {
        // 执行修改
        updateStatus($, _layer, _table, obj.event, obj.data.goodsId);
        // 关闭
        _layer.close(index);
    });
}

/**
 * 修改状态
 */
function updateStatus($, _layer, _table, event, id) {
    var ban = event === "ban" ? 1 : 0;
    $.post(
        "/api/goods/update",
        {"goodsId": id, "ban": ban},
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(
                res.message,
                {time: 1500, icon: icon, offset: '200px'},
                function () {
                    reloadTable(_table);
                });
        }
    );
}