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