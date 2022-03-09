package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lixu
 * @create 2022-03-08-15:49
 */
@WebFilter(filterName = "characterFilter",urlPatterns = {"/sys/*"})
public class characterFilter implements Filter {
    public void destroy() {
        System.out.println("销毁characterFilter");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpServletRequest request = (HttpServletRequest)req;
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            //可能会影响之后的Json数据传输
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script language=javascript>alert('请先登录！');window.location='"+request.getContextPath()+"/login.jsp'</script>");
            chain.doFilter(req, resp);
        }
        System.out.println("filter执行前");
        chain.doFilter(req, resp);
        System.out.println("filter执行后");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化characterFilter");
    }

}
