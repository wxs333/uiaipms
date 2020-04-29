layui.use(["form", "laydate"], function () {
    var $ = layui.$;
    var _laydate = layui.laydate;
    // 渲染时间选择框
    renderInto(_laydate, $);
    renderOut(_laydate, $);
    // 统计图初始化
    initData($, "into", "/api/into/statistics", {"rangeDate": ""});
    //initData($, "out", "/api/out/statistics", {});
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
            initData($, "into", "/api/into/statistics", {"rangeDate": value + ""});
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
            initData($, "out", "/api/out/statistics", {"rangeDate": value + ""});
        }
    })
}

/**
 * 统计图初始化
 */
function initData($, id, url, data) {
    if (data.rangeDate === "") {
        return;
    }
    // 定义参数
    var option = {
        title: {
            text: '数据统计',
            top: 5,
            left: 'center'
        },
        tooltip: {
            formatter: function (info) {
                var value = info.value;
                var name = info.name;

                return [
                    name + "：" + value
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
            domain.setOption({
                series: [{
                    data: res.data
                }]
            });
            domain.hideLoading();
        }
    );
}