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


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private static final String EMPTY_ERROR_MESSAGE = "All fields must be filled!";
    private static final String EXIST_ERROR_MESSAGE = "Such login or email is already exist!";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("existError", null);
        session.setAttribute("emptyError", null);

        if (session.getAttribute("user") == null) {
            response.sendRedirect("register.jsp");
        } else {
            response.sendRedirect("account.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        session.setAttribute("existError", null);
        session.setAttribute("emptyError", null);

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute("emptyError", EMPTY_ERROR_MESSAGE);
            response.sendRedirect("register.jsp");
        } else {
            User currentUser = new User(login, password, email);
            if (UserDao.saveUser(currentUser)) {
                session.setAttribute("user", currentUser);
                response.sendRedirect("register-done.jsp");
            } else {
                session.setAttribute("existError", EXIST_ERROR_MESSAGE);
                response.sendRedirect("register.jsp");
            }
        }
    }
}
