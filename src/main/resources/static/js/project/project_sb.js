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
    })
});

/**
 * Word文档上传
 */
function wordUpload(_upload) {
    _upload.render({
        elem: '#word',
        url: '/api/pro/word',
        headers: {'method': 'post'},
        accept: 'file',
        acceptMime: 'file/doc, file/docx',
        exts: 'doc|docx',
        auto: false,
        bindAction: '#submit',
        multiple: true,
        before: function () {

        },
        done: function () {

        }
    })
}

/**
 * 项目申报
 */
function add($, _layer, data) {
    $.post(
        '/api/pro/add',
        data,
        function (res) {
            var icon = res.code === 'success' ? 1 : 2;
            _layer.msg(res.message, {time: 1500, icon: icon});
        }
    )
}