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
import java.util.Map;

@WebServlet(name = "updateEggs", urlPatterns = { "/updateEggs" } )
public class UpdateEggs extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("in update");

        GenericDAO<Egg> eggDAO = new GenericDAO<>(Egg.class);
        RequestDispatcher dispatcher = null;
        logger.debug(req.getParameter("id"));
        Egg egg =  eggDAO.getById(Integer.parseInt(req.getParameter("id")));
        logger.debug(req.getParameter("job"));
        if (req.getParameter("job").equals("Delete")){
            logger.debug("delete Job");
            eggDAO.delete(egg);
            String message = "egg id: "+egg.getId() + " Has been deleted";
            req.setAttribute("message" ,message);
            dispatcher = req.getRequestDispatcher("/showEggs");
        }else {
            logger.debug("update Job");

            egg.setCollectedDate(req.getParameter("date"));
            egg.setType(req.getParameter("type"));
            egg.setNotes(req.getParameter("notes"));

            eggDAO.update(egg);
            String message = egg.getId() + " Has been updated";
            logger.info(message);
            req.setAttribute("message" ,message);
            dispatcher = req.getRequestDispatcher("/showEgg?id="+req.getParameter("id"));
        }

        dispatcher.forward(req, resp);
    }
}
