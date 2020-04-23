/**
 * 提示
 * @param code
 * @param msg
 * @param func
 */
function msg(code, msg, func) {
    var icon = code === 'success' ? 1 : 2;
    layui.layer.msg(msg, {time: 1500, icon: icon}, function () {
        if (typeof func === "function") {
            func();
        }
    });
}
/**
 * Word文档预览
 */
function wordPreview($, location, wordName) {
    var url = "/static/js/pdf/web/viewer.html?file=" + encodeURIComponent("/api/user/previewWord?filePath=" + location + "&fileName=" + wordName);
    window.open(url);
}