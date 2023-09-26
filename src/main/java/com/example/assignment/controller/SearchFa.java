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

@WebServlet(name = "SearchFa",urlPatterns = {"/tim"})
public class SearchFa extends HttpServlet {
    VideoService videoService;

    @Override
    public void init() throws ServletException {
        super.init();
        videoService=new VideoServletJPaImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String keyword = req.getParameter("keyword");
        if(keyword == null) keyword = "";

        System.out.println("In favorite, keyword=" + keyword);
        String username = (String) req.getSession().getAttribute("username");
        if(username == null) {
            resp.sendRedirect("login");
            return;
        }
        List<Video> list=videoService.searchFavorite(username,keyword);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/view/favorite.jsp").forward(req,resp);
    }
}
