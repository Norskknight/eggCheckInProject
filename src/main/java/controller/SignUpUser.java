package controller;

import entity.Role;
import entity.User;
import entity.ZipCodeWeather;
import persistence.GenericDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )
public class SignUpUser extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO<User> userDao = new GenericDAO<User>(User.class);
        GenericDAO<ZipCodeWeather> zipDao = new GenericDAO<ZipCodeWeather>(ZipCodeWeather.class);
        User user = new User();
        user.setId(1);
        user.setUserName(req.getParameter("userName"));
        user.setUserPass(req.getParameter("userPass"));
        Role role = new Role();
        role.setUser(user);
        role.setName("user");
        user.addRole(role);

        ZipCodeWeather zipCode = new ZipCodeWeather();

        int newZip = Integer.parseInt(req.getParameter("zip"));
        logger.info("zip reseved "+ newZip);
        zipCode.setZip(newZip);

        List<ZipCodeWeather> singleZip = zipDao.findByPropertyEqual("zip", newZip);

        if (!singleZip.isEmpty()){
            logger.debug("is not empty"+singleZip);
            user.setZipCodeWeather(singleZip.get(0));
        }else {
            zipCode.setId(1);
            zipCode.setWeather();
            logger.debug(zipCode);
            int zipID = zipDao.create(zipCode);
            zipCode.setId(zipID);
            logger.debug("id "+ zipID);
            user.setZipCodeWeather(zipCode);
        }

        logger.debug("Adding User: " + user);

        int userid = userDao.create(user);
        logger.debug("user ID: " + userid);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
