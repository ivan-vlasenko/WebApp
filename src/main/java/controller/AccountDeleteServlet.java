package controller;

import entity.user.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns ="/delete")
public class AccountDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("log") == null) {
            response.sendRedirect("sign-page.jsp");
        } else {
            boolean status = false;

            String log = (String) session.getAttribute("log");
            String pass = (String) session.getAttribute("pass");
            String email = (String) session.getAttribute("email");

            User user = new User();
            user.setLogin(log);
            user.setPassword(pass);
            user.setEmail(email);

            status = UserDao.deleteUser(user);
            if (status) {
                session.setAttribute("log", null);
                session.setAttribute("pass", null);
                session.setAttribute("email", null);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("account.jsp");
            }
        }
    }
}
