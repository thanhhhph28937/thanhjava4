package com.example.assignment.controller;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import com.example.assignment.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/signup.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u=new User();
        u.setId(req.getParameter("id"));
        u.setPassword(req.getParameter("password"));
        u.setFullname(req.getParameter("fullname"));
        u.setEmail(req.getParameter("email"));
        for (User x:
             userService.getall()) {
            if(x.getId().equals(req.getParameter("id"))) {
                req.setAttribute("mes", "Trung id moi nhap lai");
                req.getRequestDispatcher("/view/account/signup.jsp").forward(req, resp);
                return;
            }
        }

        userService.signup(u);
        req.setAttribute("mes","Tao tai khoan thanh cong");
        req.getRequestDispatcher("/view/account/signup.jsp").forward(req,resp);

    }
}
