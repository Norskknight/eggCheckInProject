package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import persistence.GenericDAO;
import util.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    GenericDAO<User> userDao;
    GenericDAO<Egg> eggDao;
    DatabaseUtility databaseUtility;
    List<User> users;
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Before
    public void setUp() throws Exception{
        logger.info("setup");
        userDao = new GenericDAO<User>(User.class);
        eggDao = new GenericDAO<Egg>(Egg.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("Cleandb.sql");
        databaseUtility.runSQL("testdb.sql");
        users = userDao.getAll();
    }

    @Test
    public void addEgg() {
        Egg testEgg = new Egg();
        List<User> singleUser = userDao.findByPropertyEqual("userName", "UnitTester3");
        User user = singleUser.get(0);
        logger.debug(user);
        testEgg.setId(1);
        testEgg.setType("duck");
        testEgg.setCollectedDate("1/1/1000");
        testEgg.setUser(user);
        testEgg.setPerUserId(user.getEggs().size()+1);
        logger.debug(user.getEggs());

        eggDao.create(testEgg);

        User userInDb = userDao.getById(user.getId());
        assertEquals(user.getEggs().size() + 1, userInDb.getEggs().size());
    }
}