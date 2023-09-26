package com.example.assignment.controller;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.VideoServletJPaImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

@MultipartConfig
@WebServlet("/crud/*") // /crud/list, /crud/new, /crud/edit, /crud/create, /crud/update, /crud/delete
public class CRUDServlet extends HttpServlet {
    VideoService videoService;
    private static final String UPLOAD_DIR = "uploads"; // Thay đổi đường dẫn tùy theo thư mục lưu trữ


    @Override
    public void init() throws ServletException {
        super.init();
        videoService=new VideoServletJPaImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("list")) {
            listVideo(req, resp);
        }else if(uri.contains("new")) {
            newVideo(req, resp);
        }else if(uri.contains("edit")) {
            editVideo(req, resp);
        }else if(uri.contains("delete")) {
            deleteVideo(req, resp);
        }
    }

    void listVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", videoService.findAll());
        req.getRequestDispatcher("/view/crud/list.jsp").forward(req, resp);
    }

    void newVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/crud/create.jsp").forward(req, resp);
    }

    void editVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("video", videoService.findById(id));
        req.getRequestDispatcher("/view/crud/update.jsp").forward(req, resp);
    }

    protected void deleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id=req.getParameter("id");
          videoService.deleteById(id);
          resp.sendRedirect("list");




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("create")) {
            createVideo(req, resp);
        }else if(uri.contains("update")) {
            updateVideo(req, resp);
        }


    }

    String saveFile(HttpServletRequest req) throws IOException, ServletException {
//        File dir = new File(req.getServletContext().getRealPath("/files"));
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//
//        Part poster = req.getPart("poster_file");
//        System.out.println("filename:" + poster.getSubmittedFileName());
//
//        if(poster != null && !poster.getSubmittedFileName().isEmpty()) {
//            File posterFile = new File(dir, poster.getSubmittedFileName());
//            poster.write(posterFile.getAbsolutePath());
//
//            return poster.getSubmittedFileName();
//        }
//
//        return null;
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part filePart = req.getPart("poster_file");
        String fileName = getFileName(filePart);
        String filePath = uploadPath + File.separator + fileName;
        System.out.println(fileName+"sss"+filePath);
        filePart.write(filePath);

           return fileName;

    }
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {

                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    void createVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();
        try {
            BeanUtils.populate(video, req.getParameterMap());
            video.setPoster(saveFile(req));

            videoService.add(video);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("video", video);
            req.setAttribute("message", "Fail to add video");
            req.getRequestDispatcher("/view/crud/create.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("list");
    }


    void updateVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();
        try {
            BeanUtils.populate(video, req.getParameterMap());

            video.setPoster(saveFile(req));

            videoService.update(video);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("video", video);
            req.setAttribute("message", "Fail to update video");
            req.getRequestDispatcher("/view/crud/update.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("list");
    }
}
