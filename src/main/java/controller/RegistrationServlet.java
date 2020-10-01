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
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("emptyRegMessage", null);
        session.setAttribute("alreadyExistMessage", null);

        if (session.getAttribute("log") == null) {
            response.sendRedirect("registration-page.jsp");
        } else {
            session.setAttribute("regCount", null);
            response.sendRedirect("account.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("emptyRegMessage", null);
        session.setAttribute("alreadyExistMessage", null);

        AtomicInteger tryCount = (AtomicInteger) session.getAttribute("regCount");
        int attemptCount = tryCount.getAndDecrement();
        int status = 0;

        if (attemptCount > 0) {
            if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
                String emptyRegMessage = "All fields must be filled! " + attemptCount + " attempts left!";
                session.setAttribute("emptyRegMessage", emptyRegMessage);
                response.sendRedirect("registration-page.jsp");
            } else {
                User user = new User(login, password, email);
                status = UserDao.save(user);
                if (status > 0) {
                    session.setAttribute("log", login);
                    session.setAttribute("pass", password);
                    session.setAttribute("email", email);
                    session.setAttribute("regCount", new AtomicInteger(5));
                    session.setAttribute("signCount", new AtomicInteger(5));
                    response.sendRedirect("registration-done-page.jsp");
                } else {
                    String alreadyExistMessage = "Such login or email is already exist! " + attemptCount + " attempts left!";
                    session.setAttribute("alreadyExistMessage", alreadyExistMessage);
                    response.sendRedirect("registration-page.jsp");
                }
            }
        } else {
            response.sendRedirect("attempts-left.jsp");
        }
    }
}
