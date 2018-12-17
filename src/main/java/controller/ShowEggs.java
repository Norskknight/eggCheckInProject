package controller;

import entity.Egg;
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
import java.util.Set;

@WebServlet(name = "showEggs", urlPatterns = { "/showEggs" } )
public class ShowEggs extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showEggsWork(req, resp);
        return;
    }

    private void showEggsWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("In Show Eggs Servlet");
        GenericDAO<User> userDao = new GenericDAO<User>(User.class);
        GenericDAO<Egg> eggDao = new GenericDAO<Egg>(Egg.class);
        logger.debug("user name "+req.getRemoteUser());
        List<User> users = userDao.findByPropertyEqual("userName", req.getRemoteUser());
        logger.debug("users "+users);
        User user = users.get(0);
        logger.debug("Got User " + user.getUserName());
        Set<Egg> eggs = user.getEggs();
        logger.info("configure dates");
        for (Egg egg:eggs) {

            egg.setTwoWeeks(egg.generateNextDate(14));
            egg.setFiveWeeks(egg.generateNextDate(35));
        }

        req.setAttribute("eggs", eggs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/notes" + ".jsp");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showEggsWork(req, resp);
    }
}
