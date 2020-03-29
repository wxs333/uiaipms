/**
 * 初始模块加载
 */
layui.use(["form"], function () {
    var _form = layui.form;
    var $ = layui.$;
    var _layer = layui.layer;
    // 表单校验
    check(_form, $);
    // 注册
    register(_form, $, _layer);
});

/**
 * 表单校验
 */
function check(_form, $) {
    _form.verify({
        stuName: function (value, item) {
            if (value.length > 15) {
                return '最多输入15个字符';
            }
        },
        stuNo: [
            /^\d{12,}/,
            '学号输入有误'
        ],
        username: function (value, item) {
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
        },
        password: [
            /^[\S]{6,15}$/
            , '密码必须6到15位，且不能出现空格'
        ],
        passwordAgin: function (value, item) {
            var passwrod = $("[name='password']").val();
            if (value !== passwrod) {
                return '两次密码不一致';
            }
        },
        address: [
            /[a-zA-Z0-9-_\u4e00-\u9fa5]{5,}/,
            '地址输入有误'
        ]

    });
}

/**
 * 注册
 */
function register(_form, $, _layer) {
    _form.on('submit', function (data) {
        $.post(
            '/api/stu/register',
            data.field,
            function (res) {
                _layer.msg(res.message, {time: 1000}, function () {
                    if (res.code === "success") {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    }
                });
            }
        );
        // 阻值表单跳转
        return false;
    });
}