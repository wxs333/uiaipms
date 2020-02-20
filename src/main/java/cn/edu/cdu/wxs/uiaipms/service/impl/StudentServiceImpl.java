package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StudentMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.UserRoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

/**
 * 学生的服务层实现类
 *
 * @author WXS
 * @date 2020/1/11
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentForm> implements StudentService {
    /**
     * mapper对象
     */
    @Autowired
    private StudentMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 学生的角色ID
     */
    private static final String STUDENT_ROLE_ID = "10a258b4defc4f5db4847b09ce883f73";

    @Override
    public BaseMapper<StudentForm> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, StudentColumn.STUDENT_TABLE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(StudentForm form) {
        // 设置角色
        UserRoleForm userRole = new UserRoleForm();
        userRole.setUrId(SystemUtils.getUuid());
        userRole.setRoleId(STUDENT_ROLE_ID);
        userRole.setUserId(form.getStuId());
        userRole.setUrWho(GlobalConstant.LOGIN_ROLE_STUDENT);
        userRole.setCreateTime(form.getCreateTime());
        userRole.setUpdateTime(form.getUpdateTime());

        return add(form) && SystemUtils.gtTheZero(userRoleMapper.insert(userRole));
    }

    @Override
    public boolean isExistByUsernameOrStuNo(String username, String stuNo) {
        QueryWrapper<StudentForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudentColumn.STU_ID)
                .eq(GlobalConstant.USERNAME, username)
                .or()
                .eq(StudentColumn.STU_NO, stuNo);
        return !ObjectUtils.isEmpty(mapper.selectOne(wrapper));
    }

    @Override
    public StudentForm getByUsername(String username) {
        return mapper.getByUsername(username);
    }

    @Override
    public IPage<StudentForm> getAll(Page<StudentForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public IPage<StudentForm> getAllToList(Page<StudentForm> page) {
        return mapper.selectAllInfo(page);
    }

    @Override
    public StudentForm getOneById(String id) {
        return mapper.selectOneById(id);
    }

    @Override
    public boolean update(StudentForm form) {
        form.setDiscId(null);
        form.setUpdateTime(LocalDateTime.now());
        return SystemUtils.gtTheZero(mapper.updateById(form));
    }

    @Override
    public String imgUpload(MultipartFile multipartFile, String dir) {
        // 文件名称
        String fileName = multipartFile.getOriginalFilename();
        // 文件上传路径
        try {
            String uploadPath = ResourceUtils.getURL("") + dir;
            uploadPath = uploadPath.substring(6);
            File file = new File(uploadPath + File.separator + fileName);
            // 检测目录是否存在
            if (file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
            int len = inputStream.read();
            FileOutputStream outputStream = new FileOutputStream(file);
            while (len != -1) {
                outputStream.write(len);
                len = inputStream.read();
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public boolean updateInfo(StudentForm form) {
        // 图片路径前缀
        String dirPrefix = "/static/img/head_portrait/";
        // 处理表单的文件名
        String fileName = getFileName(form.getFilePath());
        // 表单数据填充
        form.setFilePath(null);
        form.setUpdateTime(LocalDateTime.now());
        form.setImage(fileName.isEmpty() ? null : dirPrefix + fileName);
        return update(form);
    }

    /**
     * 获取文件名
     *
     * @param path 文件路径
     * @return
     */
    private String getFileName(String path) {
        int index = path.lastIndexOf("\\");
        return path.substring(index + 1);
    }

    @Override
    public StudentForm getInfo(String stuId) {
        QueryWrapper<StudentForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudentColumn.STU_ID, StudentColumn.STU_NAME, StudentColumn.ADDRESS,
                GlobalConstant.USERNAME, GlobalConstant.PHONE,StudentColumn.IMAGE)
                .eq(GlobalConstant.LOGIC_DELETE_FLAG, 0)
                .eq(StudentColumn.STU_ID, stuId);
        return mapper.selectOne(wrapper);
    }
}
