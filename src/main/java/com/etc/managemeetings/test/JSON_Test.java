/*
package com.etc.managemeetings.test;

import com.etc.managemeetings.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;


public class JSON_Test {
    public static void main(String[] args) {
        //JSON转换为集合
        String userStr =  "[{\"name\":\"Jack\",\"age\":\"24\" } , {\"name\":\"Hellen\",\"age\":\"20\"}]";
        JSONArray jsonArray = JSONArray.fromObject(userStr);
        List<User> userList = (List<User>) JSONArray.toCollection(jsonArray,User.class);
        //JSON转换为对象
        userStr =  "{\"name\":\"Jack\",\"age\":\"24\" } ";
        JSONObject userobject = JSONObject.fromObject(userStr);
        User users = (User) JSONObject.toBean(userobject,User.class);

        for (User u :
                userList) {
            System.out.println(u.getName());
        }
        System.out.println(users.toString());
        //将对象转换为 JSON数据格式
        User user = new User();
        user.setName("rose");
        JSONObject jsonObject = JSONObject.fromObject(user);
        System.out.println(jsonObject.toString());
    }
}
*/
