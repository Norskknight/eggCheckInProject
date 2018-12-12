package controller;

import entity.Role;
import entity.User;
import persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;

import java.io.IOException;


@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )

public class SignUpUser extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setId(1);
        user.setUserName(req.getParameter("userName"));
        user.setUserPass(req.getParameter("userPass"));
        logger.debug("Adding User: " + user);
        Role role = new Role();
        role.setUser(user);
        role.setName("user");
        user.addRole(role);

        GenericDAO<User> userDao = new GenericDAO<User>(User.class);
        int userid = userDao.create(user);
        logger.debug("user ID: " + userid);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
