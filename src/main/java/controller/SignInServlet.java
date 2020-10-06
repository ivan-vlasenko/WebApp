package controller;

import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("empty", null);
        session.setAttribute("wrong", null);

        if (session.getAttribute("log") == null) {
            response.sendRedirect("sign-page.jsp");
        } else {
            response.sendRedirect("account.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("empty", null);
        session.setAttribute("wrong", null);

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            String empty = "Login, password or email is empty!";
            session.setAttribute("empty", empty);
            response.sendRedirect("sign-page.jsp");
        } else {
            if (UserDao.login(login, password, email)) {
                session.setAttribute("log", login);
                session.setAttribute("pass", password);
                session.setAttribute("email", email);
                response.sendRedirect("index.jsp");
            } else {
                String wrong = "Login or password is invalid!";
                session.setAttribute("wrong", wrong);
                response.sendRedirect("sign-page.jsp");
            }
        }
    }
}
