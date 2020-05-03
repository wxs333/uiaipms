layui.use(["form", "upload"], function () {
    var _form = layui.form;
    var _upload = layui.upload;
    var _layer = layui.layer;
    var $ = layui.$;

    wordUpload(_upload, $, _layer);

    _form.on("submit", function (data) {
        register($, data.field);
        return false;
    });
});

/**
 * Word文档上传
 */
function wordUpload(_upload, $, _layer) {
    var index = "";
    _upload.render({
        elem: '#word',
        url: '/api/com/upload',
        headers: {'method': 'post'},
        accept: 'file',
        acceptMime: '.doc,.docx',
        exts: 'doc|docx',
        multiple: true,
        choose: function (obj) {
            obj.preview(function (index, file) {
                $("#wordName").text("已选择：" + file.name);
            });
            // 加载层
            index = _layer.load(2);
        },
        done: function (res) {
            var icon = res.code === "200" ? 1 : 2;
            _layer.msg(res.msg, {time: 1500, icon: icon}, function () {
                $("#location").val(res.location);
                $("#hide-word-name").val(res.wordName);
                $("#submit").removeClass("layui-btn-disabled");
                // 关闭加载层
                _layer.close(index);
            });
        }
    })
}

/**
 * 注册
 * @param $
 * @param data
 */
function register($, data) {
    $.post(
        "/api/com/register",
        data,
        function (res) {
            msg(res.code, res.message, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    )
}