package com.example.assignment.controller;

import com.example.assignment.service.UserService;
import com.example.assignment.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
     UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userService.checkUser(username, password)==true){
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("home");
            return;
        }
        req.setAttribute("message", "Incorrect username/password");
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }
}
