layui.use(['upload', 'layer'], function () {
    var $ = layui.jquery;
    var upload = layui.upload;
    var _layer = layui.layer;

    $("#img").attr("src", "/api/user/headImg?userId=" + $("#userId").val());

    // 头像上传，获取服务器上的文件名
    imgUpload(upload, _layer, $);
});

/**
 * 头像上传
 */
function imgUpload(upload, _layer, $) {
    //普通图片上传
    upload.render({
        elem: '#upload',
        url: "/api/user/uploadHeadImg?userId=" + $("#userId").val(),
        auto: false,
        bindAction: '#ok',
        size: 1024,
        field: 'file',
        acceptMime: ".png,.jpg",
        headers: {'method': 'post'},
        choose: function (obj) { // 图片预览
            obj.preview(function (index, file, result) {
                $('#img').attr('src', result);
            });
        },
        done: function (res) {
            var icon = res.code === '200' ? 1 : 2;
            layer.msg(res.msg, {icon: icon}, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        }
    });
}
