package time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * java8 ���ڴ���ѧϰ
 */
public class TimeDeal {

    /**
     * ʱ��ת��������
     */
    @Test
    public void test1() {

        /**
         * ���ȹ̶�һ�������κ�ʱ����ʱ��
         * �����ʱ�������Ҫ��ʱ�����ͱ�ʶ���ʱ����Ǹ�ʱ����
         * �Ѵ�ʱ����ʱ��ת���� Ŀ�� ʱ��
         */
        String UTCTImeStr = "2018-06-20 12:22:34.8";
        // ���ø�ʽ������
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime dateTime = LocalDateTime.parse(UTCTImeStr, formatter);
        //����ʱ��
        ZonedDateTime timeTest = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        // ����ת��ʱ��
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        //ʱ��ת��
        ZonedDateTime zonedDateTime = timeTest.withZoneSameLocal(zoneId);
        String format = zonedDateTime.format(formatter);
        System.out.println(format);
    }
}
