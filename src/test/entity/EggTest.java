package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class EggTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGenerateNextDate() {
        logger.info("testGenerateNextDate");
        Egg eggTest = new Egg();

        String testDate = "1000-01-01";
        logger.info("start date string:  1/1/1000");
        eggTest.setCollectedDate(testDate);

        Logger logger = LogManager.getLogger(this.getClass());
        LocalDate localDate = LocalDate.parse(testDate);
        logger.debug("local date ="+ localDate);
        LocalDate nextTime = localDate.plusDays(14);
        logger.debug("local date ="+ nextTime);

        logger.info("next date Date: " + eggTest.generateNextDate(0));
        assertEquals(nextTime, eggTest.generateNextDate(14));
    }
}