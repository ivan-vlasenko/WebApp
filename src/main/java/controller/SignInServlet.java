package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static model.UserDao.loginDao;

@WebServlet(urlPatterns = "/sign-in")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.isEmpty() || password.isEmpty()) {
            response.sendRedirect("sign.jsp");
        } else {

            if (loginDao(login, password)) {
                response.sendRedirect("index.html?login="+login);
            } else {
                response.sendRedirect("sign.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sign.jsp");
        dispatcher.forward(request, response);
    }
}
