package persistence;

import entity.Role;
import entity.User;
import entity.ZipCodeWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.*;

public class GenericDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDAO<User> userDao;
    GenericDAO<ZipCodeWeather> zipDao;
    public int testUserId = 0;
    DatabaseUtility databaseUtility;
    List<User> users;

    @Before
    public void setUp() throws Exception{
        logger.info("setup");
        userDao = new GenericDAO<User>(User.class);
        zipDao = new GenericDAO<ZipCodeWeather>(ZipCodeWeather.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("Cleandb.sql");
        databaseUtility.runSQL("testdb.sql");
        users = userDao.getAll();
    }

    @Test
    public void getAllUser() {
        logger.info("getAll");
        logger.info(userDao.getAll());
        assertEquals("UnitTester0",userDao.getAll().get(0).getUserName());
    }

    @Test
    public void getByIdUser() {
        logger.info("Test getByIdUser User");
        User userTwo = users.get(1);

        User user = userDao.getById(userTwo.getId());
        logger.info(user);
        assertEquals(userTwo.getId(),user.getId());
    }

    @Test
    public void create() {
        logger.info("Test Create User");
        User newUser = new User();
        newUser.setUserName("testcreate" + users.size());
        newUser.setUserPass("testcreate");
        Role role = new Role();
        role.setName("user");
        role.setUser(newUser);
        newUser.addRole(role);

        ZipCodeWeather zipCode = new ZipCodeWeather();

        int newZip = 53576;
        logger.info(newZip);
        zipCode.setZip(newZip);

        List<ZipCodeWeather> singleZip = zipDao.findByPropertyEqual("zip", newZip);

        if (!singleZip.isEmpty()){
            logger.debug("is not empty" + singleZip);
            newUser.setZipCodeWeather(singleZip.get(0));
        }else {
            logger.debug("is empty "+ singleZip.isEmpty());
            zipCode.setWeather();
            logger.debug(zipCode.getId());
            int zipID = zipDao.create(zipCode);
            logger.debug("id "+ zipID);
            newUser.setZipCodeWeather(zipCode);
        }
        logger.info("User id null " + testUserId);
        logger.debug("Adding User: " + newUser);
        testUserId = userDao.create(newUser);
        logger.info("Added User id " + testUserId);
        assertEquals(users.size()+1, userDao.getAll().size());
    }

    @Test
    public void update() {
        User testUser = userDao.getById(2);
        logger.info("Got User id: 2 Name: " + testUser.getUserName());
        testUser.setUserPass("update pass");

        userDao.update(testUser);
        User testUser2 = userDao.getById(2);
        logger.info("updated User id: " + testUser2.getId() + " Pass: " + testUser2.getUserPass());
        assertEquals("update pass",testUser2.getUserPass());
    }

    @Test
    public void delete() {

        userDao.delete((User)userDao.getById(3));
        logger.info("Deleted User id " + 3);
        assertEquals(users.size()-1, userDao.getAll().size());
    }

    @Test
    public void findByPropertyEqual() {
        logger.info("findByPropertyEqual in field userName with name UnitTester1");
        List<User> user =  userDao.findByPropertyEqual("userName", "UnitTester1");
        logger.info(user.get(0));
        assertEquals(2, user.get(0).getId());
    }


}