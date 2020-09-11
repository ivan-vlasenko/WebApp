package controller;

import entity.User;
import model.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static model.UserDao.save;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        int status = 0;

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            response.sendRedirect("/registration.jsp");
        } else {
            User user = new User(login, password, email);
            status = save(user);
            if (status > 0) {
                response.sendRedirect("/account.jsp?login="+login);
            }
        }
    }
}
