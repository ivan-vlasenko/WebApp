package controller;

import entity.Dish;
import model.DishDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishDao dishDao = new DishDao();
        dishDao.driverRegister();
        dishDao.dataBase();
        List<Dish> dishList = dishDao.getDishes();

        PrintWriter pw = resp.getWriter();
        for (Dish dish:dishList) {
            pw.println("<html><body><h1>" + dish.toString() + "</h1></body></html>");
        }
    }
}
