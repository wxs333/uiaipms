layui.use(['table'], function () {
    var _table = layui.table;
    var $ = layui.$;

    // 数据初始化
    tableRender(_table, $);
});

/**
 * 初始化表格
 */
function tableRender(_table, $) {
    _table.render({
        elem: '#details',
        height: 450,
        defaultToolbar: [],
        url: '/api/goods/seeGoods', //数据接口
        where: {"studId": $("#studId").val()},
        cols: [[
            {field: 'goodsName', title: '物品', align: "center"},
            {field: 'goodsBrand', title: '品牌', align: "center"},
            {field: 'goodsModel', title: '型号', align: "center"},
            {field: 'unitName', title: '单位', align: "center"},
            {field: 'goodsNum', title: '申请数量', align: "center"},
            {field: 'updateTime', title: '申请时间', align: "center", templet: "#timeFormat"},
        ]],
        parseData: function (res) { // 返回数据格式解析
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "data": res.data //解析数据列表
            };
        }
    });
}