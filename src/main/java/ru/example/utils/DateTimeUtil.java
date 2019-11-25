package ru.example.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtil {

    private static SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    private static SimpleDateFormat target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Timestamp convertDateTime(LocalDateTime localDateTime) {
        Date dateTemp = new Date(0000000000);
        Date date = new Date(000000000);
        try {
            dateTemp = original.parse(localDateTime.toString());
            String formatted = target.format(dateTemp);
            date = target.parse(formatted);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(date.getTime());
    }

    public static long getTimeInLongFromLocalDateTime(LocalDateTime localDateTime) {
        Date date = new Date(000000000);
        try {
            date = original.parse(localDateTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static long getTimeDifference(long finish, long start) {
        return finish - start;
    }

    public static long countTimeStep(long time, int n) {
        return time / n;
    }

    public static Timestamp convertLongToTimeStamp(long time) {
        return new Timestamp(time);
    }


}
