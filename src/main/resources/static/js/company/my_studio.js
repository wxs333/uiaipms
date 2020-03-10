layui.use('table', function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;
    // 初始化
    tableRender(_table);
    // 表头工具栏监听
    _table.on('toolbar(my-studio)', function (obj) {
        console.log("sss")
        window.location.href = '/api/com/export';
    });

    // 行工具栏监听
    _table.on('tool', function (obj) {
        var event = obj.event;
        if ('edit' === event) {
            // 弹出输入框
            openPrompt(_layer, $, _table, obj.data.studNum, obj.data.studId);
        } else if ('goods-apply' === event) {
            // 打开物品申请页面
            openGoodsApplyHtml(_layer, obj.data.studId);
        } else {
            // 打开设备详情页面

        }

    });
});

/**
 * 初始化表格
 */
function tableRender(_table) {
    _table.render({
        elem: '#my-studio',
        height: 550,
        toolbar: "#toolbar",
        defaultToolbar: [],
        url: '/api/com/getAllStudio',
        page: true,
        cols: [[ // 表头
            {field: 'studId', title: 'id', align: "center", hide: 'true'},
            {field: 'studAddress', title: '地址', align: "center"},
            {field: 'studRoomNo', title: '房间号', align: "center"},
            {field: 'studNum', title: '人数', align: "center"},
            {field: 'studArea', title: '占地面积(m^2)', align: "center"},
            {field: 'ban', title: '禁用', align: "center", templet: '#ban'},
            {field: 'updateTime', title: '更新时间', align: "center", templet: '#updateTime'},
            {field: 'createTime', title: '创建时间', align: "center", templet: '#createTime'},
            {field: '', title: "操作", align: "center", minWidth: 290, toolbar: "#rowTool"}
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
 * 打开物品申请页面
 */
function openGoodsApplyHtml(_layer, studId) {
    _layer.open({
        type: 2,
        title: "设备申请",
        content: '/com/goodsApply?studId=' + studId,
        area: ['800px', '550px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}

/**
 *弹出人数输入框
 */
function openPrompt(_layer, $, _table, value, studId) {
    _layer.prompt({
        value: value,
        title: '请输入新人数',
        offset: '100px'
    }, function (value, index, elem) { // 点击确定
        // 关闭输入框
        _layer.close(index);
        // 向后台传送数据
        $.post(
            '/api/stud/update',
            {'studNum': value, 'studId': studId},
            function (res) {
                var icon = 'success' === res.code ? 1 : 2;
                _layer.msg(res.message, {icon: icon, time: 1000, offset: '200px'}, function () {
                    // 从新渲染表格
                    tableRender(_table);
                })
            }
        );
    });
}