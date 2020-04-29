package cn.edu.cdu.wxs.uiaipms.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

/**
 * 日期 工具类
 *
 * @author WXS
 * @date 2020/4/29
 */
public class DateUtils {

    /**
     * 获取一段时间内的每一天日期
     *
     * @param rangeDate 范围日期
     * @return 集合
     */
    public static List<LocalDate> getBetweenDate(String rangeDate) {
        List<LocalDate> data = new ArrayList<>();

        String[] date = dealRangeDate(rangeDate);

        LocalDate startDate = LocalDate.parse(date[0]);
        LocalDate endDate = LocalDate.parse(date[1]);

        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return data;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> data.add(f));
        return data;
    }

    /**
     * 获取一段时间内每一天的开始时间和结束时间
     *
     * @param rangeDate 范围日期
     * @return K:开始时间 V:结束时间
     */
    public static Map<String, String> getStartAndEndOfDay(String rangeDate) {
        List<LocalDate> dates = getBetweenDate(rangeDate);

        Map<String ,String> data = new TreeMap<>();

        for (LocalDate localDate : dates) {
            data.put(getStartOfDay(localDate).toString().replace("T"," "), getEndOfDay(localDate).toString().replace("T"," "));
        }

        return data;
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
     * 处理范围日期
     * @param rangeDate 范围日期
     * @return 数组
     */
    public static String[] dealRangeDate(String rangeDate){
         return rangeDate.replace(" ", "").split("~");
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

    public static void main(String[] args) {
        Map<String, String> dates = getStartAndEndOfDay("2020-04-17 ~ 2020-05-11");
        System.out.println(dates);
    }
}
