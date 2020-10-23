package com.etc.managemeetings.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Date_test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str = "2020-48-19 15:48";
        str = "2020-10-21 11:01" ;
        System.out.println(sdf.format(new Date()));
/**
 * util Date 转sql Date 的注意事项
 */
        Date  date = sdf.parse(str);
        System.out.println("date : " + date);
        java.sql.Date date1 = new java.sql.Date(date.getTime()); //会丢失时间
        System.out.println(date1);
        java.sql.Time time = new java.sql.Time(date.getTime()); //会丢失日期
        System.out.println(time);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime()); //时间戳
        System.out.println(timestamp.toString());
        System.out.println("date.toString() :" + date.toString());
        System.out.println("date.getTime() : " +date.getTime());
        System.out.println("-------------------");
        List list = new ArrayList();
    }
}
