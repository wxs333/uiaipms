package cn.edu.cdu.wxs.uiaipms.utils;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 系统工具类
 *
 * @author WXS
 * @date 2020/1/10
 */
public class SystemUtils {

    /**
     * 判断一个数是否大于0
     *
     * @param number 数字
     * @return true 大于，false 不大于
     */
    public static boolean gtTheZero(int number) {
        return number > 0;
    }

    /**
     * 用户密码加密，采用Md5Hash 加密
     *
     * @param str  密码
     * @param salt 盐
     * @return 加密的密码
     */
    public static String md5(String str, String salt) {
        // 加密次数
        final int hashIterations = 1024;
        Md5Hash md5Hash = new Md5Hash(str, salt, hashIterations);
        return md5Hash.toString();
    }

    /**
     * 生成UUID 作为记录的ID
     *
     * @return UUID
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成6位验证码，用于找回密码身份验证
     *
     * @return 验证码
     */
    public static String verificationCode() {
        int length = 6;
        // 获取一个随机数
        double v = Math.random();
        // 处理成6位验证码
        v = v * 1000000;
        String code = Integer.toString(new Double(v).intValue());
        // 缺位补0
        if (code.length() < length) {
            code += "0";
        }
        return code;
    }

    /**
     * 获取不重复的文件名
     *
     * @param filename 原来的文件名
     * @return 新的文件名
     */
    public static String getNotRepeatingFilename(String filename) {
        // 得到文件后缀
        int index = filename.lastIndexOf(".");
        String suffix = filename.substring(index);
        System.out.println(index);
        // 重新命名
        return System.currentTimeMillis() + suffix;
    }

    /**
     * 获取当前登录用户的id
     *
     * @param session 会话
     * @return id
     */
    public static String getUserId(HttpSession session) {
        return (String) session.getAttribute(GlobalConstant.USER_ID);
    }

    /**
     * 获取指定日期的开始时间
     *
     * @param date 日期
     * @return 开始时间
     */
    public static LocalDateTime getStartOfDay(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    /**
     * 获取指定日期的结束时间
     *
     * @param date 日期
     * @return 结束时间
     */
    public static LocalDateTime getEndOfDay(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MAX);
    }

    /**
     * 对出入库统计结果进行格式化
     *
     * @param map 结果集和
     * @return 格式化结果集合
     */
    public static Map<String, List> formatMap(Map<String, Map<String, Object>> map) {
        List<String> name = new ArrayList<>(map.size());
        List<Integer> num = new ArrayList<>(name.size());
        Iterator<Map<String, Object>> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Map<String, Object> next = iterator.next();
            name.add((String) next.get("goodsName"));
            num.add(((BigDecimal) next.get("total")).intValue());
        }
        Map<String, List> data = new HashMap<>(2);
        data.put("name", name);
        data.put("num", num);

        return data;
    }

    public static void main(String[] args) {
        System.out.println(md5("liubei", "liubei"));
//        System.out.println(getUuid());
//        System.out.println(getUuid());
//        System.out.println(getUuid());
        //       System.out.println(verificationCode());

        //System.out.println(getNotRepeatingFilename("123.jpg"));

    }

}
