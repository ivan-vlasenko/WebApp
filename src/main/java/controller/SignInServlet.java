package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static model.UserDao.loginDao;

@WebServlet(urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("log") == null) {
            response.sendRedirect("sign.jsp");
        } else {
            response.sendRedirect("account.jsp");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute("empty", "Login, password or email is empty!");
            response.sendRedirect("sign.jsp");
        } else {

            if (loginDao(login, password, email)) {
                session.setAttribute("log", login);
                session.setAttribute("pass", password);
                session.setAttribute("email", email);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("wrong", "Login or password is invalid!");
                response.sendRedirect("sign.jsp");
            }
        }
    }
}
