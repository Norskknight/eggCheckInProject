package controller;

import entity.Role;
import entity.User;
import persistence.GenericDAO;

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
        user.setUserName(req.getParameter("userName"));
        user.setUserPass(req.getParameter("password"));
        logger.info("Adding User: " + user);
        Role role = new Role();
        role.setUser(user);
        role.setName("user");
        user.addRole(role);

        GenericDAO<User> userDao = new GenericDAO<User>(User.class);
        userDao.create(user);
    }
}
