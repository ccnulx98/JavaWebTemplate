package controller;

import beans.user1;
import service.Impl.user1ServiceImpl;
import service.user1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixu
 * @create 2022-03-02-19:24
 */
@WebServlet(name = "firstTest",urlPatterns = {"/firstTest"})
public class firstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        user1Service usi = new user1ServiceImpl();
        List<user1> alluser = usi.findAlluser();
        response.getWriter().write(alluser.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
