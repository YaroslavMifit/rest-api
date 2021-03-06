package com.example.restapi.service.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateSearchUtils {

    public static Date atStartOfDay(Date date){
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfday = localDateTime.with(LocalDateTime.MIN);
        return localDateTimeToDate(startOfday);
    }

    public static Date atEndOfDay(Date date){
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    private static LocalDateTime dateToLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date localDateTimeToDate (LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
