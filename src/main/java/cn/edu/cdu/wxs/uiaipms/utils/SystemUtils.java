package cn.edu.cdu.wxs.uiaipms.utils;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * 获取当前登录用户的用户名
     *
     * @param session 会话
     * @return id
     */
    public static String getUsernameFromSession(HttpSession session, String userId) {

        return ((Map<String, String>) session.getAttribute(userId)).get(GlobalConstant.USERNAME);
    }

    /**
     * 获取当前登录用户的用户名
     *
     * @param session 会话
     * @return id
     */
    public static String getImageFromSession(HttpSession session, String userId) {

        return ((Map<String, String>) session.getAttribute(userId)).get(GlobalConstant.USER_IMAGE);
    }


    /**
     * 处理统计数据
     *
     * @param statisticsData 统计数据
     * @return 格式化结果集合
     */
    public static List<TreeMapModel> dealStatisticsData(List<StatisticsModel> statisticsData) {
        List<TreeMapModel> list = new ArrayList<>();

        Map<String, Integer> total = new TreeMap<>();

        // 统计每天的总量
        statisticsData.forEach(x -> {
            if (total.containsKey(x.getDate())) {
                total.put(x.getDate(), total.get(x.getDate()) + x.getNum());
            } else {
                total.put(x.getDate(), x.getNum());
            }
        });

        // 将每天的总量作为父节点
        total.forEach((k, v) -> {
            TreeMapModel treeMapModel = new TreeMapModel();
            treeMapModel.setName(k);
            treeMapModel.setValue(v);
            treeMapModel.setChildren(new ArrayList<>());
            list.add(treeMapModel);
        });
        // 为每个父节点设置其子节点
        for (StatisticsModel s : statisticsData) {
            for (TreeMapModel t: list) {
                if (s.getDate().equals(t.getName())) {
                    TreeMapModel treeMapModel = new TreeMapModel();
                    treeMapModel.setName(s.getName());
                    treeMapModel.setValue(s.getNum());
                    t.getChildren().add(treeMapModel);
                }
            }
        }
        return list;
    }


    /**
     * 将日期字符串转换成日起对象
     *
     * @param date 日期字符串
     * @return 日起对象
     */
    public static LocalDate stringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return StringUtils.isEmpty(date) ? LocalDate.now() : LocalDate.parse(date, formatter);
    }

    /**
     * 重设session里的昵称、头像
     *
     * @param session  会话
     * @param nickname 昵称
     * @param image    头像地址
     * @param userId   用户id
     */
    public static void reset(HttpSession session, String nickname, String image, String userId) {
        if (!StringUtils.isEmpty(nickname)) {
            ((Map<String, String>) session.getAttribute(userId)).put(GlobalConstant.USER_NICKNAME, nickname);
        }
        if (!StringUtils.isEmpty(image)) {
            ((Map<String, String>) session.getAttribute(userId)).put(GlobalConstant.USER_IMAGE, image);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i<30; i++) {
            System.out.println(getUuid());
        }

    }

}
