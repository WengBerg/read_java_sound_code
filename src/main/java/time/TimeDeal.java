package time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * java8 日期处理学习
 */
public class TimeDeal {

    /**
     * 时区转换测试类
     */
    @Test
    public void test1() {

        /**
         * 首先固定一个不带任何时区的时间
         * 把这个时间加上需要的时区，就标识这个时间就是该时区的
         * 把带时区的时间转换成 目标 时区
         */
        String UTCTImeStr = "2018-06-20 12:22:34.8";
        // 设置格式化类型
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime dateTime = LocalDateTime.parse(UTCTImeStr, formatter);
        //设置时区
        ZonedDateTime timeTest = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        // 设置转换时区
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        //时区转换
        ZonedDateTime zonedDateTime = timeTest.withZoneSameLocal(zoneId);
        String format = zonedDateTime.format(formatter);
        System.out.println(format);
    }
}
