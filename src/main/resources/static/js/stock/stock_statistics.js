layui.use(["form", "laydate"], function () {
    var $ = layui.$;
    var _laydate = layui.laydate;
    // 渲染时间选择框
    renderInto(_laydate, $);
    renderOut(_laydate, $);

});

/**
 * 渲染入库时间选择框
 */
function renderInto(_laydate, $) {
    _laydate.render({
        elem: "#into-date",
        trigger: 'click',
        range: "~",
        done: function (value) {
            initData($, "into", "/api/into/statistics", "入库数据统计", {"rangeDate": value + ""});
        }
    })
}

/**
 * 渲染出库时间选择框
 */
function renderOut(_laydate, $) {
    _laydate.render({
        elem: "#out-date",
        trigger: 'click',
        range: "~",
        done: function (value) {
            initData($, "out", "/api/out/statistics", "出库数据统计", {"rangeDate": value + ""});
        }
    })
}

/**
 * 统计图初始化
 */
function initData($, id, url, text, data) {
    // 定义参数
    var option = {
        title: {
            text: text,
            top: 5,
            left: 'center'
        },
        tooltip: {
            formatter: function (info) {
                var value = info.value;
                var name = info.name;

                if (name.split("-").length === 3 && id === "into") {
                    return ["总入库数量：" + value];
                } else if (name.split("-").length === 3 && id === "out") {
                    return ["总出库数量：" + value];
                }

                return [
                    "物品：" + name + "<br>数量：" + value
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
    var domain = echarts.init(document.getElementById(id));
    domain.showLoading();
    domain.setOption(option);
    getAndInit($, domain, url, data);
}

/**
 * 获取数据并初始化
 */
function getAndInit($, domain, url, data) {
    // 获取数据
    $.get(
        url,
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