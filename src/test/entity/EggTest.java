package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class EggTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Test
    public void testGenerateNextDate() {
        logger.info("testGenerateNextDate");
        Egg eggTest = new Egg();

        String testDate = "1000-1-1";
        logger.info("start date string:  1/1/1000");
        eggTest.setCollectedDate(testDate);

        Calendar testCalendar = Calendar.getInstance();
        Date collected = null;
        try {
            collected = new SimpleDateFormat("yyyy-mm-dd").parse(testDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testCalendar.setTime(collected);
        testCalendar.add(Calendar.DAY_OF_YEAR,14);
        logger.info("next date Date: " + eggTest.generateNextDate(14));
        assertEquals(testCalendar.getTime(), eggTest.generateNextDate(14));
    }
}