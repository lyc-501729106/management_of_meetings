package com.etc.managemeetings.util;


import java.io.UnsupportedEncodingException;

public class Code {
    public static String Utf8(String oldname) throws UnsupportedEncodingException {
        String newname = new String(oldname.getBytes("iso-8859-1"), "utf-8");
        return newname;
    }
}
