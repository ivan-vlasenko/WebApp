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
public class RegistrationServlet extends HttpServlet {
    private static final String EMPTY_ERROR_MESSAGE = "All fields must be filled!";
    private static final String EXIST_ERROR_MESSAGE = "Such login or email is already exist!";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("existError", null);
        session.setAttribute("emptyError", null);

        if (session.getAttribute("user") == null) {
            response.sendRedirect("registration-page.jsp");
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

        boolean status;

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute("emptyError", EMPTY_ERROR_MESSAGE);
            response.sendRedirect("registration-page.jsp");
        } else {
            User user = new User(login, password, email);
            status = UserDao.saveUser(user);
            if (status) {
                session.setAttribute("user", user);
                response.sendRedirect("registration-done-page.jsp");
            } else {
                session.setAttribute("existError", EXIST_ERROR_MESSAGE);
                response.sendRedirect("registration-page.jsp");
            }
        }
    }
}
