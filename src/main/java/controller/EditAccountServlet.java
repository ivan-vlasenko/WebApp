package controller;

import model.user.User;
import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditAccountServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final String EDIT_ERROR_MESSAGE = "You didn't change any field!";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        String updateLogin = request.getParameter("updateLogin");
        String updatePass = request.getParameter("updatePass");
        String updateEmail = request.getParameter("updateEmail");

        if (currentUser.getLogin().equalsIgnoreCase(updateLogin)
                && currentUser.getPassword().equalsIgnoreCase(updatePass)
                && currentUser.getEmail().equalsIgnoreCase(updateEmail)) {

            session.setAttribute("editError", EDIT_ERROR_MESSAGE);
            response.sendRedirect("edit.jsp");
        } else {
            if (userDao.updateUser(currentUser, updateLogin, updatePass, updateEmail)) {
                session.setAttribute("user", new User(updateLogin, updatePass, updateEmail));
                response.sendRedirect("account.jsp");
            } else {
                response.sendRedirect("edit.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }
}
