layui.use("table", function () {
    var _table = layui.table;
    var $ = layui.$;
    var _layer = layui.layer;

    init(_table);

    _table.on("tool", function (obj) {
        var event = obj.event;
        if ("word" === event) {
            var wordName = obj.data.wordName.split(".")[0] + ".pdf";
            wordPreview($, obj.data.location, wordName);
        } else if ("ok" === event) {
            ask(_layer, function () {
                sp($, _table, "0", obj.data.comId);
            })
        } else if ("no" === event) {
            ask(_layer, function () {
                sp($, _table, "1", obj.data.comId);
            })
        }
    });

    _table.on("toolbar", function (obj) {
        var event = obj.event;
        if ("export" === event) {
            window.location.href = "/api/com/registerExport";
        } else if ("log" === event) {
            popUp(_layer);
        }
    });
});

/**
 * 表格初始化
 * @param _table
 */
function init(_table) {
    _table.render({
        elem: '#sp',
        height: 570,
        defaultToolbar: [],
        toolbar: "#toolbar",
        limits: [10, 20, 30],
        page: true,
        url: '/api/com/getNotRegister', //数据接口
        cols: [[
            {field: 'comId', title: 'id', align: "center", hide: "true"},
            {field: 'location', title: '路径', align: "center", hide: "true"},
            {field: 'comName', title: '企业名', align: "center"},
            {field: 'username', title: '账号', align: "center"},
            {field: 'comPeople', title: '园区负责人', align: "center"},
            {field: 'phone', title: '手机号码', align: "center"},
            {field: 'wordName', title: '文档', align: "center", templet: "#word", event: "word"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: '', title: '操作', align: "center", templet: "#row"}
        ]],
        parseData: function (res) { // 返回数据格式解析
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "data": res.data.records, //解析数据列表
                "count": res.data.total //解析数据长度
            };
        },
        request: {
            pageName: 'current' //页码的参数名称，
            , limitName: 'size' //每页数据量的参数名，
        }
    });
}

/**
 * 表格重载
 * @param _table
 */
function reload(_table) {
    _table.reload("sp", {
        page: {
            curr: 1
        }
    });
}

/**
 * 弹出询问框
 * @param _layer
 * @param fn
 */
function ask(_layer, fn) {
    _layer.confirm("你确定吗？", {icon: 3, title: '提示', anim: 1}, function (index) {
        fn();
        _layer.close(index);
    })
}

/**
 * 企业入驻审批
 */
function sp($, _table, agree, id) {
    $.post(
        "/api/admin/registerSp",
        {"agree": agree, "id": id},
        function (res) {
            msg(res.code, res.message, function () {
                reload(_table);
            })
        }
    )
}

/**
 * 弹出历史记录
 */
function popUp(_layer) {
    _layer.open({
        type: 2,
        anim: 1,
        scrollbar: false,
        title: "历史记录",
        content: "/admin/registerLog",
        area: ["1200px", "550px"]
    })
}