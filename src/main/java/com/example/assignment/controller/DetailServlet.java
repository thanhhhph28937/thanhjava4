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

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    VideoService videoService;

    @Override
    public void init() throws ServletException {
        super.init();
        videoService=new VideoServletJPaImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video video = videoService.findById(id);
//        videoService.click(id);
        req.setAttribute("video", video);
        req.setAttribute("item",videoService.thich(id));
        req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);
    }
}
