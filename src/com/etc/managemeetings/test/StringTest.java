package com.etc.managemeetings.test;

import java.text.ParseException;

public class StringTest {
    public static void main(String[] args) throws ParseException {
        String sql = "  update CONFERENCEROOM c set c.HOUSENO =  'oldhouseno'  where HOUSENO = 'oldhouseno'  ";
        sql = sql.replace("set","SET");//替换字符串
        System.out.println(sql);
    }
}
