layui.use(['upload', 'form', 'layer'], function() {
	var $ = layui.jquery;
	var upload = layui.upload;
	var _form = layui.form;
	var _layer = layui.layer;
	// 初始化表单
	initForm($, _form);
	// 头像上传
	imgUpload(upload, _layer, $);
    // 表单提交按钮监听
    _form.on('submit', function (data) {
        // 数据提交
        update($, _layer, data.field);
        return false;
    });
});

/**
 * 头像上传
 */
function imgUpload(upload, _layer, $){
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#upload',
        url: '/api/stu/imgUpload',
        auto: false,
        bindAction: '#submit',
        size: 1024,
        field: 'filePath',
        headers: {'method': 'post'},
        choose: function(obj) { // 图片预览
            obj.preview(function(index, file, result) {
                $('#head-img').attr('src', result);
            });
        },
        done: function(res) {
        	console.log(res.code);
            // 上传成功
            if(res.code === 'success') {
            }
        },
        error: function(){
        	console.log('sssss');
		}
    });
}

/**
 * 表单数据提交
 */
function update($, _layer, data) {
	$.post(
		'/api/stu/updateInfo',
		data,
		function (res) {
            var icon = res.code === 'success'? 1 : 2;
            layer.msg(res.message, {icon: icon});
        }
	);
}

function initForm($, _form) {
	$.get(
		'/api/stu/info',
		{},
		function (res) {
			_form.val('info',res.data);
			$('#head-img').attr('src', res.data.image);
        }
	);
}