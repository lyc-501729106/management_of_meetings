package com.etc.managemeetings.controller;

import com.etc.managemeetings.service.DepartmentService;
import com.etc.managemeetings.service.Impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelDepartmentServ",urlPatterns = "/DelDepartmentServ")
public class DelDepartmentServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DelDepartmentServ post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DelDepartmentServ get");
        String name = request.getParameter("name");
        System.out.println(name);
        DepartmentService ds = new DepartmentServiceImpl();
        try {
            ds.delDepartment(name);
            request.getRequestDispatcher("departments.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
