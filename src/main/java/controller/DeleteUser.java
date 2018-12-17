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

@WebServlet(name = "DeleteUser", urlPatterns = { "/deleteUser"} )
public class DeleteUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDAO = new GenericDAO<>(User.class);
        logger.info("In Delete User");
        int userID = Integer.parseInt(req.getParameter("userid"));
        logger.debug("Got user ID " + userID);
        User user = userDAO.getById(userID);
        logger.debug("deleting user" + user.getUserName());

        userDAO.delete(user);
        String message = user.getUserName() + " Has been deleted";
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");
        req.setAttribute("message", message);
        req.setAttribute("method", "GET");


        dispatcher.forward(req, resp);

    }



}
