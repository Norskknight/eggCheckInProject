package controller;

import entity.Egg;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import entity.User;
import entity.ZipCodeWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;

@WebServlet(name = "addEgg", urlPatterns = { "/addEgg" } )
public class AddEgg extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDao = new GenericDAO<User>(User.class);
        GenericDAO<Egg> eggDao = new GenericDAO<Egg>(Egg.class);
        List<User> users = userDao.findByPropertyEqual("userName", req.getRemoteUser());
        Egg egg = new Egg();
        egg.setCollectedDate(req.getParameter("date"));
        egg.setType(req.getParameter("type"));

        logger.debug(req.getRemoteUser());
        logger.debug(req.getParameter("type"));
        logger.debug(req.getParameter("date"));

        User user = users.get(0);
        logger.debug(user);
        egg.setUser(user);
        ZipCodeWeather weatherData = user.getZipCodeWeather();
        String formatedNote ="The weather today is " + weatherData.getWeather() + " with the Temperature in Fahrenheit " + weatherData.tempToFahrenheit();
        egg.setNotes(formatedNote);
        Set<Egg> eggs =  user.getEggs();
        logger.debug(eggs.size());
        int id = eggDao.create(egg);

        String message = "<p>last Egg ID is : " + id
                + " <p>last Egg Type is : " + egg.getType() + "</p>"
                + " <p>last Egg Collected date is : " + egg.generateNextDate(0) + "</p>"
                + " <p>last Egg washBy Date is : " + egg.generateNextDate(14) + "</p>"
                + " <p>last Egg Use By Date is : " + egg.generateNextDate(35) + "</p>"
                + "<p>"+ egg.getNotes()+ "</p>";


        RequestDispatcher dispatcher = req.getRequestDispatcher("/eggForm.jsp");

        req.setAttribute("message", message); // This will be available as ${message}
        dispatcher.forward(req, resp);
    }
}
