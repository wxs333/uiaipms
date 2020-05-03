layui.use(['upload', 'form', 'layer'], function () {
    var $ = layui.jquery;
    var _upload = layui.upload;
    var _form = layui.form;
    var _layer = layui.layer;
    // 监听表单提交
    _form.on('submit', function (data) {
        // 数据提交导后台
        add($, _layer, data.field);
        return false;
    });

    wordUpload(_upload, $, _layer);
});

/**
 * Word文档上传
 */
function wordUpload(_upload, $, _layer) {
    _upload.render({
        elem: '#word',
        url: '/api/pro/uploadWord',
        headers: {'method': 'post'},
        accept: 'file',
        acceptMime: '.doc, .docx',
        exts: 'doc|docx',
        multiple: true,
        choose: function (obj) {
            obj.preview(function (index, file) {
                $("#wordName").text("已选择：" + file.name);
            });
        },
        done: function (res) {
            var icon = res.code === "200" ? 1 : 2;
            _layer.msg(res.msg, {time: 1500, icon: icon}, function () {
                $("#proLocation").val(res.proLocation);
                $("#hide-word-name").val(res.wordName);
                $("#submit").removeClass("layui-btn-disabled");
            });
        }
    })
}

/**
 * 项目申报
 */
function add($, _layer, data) {
    $.post(
        '/api/pro/add?userId=' + $("#userId").val(),
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    )
}