package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import persistence.GenericDAO;
import util.DatabaseUtility;

import static org.junit.Assert.*;

public class ZipCodeWeatherTest {
    GenericDAO<ZipCodeWeather> wDAO;
    DatabaseUtility databaseUtility;
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Before
    public void setUp() throws Exception {
        logger.info("setup");

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("Cleandb.sql");
        databaseUtility.runSQL("testdb.sql");
    }
    @Test
    public void tempToFahrenheit() {

        wDAO = new GenericDAO<ZipCodeWeather>(ZipCodeWeather.class);
        ZipCodeWeather weather = (ZipCodeWeather) wDAO.getById(1);
        assertEquals(-280.0,weather.tempToFahrenheit(),0);
    }

    @Test
    public void tempToCelsius() {
        wDAO = new GenericDAO(ZipCodeWeather.class);
        ZipCodeWeather weather = (ZipCodeWeather) wDAO.getById(1);
        assertEquals(-173.0,weather.tempToCelsius(), 0);
    }
}