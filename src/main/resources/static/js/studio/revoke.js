layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表格
    tableRender(_table);

    // 行工具栏监听
    _table.on('tool(revoke)', function (data) {
        // 弹出提示框
        _layer.confirm("确定要回收此工作室吗？",
            {icon: 3, title: '提示', offset: '150px', anim: 1},
            function (index) {
                _layer.close(index);
                // 修改禁用状态
                update(_table, $, data.data.studId);
            });
    });
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#revoke',
        height: 440,
        defaultToolbar: [],
        url: '/api/stud/out', //数据接口
        page: true, //开启分页
        limits: [10, 20, 30],
        cols: [[ // 表头
            {field: 'studId', title: 'id', align: "center", hide: 'true'},
            {field: 'studAddress', title: '地址', align: "center"},
            {field: 'studRoomNo', title: '房间号', align: "center"},
            {field: 'comName', title: '所属企业', align: "center"},
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
 * 修改
 */
function update(_table, $, studId) {
    $.post(
        '/api/stud/revoke',
        {'studId': studId},
        function (res) {
            msg(res.code,
                res.message,
                function () {
                    _table.reload('revoke',
                        {
                            url: '/api/stud/out',
                            page: {
                                curr: 1
                            }
                        });
                });
        }
    )
}
