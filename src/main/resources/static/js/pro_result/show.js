layui.use(["laydate", "jquery"], function () {
    var _laydate = layui.laydate;
    var $ = layui.$;

    renderDate(_laydate, $)
});


/**
 * 渲染时间选择框
 */
function renderDate(_laydate, $) {
    _laydate.render({
        elem: "#date",
        trigger: 'click',
        range: "~",
        done: function (value) {
            getData($, {"date": value + ""});
        }
    })
}

/**
 * 获取数据
 */
function getData($, data) {
    var domain = echarts.init(document.getElementById("pro-result"));
    domain.showLoading();
    $.get(
        "/api/res/show",
        data,
        function (res) {
            initData($, res.data, domain)
        }
    )
}

/**
 * 统计图初始化
 */
function initData($, data, domain) {
    // 定义参数
    var option = {
        title: {
            text: '已孵化项目',
            top: 5,
            left: 'center'
        },
        legend: {
            data: '总量'
        },
        xAxis: {
            type: 'category',
            data: data.date
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            type: 'line',
            data: data.num,
            itemStyle: {
                normal:
                    {
                        label:
                            {show: true}
                    }
            }
        }]
    };
    domain.setOption(option);
    domain.hideLoading();
}