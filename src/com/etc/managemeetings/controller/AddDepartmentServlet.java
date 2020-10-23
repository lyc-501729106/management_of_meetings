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

@WebServlet(name = "AddDepartmentServlet",urlPatterns = "/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddDepartmentServlet POST 方法");
        String department = request.getParameter("departmentname");
        System.out.println(department);
        DepartmentService ds = new DepartmentServiceImpl();
        try {
            ds.addDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("addDepartmentOK","部门添加成功");
        request.getRequestDispatcher("departments.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
