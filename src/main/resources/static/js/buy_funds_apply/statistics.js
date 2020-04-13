layui.use(["form", "laydate"], function () {
    var $ = layui.$;
    var _laydate = layui.laydate;
    // 渲染时间选择框
    renderInto(_laydate, $);
    // 统计图初始化
    initData($, {});
});

/**
 * 渲染时间选择框
 */
function renderInto(_laydate, $) {
    var max = new Date().toDateString();
    _laydate.render({
        elem: "#date",
        trigger: 'click',
        value: new Date(),
        max: max,
        done: function (value) {
            initData($, {"date": value + ""});
        }
    })
}

/**
 * 统计图初始化
 */
function initData($, data) {
    // 定义参数
    var option = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ["每天拨款金额"]
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
            name: "每天拨款金额",
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
    var domain = echarts.init(document.getElementById("show"));
    domain.showLoading();
    domain.setOption(option);
    getAndInit($, domain, data);
}

/**
 * 获取数据并初始化
 */
function getAndInit($, domain, data) {
    // 获取数据
    $.get(
        "/api/bf/statistics",
        data,
        function (res) {
            domain.setOption({
                xAxis: {
                    data: res.data.name
                },
                series: [{
                    data: res.data.num
                }]
            });
            domain.hideLoading();
        }
    );
}