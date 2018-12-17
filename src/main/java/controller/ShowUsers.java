package controller;

import entity.User;
import persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "ShowUsers", urlPatterns = { "/totals"} )
public class ShowUsers extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDAO<User> dao = new GenericDAO<User>(User.class);
        List<User> users = dao.getAll();
        for (User user : users) {
            user.setUserPass("***");
        }
        req.setAttribute("users", users);
        logger.info("sending users");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/totals" + ".jsp");
        dispatcher.forward(req, resp);
    }
}
