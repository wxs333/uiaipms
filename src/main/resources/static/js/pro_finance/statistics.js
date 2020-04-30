layui.use(["form", "laydate"], function () {
    var $ = layui.$;
    var _laydate = layui.laydate;
    // 渲染时间选择框
    renderInto(_laydate, $);
});

/**
 * 渲染时间选择框
 */
function renderInto(_laydate, $) {
    _laydate.render({
        elem: "#date",
        trigger: 'click',
        range: "~",
        done: function (value) {
            initData($, {"rangeDate": value + ""});
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
            text: '项目拨款数据统计',
            top: 5,
            left: 'center'
        },
        tooltip: {
            formatter: function (info) {
                var value = info.value;
                var name = info.name;

                if (name.split("-").length === 3) {
                    return ["总拨款数：" + value + "元"];
                }

                return [
                    "项目：" + name + "<br>拨款金额：" + value + "元"
                ].join('');
            }
        },
        series: [{
            type: 'treemap',
            leafDepth: 1,
            data: [
                {
                    label: {
                        normal: {
                            show: true
                        }
                    }
                }
            ]
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
        "/api/pf/statistics",
        data,
        function (res) {
            if (res.code === "success") {
                domain.setOption({
                    series: [{
                        data: res.data
                    }]
                });
            } else {
                layui.layer.msg(res.message, {time: 1500, icon: 2, anim: 6})
            }
            domain.hideLoading();
        }
    );
}