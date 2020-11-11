package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.TestService;
import com.etc.managemeetings.service.UserService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * @Author 吕译辰
 * @Date 2020/11/10 - 14:19
 */
@Controller
public class IndexController {
    @Autowired
    private TestService testService;

    @RequestMapping("/toIndex")
    public String toIndex() {
        System.out.println("toindex");
        return "login.jsp";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws SQLException {
        String str = "";
        System.out.println("LoginServlet doGet 方法");
        String accountname = request.getParameter("accountname");
        String pwd = request.getParameter("new");
        UserService us = new UserServiceImpl();
        User user = new User();
        user.setAccount(accountname);
        user.setPwd(pwd);
        User user1 = testService.login(user);

        if (user1 != null && user1.getState() == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);
            str = "mymeetings.do";
        } else {
            request.setAttribute("msg2", "登录失败！");
            str = "login.do";
        }
        return str;
    }


}

