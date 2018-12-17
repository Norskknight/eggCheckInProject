package controller;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminUserPage", urlPatterns = { "/admin"})
public class AdminUserPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private RequestDispatcher getDispatcher(HttpServletRequest req, HttpServletResponse resp){

        GenericDAO<User> dao = new GenericDAO<User>(User.class);
        List<User> users = dao.getAll();
        req.setAttribute("users", users);
        logger.info("sending users");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin" + ".jsp");
        return dispatcher;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getDispatcher(req,resp);
        dispatcher.forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getDispatcher(req,resp);
        dispatcher.forward(req, resp);
    }
}
