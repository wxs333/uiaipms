layui.use('table', function() {
	var _table = layui.table;
	var $ = layui.$;
	var _layer = layui.layer;
	// 初始化
	tableRender(_table, 'student');
    // 头工具栏事件监听
    _table.on('toolbar(table)', function (obj) {
    	$("#mark").val(obj.event);
        tableRender(_table, obj.event)
    });
    // 行工具栏事件监听
	_table.on('tool(table)', function (obj) {
		openUpdateHtml($("#mark").val(), _layer, obj.data.id);
    })

});
/**
 * 初始化表格
 */
function tableRender(_table, mark) {
	var data = getCols(mark);
	console.log(data);
	_table.render({
		elem: '#table',
		height: 550,
		toolbar: "#toolbar",
		defaultToolbar: [],
		url: data[1][0],
		page: true ,
		cols: [data[0]],
        limits: [10, 20, 30],
		parseData: function (res) { // 返回数据格式解析
            return {
                "code": res.code, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.records //解析数据列表
            };
        },
        request: {
            pageName: 'current' //页码的参数名称，
            , limitName: 'size' //每页数据量的参数名，
        }
	});
}

/**
 * 获取不同的表头
 */
function getCols(mark) {
	// 数据
	var cols = [];
	switch(mark) {
		case 'student':
			cols[0] = [ // 表头
				{field: 'id',title: 'id',align: "center",hide: 'true'},
				{field: 'stuName',title: '姓名',align: "center"},
				{field: 'username',title: '用户名',align: "center"},
				{field: 'stuNo',title: '学号',align: "center"},
                {field: 'clazzName',title: '班级',align: "center"},
				{field: 'address',title: '联系地址',align: "center"},
				{field: 'phone',title: '手机号码',align: "center"},
				{field: 'updateTime',title: '更新时间',align: "center", templet: '#updateTime'},
				{field: 'createTime',title: '创建时间',align: "center", templet: '#createTime'},
				{field: '',title: "操作",align: "center",toolbar: "#rowTool"}
			];
			// url
			cols[1] = ['/api/stu/list'];
			break;
		case 'tutor':
			cols[0] = [ // 表头
					{field: 'id',title: 'id',align: "center",hide: 'true'},
					{field: 'tutorName',title: '姓名',align: "center"},
					{field: 'username',title: '用户名',align: "center"},
					{field: 'facultyName',title: '学院',align: "center"},
					{field: 'phone',title: '手机号码',align: "center"},
                	{field: 'updateTime',title: '更新时间',align: "center", templet: '#updateTime'},
                	{field: 'createTime',title: '创建时间',align: "center", templet: '#createTime'},
					{field: '',title: "操作",align: "center",toolbar: "#rowTool"}
				];
				// url
			cols[1] = ['/api/tutor/list'];
			break;
		case 'company':
			cols[0] = [ // 表头
				{field: 'comId',title: 'id',align: "center",hide: 'true'},
				{field: 'comName',title: '企业名',align: "center"},
                {field: 'comPeople',title: '负责人',align: "center"},
				{field: 'username',title: '用户名',align: "center"},
				{field: 'phone',title: '联系方式',align: "center"},
                {field: 'updateTime',title: '更新时间',align: "center", templet: '#updateTime'},
                {field: 'createTime',title: '创建时间',align: "center", templet: '#createTime'},
				{field: '',title: "操作",align: "center",toolbar: "#rowTool"}
			];
			// url
			cols[1] = ['/api/com/list'];
			break;
	}
	return cols;
}

/**
 * 打开修改页面
 */
function openUpdateHtml(mark, _layer, id) {
    _layer.open({
        type: 2,
        title: "修改学生",
        content: '/admin/update?mark=' + mark + "&id=" + id,
        area: ['800px', '520px'],
        anim: 1,
        scrollbar: false,
        offset: '30px'
    });
}
