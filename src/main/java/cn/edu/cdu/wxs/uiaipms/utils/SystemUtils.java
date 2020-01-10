package cn.edu.cdu.wxs.uiaipms.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 系统工具类
 *
 * @author WXS
 * @date 2020/1/10
 */
public class SystemUtils {

    /**
     * 判断一个数是否大于0
     * @param number 数字
     * @return true 大于，false 不大于
     */
    public static boolean gtTheZero(int number) {
        return number > 0 ;
    }

    /**
     * 用户密码加密，采用Md5Hash 加密
     * @param str 密码
     * @param salt 盐
     * @return 加密的密码
     */
    public static String md5(String str, String salt) {
        // 加密次数
        final int hashIterations = 1024;
        Md5Hash md5Hash = new Md5Hash(str ,salt, hashIterations);
        return md5Hash.toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("zhangsan", "zhangsan"));
    }

}
