package com.etc.managemeetings.test;

import com.etc.managemeetings.entity.User;

/**
 * @author 吕译辰
 * @date 2020/10/24 - 10:15
 */
public class Test {
    public void a(User user){
        System.out.println("a 方法的user地址: " + user);
    }
    public void b(){
        User user = new User();
        System.out.println("b 方法的user地址: " + user);
        a(user);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.b();//可见 a 方法的形参 只是将b方法创建的对象的地址传过去了。。
    }
}
