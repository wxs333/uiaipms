layui.use("form", function () {
    var _form = layui.form;
    var $ = layui.$;

    initSelect($, _form);

    _form.on("submit", function (data) {
        add($, data.field);
        return false;
    });
});

/**
 * 初始化select框
 */
function initSelect($, _form) {
    $.get(
        "/api/stud/getSelect",
        {},
        function (res) {
            var html = "";
            $.each(res.data, function (i, item) {
                html += "<option value=" + item.studId + ">" + item.studAddress + "," + item.studRoomNo + "</option>"
            });
            $("#studio").html(html);
            _form.render("select");
        }
    );
}

/**
 * 添加
 */
function add($, data) {
    $.post(
        "/api/sa/add",
        data,
        function (res) {
            msg(res.code, res.message, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            })
        }
    );
}