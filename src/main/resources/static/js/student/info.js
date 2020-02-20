layui.use('upload', function() {
	var $ = layui.jquery;
	var upload = layui.upload;
	
	//普通图片上传
	var uploadInst = upload.render({
		elem: '#upload',
		url: 'https://httpbin.org/post',
		auto: false,
		bindAction: '#submit',
		choose: function(obj) { // 图片预览
			obj.preview(function(index, file, result) {
				$('#head-img').attr('src', result);
			});
		},
		done: function(res) {
			//如果上传失败
			if(res.code > 0) {
				return layer.msg('上传失败');
			}
			//上传成功
		},
		error: function() {
			//演示失败状态，并实现重传
			var uploadError = $('#upload-error');
			uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			uploadError.find('.demo-reload').on('click', function() {
				uploadInst.upload();
			});
		}
	});
});