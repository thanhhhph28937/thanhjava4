package com.example.assignment.controller;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.VideoServletJPaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search",urlPatterns = {"/search"})
public class Search extends HttpServlet {
    VideoService videoService;

    @Override
    public void init() throws ServletException {
        super.init();
        videoService=new VideoServletJPaImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword=req.getParameter("keyword");
        List<Video> list=videoService.search(keyword);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/view/home.jsp").forward(req,resp);

    }
}
