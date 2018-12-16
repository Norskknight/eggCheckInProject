package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import persistence.GenericDAO;
import util.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.*;

public class ZipCodeWeatherTest {

    GenericDAO<ZipCodeWeather> weatherDao;
    GenericDAO<User> userDao;
    DatabaseUtility databaseUtility;

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Before
    public void setUp() throws Exception{
        logger.info("setup");
        userDao = new GenericDAO<User>(User.class);
        weatherDao = new GenericDAO(ZipCodeWeather.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("Cleandb.sql");
        databaseUtility.runSQL("testdb.sql");
    }

    @Test
    public void addUser() {
        List<User> singleUser = userDao.findByPropertyEqual("userName", "UnitTester3");

        ZipCodeWeather test = new ZipCodeWeather();
        logger.info("add user zipcode");
        test.setZip(53575);
        logger.debug(test.getZip());
        test.setWeather();
        logger.info(test.tempToFahrenheit());
        logger.info(test.tempToCelsius());


        weatherDao.create(test);

    }



}