package com.cqyb.music.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/28 17:33
 * @Description:
 */
public class MyDateUtils {
    /**
     * 获取重置指定日期的时分秒后的时间
     *
     * @param date
     *            指定日期
     * @param hour
     *            指定小时
     * @param minute
     *            指定分钟
     * @param second
     *            指定秒
     * @return 返回重置时分秒后的时间
     */
    public static Date getResetTime(Date date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, minute);
        cal.set(Calendar.MINUTE, second);
        return cal.getTime();
    }

    /**
     * 返回指定日期的起始时间
     *
     * @param date
     *            指定日期（例如2014-08-01）
     * @return 返回起始时间（例如2014-08-01 00:00:00）
     */
    public static Date getIntegralStartTime(Date date) {
        return getResetTime(date, 0, 0, 0);
    }

    /**
     * 返回指定日期的结束时间
     *
     * @param date
     *            指定日期（例如2014-08-01）
     * @return 返回结束时间（例如2014-08-01 23:59:59）
     */
    public static Date getIntegralEndTime(Date date) {
        return getResetTime(date, 23, 59, 59);
    }
}
