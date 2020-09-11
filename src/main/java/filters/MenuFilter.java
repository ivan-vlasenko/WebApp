package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MenuFilter", urlPatterns = "/menu")
public class MenuFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        /*PrintWriter pw = resp.getWriter();
        pw.println("<html><body><h1>Hi from Filter!!!</h1></body></html>");

        String login = req.getParameter("login");

        if (login.isEmpty()) {
            req.getServletContext().getRequestDispatcher("sign.jsp").forward(req, resp);
        }*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
