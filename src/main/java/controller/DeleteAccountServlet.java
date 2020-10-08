package controller;

import model.user.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns ="/delete")
public class DeleteAccountServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        } else {
            User currentUser = (User) session.getAttribute("user");
            if (userDao.deleteUser(currentUser)) {
                session.setAttribute("user", null);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("account.jsp");
            }
        }
    }
}
