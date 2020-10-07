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

@WebServlet(urlPatterns ="/delete")
public class DeleteAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean status;
        User currentUser;

        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        } else {
            currentUser = (User) session.getAttribute("user");
            status = UserDao.deleteUser(currentUser);
            if (status) {
                session.setAttribute("user", null);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("account.jsp");
            }
        }
    }
}
