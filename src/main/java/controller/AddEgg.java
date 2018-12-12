package controller;


import entity.Egg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "SignUpUser", urlPatterns = { "/addEgg" } )
public class AddEgg extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Egg egg = new Egg();
        egg.setCollectedDate(req.getParameter("date"));
        egg.setType(req.getParameter("type"));
        logger.debug(req.getSession().getAttributeNames());
        //egg.setUser();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/eggForm.jsp");
        dispatcher.forward(req, resp);
    }
}
