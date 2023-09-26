package com.example.assignment.controller;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import com.example.assignment.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;


@WebServlet("/quenmk")
public class QuenmkServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/quenmk.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = "thanhhandsome2507@gmail.com";
        final String password = "nkdzjihrszevotlb";

        // Cài đặt thông số kết nối
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Thay thế bằng máy chủ SMTP của bạn
        props.put("mail.smtp.port", "587"); // Port SMTP

        // Tạo một phiên gửi email với thông tin xác thực
        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new javax.mail.PasswordAuthentication(username,password);
            }
        });
        for (User x:
             userService.getall()) {
            if(!x.getEmail().equals(req.getParameter("email"))){
                req.setAttribute("mes","Email khong hop le");
                req.getRequestDispatcher("/view/account/quenmk.jsp").forward(req, resp);
                return;

            }
        }
        User u=userService.getpass(req.getParameter("email"));
        try {
            // Tạo tin nhắn email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(req.getParameter("email"))); // Địa chỉ email người nhận
            message.setSubject("Tiêu đề email");
            message.setText(u.getPassword());

            // Gửi email
            Transport.send(message);

            req.setAttribute("mes","Gui thanh cong");
            req.getRequestDispatcher("/view/account/quenmk.jsp").forward(req, resp);
        } catch (MessagingException e) {
            e.printStackTrace();
            req.setAttribute("mes","Gui that bai");
            req.getRequestDispatcher("/view/account/quenmk.jsp").forward(req, resp);

        }

    }
}
