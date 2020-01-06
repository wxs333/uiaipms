package cn.edu.cdu.wxs.uiaipms.result;

import cn.edu.cdu.wxs.uiaipms.jsonview.View;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * 封装数据库返回的结果
 *
 * @author WXS
 * @date 2019/12/25
 */
public class StudentResult {

    /**
     * id
     */
    @JsonView({View.DefaultView.class})
    public Integer id;
}
