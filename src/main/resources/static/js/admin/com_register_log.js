layui.use("table", function () {
    var _table = layui.table;
    var $ = layui.$;

    init(_table);

    _table.on("tool", function (obj) {
        if ("word" === obj.event) {
            var wordName = obj.data.wordName.split(".")[0] + ".pdf";
            wordPreview($, obj.data.location, wordName);
        }

    })
});

/**
 * 表格初始化
 * @param _table
 */
function init(_table) {
    _table.render({
        elem: '#log',
        height: 570,
        defaultToolbar: [],
        limits: [10,20,30],
        page: true,
        url: '/api/com/getByPage', //数据接口
        cols: [[
            {field: 'location', title: '路径', align: "center", hide: "true"},
            {field: 'comName', title: '企业名', align: "center"},
            {field: 'username', title: '账号', align: "center"},
            {field: 'comPeople', title: '园区负责人', align: "center"},
            {field: 'phone', title: '手机号码', align: "center"},
            {field: 'wordName', title: '文档', align: "center", templet: "#word", event: "word"},
            {field: 'agree', title: '审批结果', align: "center", templet: "#agree"},
            {field: 'createTime', title: '申请时间', align: "center"},
            {field: 'updateTime', title: '处理时间', align: "center"}
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