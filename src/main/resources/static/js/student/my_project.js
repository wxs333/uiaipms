layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化表格
    tableRender(_table);
    // 行工具栏监听
    _table.on('tool(my-pro)', function (data) {

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
            {field: 'studId', title: 'id', align: "center", hide: 'true'},
            {field: 'studAddress', title: '地址', align: "center"},
            {field: 'studRoomNo', title: '房间号', align: "center"},
            {field: 'comName', title: '所属企业', align: "center"},
            {field: 'comPeople', title: '负责人', align: "center"},
            {field: 'studNum', title: '人数', align: "center"},
            {field: 'studArea', title: '占地面积(m^2)', align: "center"},
            {field: 'updateTime', title: '更新时间', align: "center", templet: '#updateTime'},
            {field: 'createTime', title: '创建时间', align: "center", templet: '#createTime'},
            {field: '', title: "操作", align: "center", minWidth: "180", toolbar: "#rowTool"}
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
function openHtml(_table, _layer, event, id) {
    var d = {};
    if ('add' === event) {
        d = {'title': '新增工作室', 'content': '/stud/add', 'id': ''};
        doOpen(_table, _layer, d);
    } else if ('edit' === event) {
        d = {'title': '修改工作室', 'content': '/stud/update', 'id': id};
        doOpen(_table, _layer, d);
    }
}

/**
 * 执行打开页面
 */
function doOpen(_table, _layer, data) {
    var content = data.id === '' ? data.content : data.content + '?id=' + data.id;
    _layer.open({
        type: 2,
        title: data.title,
        content: content,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function f() {
            _table.reload('table',
                {
                    url: '/api/stud/list',
                    page: {
                        curr: 1
                    }
                });
        }
    });
}

/**
 * 修改禁用状态
 */
function updateBan(_table, $, _layer, ban, studId) {
    $.post(
        '/api/stud/updateBan',
        {'ban': ban, 'studId': studId},
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message,
                {time: 1500, icon: icon},
                function () {
                    _table.reload('table',
                        {
                            url: '/api/stud/list',
                            page: {
                                curr: 1
                            }
                        });
                });
        }
    )
}