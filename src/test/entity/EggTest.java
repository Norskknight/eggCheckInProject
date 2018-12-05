package entity;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class EggTest {

    @Test
    public void testGenerateNextDate() {
        Egg eggTest = new Egg();

        String testDate = "1/1/1000";
        eggTest.setCollectedDate(testDate);

        Calendar testCalendar = Calendar.getInstance();
        Date collected = null;
        try {
            collected = new SimpleDateFormat("dd/MM/yyyy").parse(testDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testCalendar.setTime(collected);
        testCalendar.add(Calendar.DAY_OF_YEAR,14);

        assertEquals(testCalendar.getTime(), eggTest.generateNextDate(14));
    }
}