layui.use(['table', 'transfer', 'layer'], function () {
    var _table = layui.table;
    var _transfer = layui.transfer;
    var _layer = layui.layer;
    var $ = layui.$;
    // 填充表格数据
    renderTable(_table, $);
    // 监听行工具事件
    _table.on("tool(table)", function (obj) {
        if (obj.event === "role") {
            // 弹出角色穿梭框
            openTransfer(_transfer, _layer, $("#mark").val(), obj.data.username);
        }
    });
    // 工具头监听
    _table.on("toolbar(table)", function (data) {
        // 标识设置
        $("#mark").val(data.event);
        // 数据处理
        renderTable(_table, $);
    });
});

/**
 * 渲染表格
 */
function renderTable(_table, $) {
    // 获取标识
    var mark = $("#mark").val();
    var url;
    if (mark === "tutor") {
        url = "/api/tutor/getAll";
    } else {
        url = "/api/stu/getAll";
    }

    _table.render({
        elem: '#demo'
        , height: 550
        , toolbar: "#toolbar"
        , defaultToolbar: []
        , url: url //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'id', title: 'ID', align: "center", hide: "true"}
            , {field: 'name', title: '姓名', align: "center"}
            , {field: 'username', title: '用户名', align: "center"}
            , {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
        ]]
        , limits: [10, 20, 30]
        , parseData: function (res) { // 返回数据格式解析
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.records //解析数据列表
            };
        }
        , request: {
            pageName: 'current' //页码的参数名称，
            , limitName: 'size' //每页数据量的参数名，
        }
    });
}

/**
 * 打开角色穿梭框
 */
function openTransfer(_transfer, _layer, mark, username) {
    _layer.open({
        type: 2,
        title: "分配角色",
        content: '/admin/grantRole?mark=' + mark + '&username=' + username,
        area: ['800px', '520px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}
