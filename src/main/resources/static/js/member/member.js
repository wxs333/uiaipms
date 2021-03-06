layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table, 'student');
    // 头工具栏事件监听
    _table.on('toolbar(table)', function (obj) {
        $("#mark").val(obj.event);
        tableRender(_table, obj.event)
    });
    // 行工具栏事件监听
    _table.on('tool(table)', function (obj) {
        if (obj.event === 'edit') {
            var mark = $("#mark").val();
            var id = getId(mark, obj.data);
                openUpdateHtml(mark, _layer, id, _table);
        } else {
            ban(_table, _layer, $, obj);
        }
    })

});

/**
 * 初始化表格
 */
function tableRender(_table, mark) {
    var data = getCols(mark);
    _table.render({
        elem: '#table',
        height: 570,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: data[1][0],
        page: true,
        cols: [data[0]],
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
 * 获取不同的表头
 */
function getCols(mark) {
    // 数据
    var cols = [];
    switch (mark) {
        case 'student':
            cols[0] = [ // 表头
                {field: 'stuId', title: 'id', align: "center", hide: 'true'},
                {field: 'stuName', title: '学生姓名', align: "center"},
                {field: 'username', title: '用户名', align: "center"},
                {field: 'stuNo', title: '学号', align: "center"},
                {field: 'clazzName', title: '班级', align: "center"},
                {field: 'address', title: '联系地址', align: "center"},
                {field: 'phone', title: '手机号码', align: "center"},
                {field: 'ban', title: '状态', align: "center", templet: "#ban"},
                {field: 'updateTime', title: '更新时间', align: "center"},
                {field: 'createTime', title: '创建时间', align: "center"},
                {field: '', title: "操作", align: "center", minWidth: "180", toolbar: "#rowTool"}
            ];
            // url
            cols[1] = ['/api/stu/list'];
            break;
        case 'tutor':
            cols[0] = [ // 表头
                {field: 'tutorId', title: 'id', align: "center", hide: 'true'},
                {field: 'tutorName', title: '导师姓名', align: "center"},
                {field: 'username', title: '用户名', align: "center"},
                {field: 'facultyName', title: '学院', align: "center"},
                {field: 'phone', title: '手机号码', align: "center"},
                {field: 'ban', title: '状态', align: "center", templet: "#ban"},
                {field: 'updateTime', title: '更新时间', align: "center"},
                {field: 'createTime', title: '创建时间', align: "center"},
                {field: '', title: "操作", align: "center", minWidth: "200", toolbar: "#rowTool"}
            ];
            // url
            cols[1] = ['/api/tutor/list'];
            break;
        case 'company':
            cols[0] = [ // 表头
                {field: 'comId', title: 'id', align: "center", hide: 'true'},
                {field: 'comName', title: '企业名称', align: "center"},
                {field: 'comPeople', title: '负责人', align: "center"},
                {field: 'username', title: '用户名', align: "center"},
                {field: 'phone', title: '联系方式', align: "center"},
                {field: 'ban', title: '状态', align: "center", templet: "#ban"},
                {field: 'updateTime', title: '更新时间', align: "center"},
                {field: 'createTime', title: '创建时间', align: "center"},
                {field: '', title: "操作", align: "center", minWidth: "200", toolbar: "#rowTool"}
            ];
            // url
            cols[1] = ['/api/com/list'];
            break;
    }
    return cols;
}

/**
 * 获取不同id数据
 */
function getId(mark, data) {
    switch (mark) {
        case "student":
            return data.stuId;
        case "tutor":
            return data.tutorId;
        case "company":
            return data.comId;
    }
}

/**
 * 打开修改页面
 */
function openUpdateHtml(mark, _layer, id, _table) {
    _layer.open({
        type: 2,
        title: "修改",
        content: '/admin/update?mark=' + mark + "&id=" + id,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px',
        end: function () {
            _table.reload('table',
                {
                    url: getCols(mark)[1],
                    page: {
                        curr: 1
                    }
                });
        }
    });
}

/**
 * 账号禁用或启用
 */
function ban(_table, _layer, $, obj) {
    var msg = obj.event === "ban" ? "确定要禁用该账号？" : "确定要启用该账号？";
    var ban = obj.event === "ban" ? 1 : 0;
    _layer.confirm(msg,
        {btn: ['确定', '取消'], icon: 3, anim: 1, offset: '130px'},
        function (index) {
            _layer.close(index);
            var mark = $("#mark").val();
            var id = getId(mark, obj.data);
            $.post(
                '/api/admin/ban',
                {'mark': mark, 'id': id, "ban": ban},
                function (res) {
                    var icon = res.code === "success" ? 1 : 2;
                    _layer.msg(res.message,
                        {icon: icon, time: 1500},
                        function () {
                            // 重载表格
                            tableRender(_table, $("#mark").val());
                        });
                }
            );
        });
}
