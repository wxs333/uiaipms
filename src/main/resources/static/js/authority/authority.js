layui.use(['table', 'transfer', 'layer'], function () {
    var _table = layui.table;
    var _layer = layui.layer;
    var $ = layui.$;
    // 填充表格数据
    renderTable(_table, $);
    // 监听行工具事件
    _table.on("tool(table)", function (obj) {
        if (obj.event === "role") {
            // 弹出角色穿梭框
            openTransfer(_layer, $("#mark").val(), obj.data.id);
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
    var cols = getCols(mark);
    _table.render({
        elem: '#demo'
        , height: 570
        , toolbar: "#toolbar"
        , defaultToolbar: []
        , url: cols[1] //数据接口
        , page: true //开启分页
        , cols: [cols[0]]
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
 * 获取不同的表头
 */
function getCols(mark) {
    // 数据
    var cols = [];
    switch (mark) {
        case 'student':
            cols[0] = [
                {field: 'id', title: 'ID', align: "center", hide: "true"}
                , {field: 'name', title: '学生姓名', align: "center"}
                , {field: 'username', title: '用户名', align: "center"}
                , {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
            ];
            // url
            cols[1] = ['/api/stu/getAll'];
            break;
        case 'tutor':
            cols[0] = [
                {field: 'id', title: 'ID', align: "center", hide: "true"}
                , {field: 'name', title: '导师姓名', align: "center"}
                , {field: 'username', title: '用户名', align: "center"}
                , {field: '', title: "操作", align: "center", toolbar: "#rowTool"}
            ];
            // url
            cols[1] = ['/api/tutor/getAll'];
            break;
    }
    return cols;
}

/**
 * 打开角色穿梭框
 */
function openTransfer(_layer, mark, id) {
    _layer.open({
        type: 2,
        title: "分配角色",
        content: '/admin/grantRole?mark=' + mark + '&userId=' + id,
        area: ['800px', '520px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}
