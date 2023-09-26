package com.example.assignment.controller;

import com.example.assignment.entity.Video;
import com.example.assignment.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    VideoService videoService;

    @Override
    public void init() throws ServletException {
        super.init();
        videoService=new VideoServletJPaImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        List<Video> list=videoService.findAll();
//        List<Video> items = videoService.search(keyword);

        req.setAttribute("requestURI", req.getRequestURI());
//        req.setAttribute("items", items);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
    }



}
