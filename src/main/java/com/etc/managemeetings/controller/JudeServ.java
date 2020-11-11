/*
package com.etc.managemeetings.controller;

//import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "JudeServ",urlPatterns = "/JudeServ")
public class JudeServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname =  req.getParameter("uname") ;
        resp.setContentType("text/html;charset=utf-8");
        Map<String , Object> map = new HashMap<String , Object>() ;
        if(uname != null) {
            if(uname.equals("Jack")) {
                map.put("flag", true) ;
                map.put("result", "不可用") ;
            } else {
                map.put("flag", false) ;
                map.put("result", "可用") ;
            }
        }

        System.out.println(map);
        //此时需要将以上的map数据以json的格式传递到页面
        ObjectMapper om = new ObjectMapper() ;
        //使用ObjectMapper里的
        //第一次使用Ajax的时候使用的是response.getWriter
        om.writeValue(resp.getWriter(), map);
    }
}
*/
