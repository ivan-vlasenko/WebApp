package controller;

import entity.User;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static model.UserDao.save;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("emptyRegMessage", null);
        session.setAttribute("alreadyExistMessage", null);

        if (session.getAttribute("log") == null) {
            response.sendRedirect("registration-page.jsp");
        } else {
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

        int status = 0;

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            session.setAttribute("emptyRegMessage", "All fields must be filled!");
            response.sendRedirect("registration-page.jsp");
        } else {
            User user = new User(login, password, email);
            status = save(user);
            if (status > 0) {
                session.setAttribute("log", login);
                session.setAttribute("pass", password);
                session.setAttribute("email", email);
                response.sendRedirect("registration-done-page.jsp");
            } else {
                session.setAttribute("alreadyExistMessage", "Such login or email is already exist. Try again.");
                response.sendRedirect("registration-page.jsp");
            }
        }
    }
}
