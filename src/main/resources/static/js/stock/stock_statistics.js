layui.use(["form", "laydate"], function () {
    var $ = layui.$;
    var _laydate = layui.laydate;
    // 渲染时间选择框
    renderInto(_laydate, $);
    renderOut(_laydate, $);
    // 统计图初始化
    initData($, "入库数量", "into", "/api/into/statistics", {});
    initData($, "出库数量", "out", "/api/out/statistics", {});
});

/**
 * 渲染入库时间选择框
 */
function renderInto(_laydate, $) {
    var max = new Date().toDateString();
    _laydate.render({
        elem: "#into-date",
        trigger: 'click',
        value: new Date(),
        max: max,
        done: function (value) {
            initData($, "入库数量", "into", "/api/into/statistics", {"date": value + ""});
        }
    })
}

/**
 * 渲染出库时间选择框
 */
function renderOut(_laydate, $) {
    var max = new Date().toDateString();
    _laydate.render({
        elem: "#out-date",
        trigger: 'click',
        value: new Date(),
        max: max,
        done: function (value) {
            initData($, "出库数量", "out", "/api/out/statistics", {"date": value + ""});
        }
    })
}

/**
 * 统计图初始化
 */
function initData($, mark, id, url, data) {
    // 定义参数
    var option = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: [mark]
        },
        xAxis: {
            data: [],
            axisLabel: {
                interval: 0
            }
        },
        yAxis: {
            type: "value"
        },
        series: [{
            name: mark,
            type: 'line',
            itemStyle: {
                normal: {
                    label: {
                        show: true
                    }
                }
            },
            data: []
        }]
    };
    var domain = echarts.init(document.getElementById(id));
    domain.showLoading();
    domain.setOption(option);
    getAndInit($, domain, id, url, data, mark);
}

/**
 * 获取数据并初始化
 */
function getAndInit($, domain, id, url, data, mark) {
    // 获取数据
    $.get(
        url,
        data,
        function (res) {
            domain.setOption({
                xAxis: {
                    data: res.data.name
                },
                series: [{
                    name: mark,
                    data: res.data.num
                }]
            });
            domain.hideLoading();
        }
    );
}