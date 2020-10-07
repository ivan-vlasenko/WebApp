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

@WebServlet(urlPatterns = "/edit")
public class EditAccountServlet extends HttpServlet {
    private static final String EDIT_ERROR_MESSAGE = "You didn't change any field!";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String newLogin = request.getParameter("newLogin");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("newEmail");

        if (user.getLogin().equalsIgnoreCase(newLogin)
                && user.getPassword().equalsIgnoreCase(newPassword)
                && user.getEmail().equalsIgnoreCase(newEmail)) {

            session.setAttribute("editError", EDIT_ERROR_MESSAGE);
            response.sendRedirect("edit.jsp");
        } else {
            if (UserDao.updateUser(user, newLogin, newPassword, newEmail)) {
                session.setAttribute("user", new User(newLogin, newPassword, newEmail));
                response.sendRedirect("account.jsp");
            } else {
                response.sendRedirect("edit.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("edit.jsp");
    }
}
