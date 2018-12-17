package controller;

import entity.Egg;
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

@WebServlet(name = "showEgg", urlPatterns = { "/showEgg" } )
public class ShowEgg extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("show egg servlet");
        GenericDAO<Egg> eggDao = new GenericDAO<Egg>(Egg.class);
        int eggID = Integer.parseInt(req.getParameter("id"));
        logger.debug(eggID);
        Egg egg = eggDao.getById(eggID);

        req.setAttribute("egg", egg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showEgg" + ".jsp");
        dispatcher.forward(req, resp);
    }


}
