package controller;

import utils.verification_code_generate1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lixu
 * @create 2021-12-28-10:38
 */
@WebServlet(name = "verificationImgGenerateServlet",urlPatterns = {"/verificationImg"})
public class verificationImgGenerateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        System.out.println("访问");
        //生成随机字串
        String verifyCode = verification_code_generate1.generateVerifyCode(4);
        //存入会话session
        request.getSession().setAttribute("CODE", verifyCode.toLowerCase());

        //生成图片
        int width = 100;//宽
        int height = 40;//高
        verification_code_generate1.outputImage(width, height, response.getOutputStream(), verifyCode);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
