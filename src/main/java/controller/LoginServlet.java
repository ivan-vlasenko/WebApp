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


@WebServlet(urlPatterns = "/sign-in")
public class LoginServlet extends HttpServlet {
    private static final String EMPTY_ERROR_MESSAGE = "Login, password or email is empty!";
    private static final String INVALID_ERROR_MESSAGE = "Login or password is invalid!";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("empty", null);
        session.setAttribute("invalid", null);

        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("account.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        session.setAttribute("empty", null);
        session.setAttribute("invalid", null);

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute("empty", EMPTY_ERROR_MESSAGE);
            response.sendRedirect("login.jsp");
        } else {
            User currentUser = new User(login, password, email);
            if (UserDao.login(currentUser)) {
                session.setAttribute("user", currentUser);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("invalid", INVALID_ERROR_MESSAGE);
                response.sendRedirect("login.jsp");
            }
        }
    }
}
