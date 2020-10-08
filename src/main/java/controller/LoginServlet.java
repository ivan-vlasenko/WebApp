package controller;

import model.user.User;
import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(urlPatterns = "/sign-in")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    private static final String EMPTY_ERROR_MESSAGE = "All fields must be filled!";
    private static final String INVALID_ERROR_MESSAGE = "Login or password is invalid!";

    private static final String EMPTY_ERROR = "empty";
    private static final String INVALID_ERROR = "invalid";

    private static final String LOGIN_JSP = "login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute(EMPTY_ERROR, null);
        session.setAttribute(INVALID_ERROR, null);

        if (session.getAttribute("user") == null) {
            response.sendRedirect(LOGIN_JSP);
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

        session.setAttribute(EMPTY_ERROR, null);
        session.setAttribute(INVALID_ERROR, null);

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute(EMPTY_ERROR, EMPTY_ERROR_MESSAGE);
            response.sendRedirect(LOGIN_JSP);
        } else {
            User currentUser = new User(login, password, email);
            if (userDao.login(currentUser)) {
                session.setAttribute("user", currentUser);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute(INVALID_ERROR, INVALID_ERROR_MESSAGE);
                response.sendRedirect(LOGIN_JSP);
            }
        }
    }
}
