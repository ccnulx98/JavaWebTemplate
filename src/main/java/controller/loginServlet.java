package controller;

import beans.user1;
import org.apache.commons.beanutils.BeanUtils;
import service.Impl.user1ServiceImpl;
import service.user1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author lixu
 * @create 2022-03-08-17:06
 */
@WebServlet(name = "loginServlet",urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String code = request.getParameter("verification");
        String VerificateKey = (String) request.getSession().getAttribute("CODE");
        if (VerificateKey!=null){
            if (!VerificateKey.equalsIgnoreCase(code)){
                request.getSession().removeAttribute("CODE");
                response.getWriter().write("<script language=javascript>alert('验证码错误！');window.location='"+request.getContextPath()+"/login.jsp'</script>");
                return;
            }
            else
                request.getSession().removeAttribute("CODE");
        }
        else{
            System.out.println("window.location='"+request.getContextPath()+"/login.jsp'");
            response.getWriter().write("<script language=javascript>alert('验证码过期，请刷新验证码！');window.location='"+request.getContextPath()+"/login.jsp'</script>");
            return;
        }
//        beanutils 封装测试
//        (bean: set方法, 属性名跟 表单的name属性值一致)
        Map<String, String[]> mmap = request.getParameterMap();
        user1 u1 = new user1();
        try {
            BeanUtils.populate(u1,mmap);
            System.out.println(u1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        user1Service uService = new user1ServiceImpl();
        user1 u = uService.findOneUser(2);

        if (u!=null){
            System.out.println(u);
            request.getSession().setAttribute("user",u);
//            request.getRequestDispatcher("/table?limit=5&nowPage=1").forward(request,response);
            request.getRequestDispatcher("/sys/success.jsp").forward(request,response);
        }
        else{
//                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            response.getWriter().write("<script language=javascript>alert('用户名不存在或密码错误！');window.location='"+request.getContextPath()+"/login.jsp'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
