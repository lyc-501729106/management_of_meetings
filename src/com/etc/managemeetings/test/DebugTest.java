package com.etc.managemeetings.test;

import java.util.HashMap;

/**
 * @author 吕译辰
 * @date 2020/10/23 - 17:39
 */
public class DebugTest {
    public static void main(String[] args) {
        HashMap<String , String> map = new HashMap<>();
        map.put("name","tom");
        map.put("age","12");
        map.put("school","Tsinghua");
        System.out.println(map.size());
    }
}
