package com.common.utils.date;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author keven
 * @date 2018-04-30 下午10:10
 * @Description 日期 工具类
 */
@Slf4j
public class DateUtil {


    /**
     * 计算二个 日期 相差的天数
     */
    public static Long compareDayNum(Date begin, Date end) {
        Long days = 0L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String oldDay = simpleDateFormat.format(begin);
        String newDay = simpleDateFormat.format(end);
        try {
            Date beginDate = simpleDateFormat.parse(oldDay);
            Date endDate = simpleDateFormat.parse(newDay);
            return (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.getMessage();
        }
        return days;
    }


    /**
     * 在 date 的基础 上 添加 day 天
     */
    public static Date addDay(Date date, Integer day) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.add(Calendar.DATE, day);
        return todayEnd.getTime();
    }

}
