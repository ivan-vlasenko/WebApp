package controller;

import dao.UserDao;
import model.user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    private static final String EMPTY_ERROR_MESSAGE = "All fields must be filled!";
    private static final String EXIST_ERROR_MESSAGE = "Such login or email is already exist!";

    private static final String EXIST_ERROR = "existError";
    private static final String EMPTY_ERROR = "emptyError";

    private static final String REGISTER_JSP = "register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute(EXIST_ERROR, null);
        session.setAttribute(EMPTY_ERROR, null);

        if (session.getAttribute("user") == null) {
            response.sendRedirect(REGISTER_JSP);
        } else {
            response.sendRedirect("account.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        session.setAttribute(EXIST_ERROR, null);
        session.setAttribute(EMPTY_ERROR, null);

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute(EMPTY_ERROR, EMPTY_ERROR_MESSAGE);
            response.sendRedirect(REGISTER_JSP);
        } else {
            User currentUser = new User(login, password, email);
            if (userDao.saveUser(currentUser)) {
                session.setAttribute("user", currentUser);
                response.sendRedirect("register-done.jsp");
            } else {
                session.setAttribute(EXIST_ERROR, EXIST_ERROR_MESSAGE);
                response.sendRedirect(REGISTER_JSP);
            }
        }
    }
}
