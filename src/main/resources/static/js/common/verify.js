layui.use("form", function () {
    var _form = layui.form;
    var $ = layui.$;

    verify(_form,$)
});
/**
 * 校验规则
 */
function verify(_form, $) {
    _form.verify({
        name: function (value) {
            if (value.length > 15) {
                return '最多输入15个字符';
            }
        },
        stuNo: function (value) {
            if (!/^[\d]*$/.test(value)) {
                return "学号只能输入数字"
            }
            if (!/^[\d]{10,}$/.test(value)) {
                return "学号至少10位";
            }
        },
        username: function (value) {
            if (!/^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$/.test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
            if (!/^[a-z]*?$/.test(value)) {
                return "用户名必须由字母组成"
            }
        },
        password: [
            /^[\S]{6,15}$/
            , '密码必须6到15位，且不能出现空格'
        ],
        passwordAgain: function (value) {
            var password = $("#password").val();
            if (value !== password) {
                return '两次密码不一致';
            }
        },
        reason: function (value) {
            if (value.length < 15) {
                return "至少输入15个字"
            }
        },
        area: function (value) {
            if (value !== "" && isNaN(value)) {
                return "面积应该为数字";
            }
            if (value !== "" && value <= 0) {
                return "面积应大于0"
            }
        },
        num: function (value) {
            if (value !== "" && isNaN(value)) {
                return "只能输入数字";
            }
            if (value !== "" && value <= 0) {
                return "金额应该大于0"
            }
        },
        notFloatNum: [
            /^[1-9]\d*$/,
            "只能输入非零正整数"
        ],
        applyNum: function (value) {
            var lastNum = parseInt($("#lastNum").val());
            if (parseInt(value) > lastNum)  {
                return "申请数量超过限制"
            }
        }
    });
}