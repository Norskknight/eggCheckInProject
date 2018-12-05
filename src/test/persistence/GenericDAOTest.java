package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDAO<User> userDao = new GenericDAO<User>(User.class);
    int testUserId = 0;

    @Test
    public void getAllUser() {
        logger.info("getAll");
        logger.info(userDao.getAll());
        assertEquals("test",userDao.getAll().get(0).getUserName());
    }

    @Test
    public void getByIdUser() {
        logger.info("Test getByIdUser User");
        User user = userDao.getById(1);
        logger.info(user);
        assertEquals(1,user.getId());
    }

    @Test
    public void create() {
        logger.info("Test Create User");
        User newUser = new User();
        newUser.setUserName("testcreate");
        newUser.setUserPass("testcreate");
        logger.info("User id null " + testUserId);

        testUserId = userDao.create(newUser);
        logger.info("Added User id " + testUserId);

        userDao.delete((User)userDao.getById(testUserId));
        logger.info("Deleted User id " + testUserId);
        assert true;
    }

    @Test
    public void update() {
        logger.info("Test Update User");

        User newUser = new User();
        newUser.setUserName("testcreate");
        newUser.setUserPass("testcreate");
        testUserId = userDao.create(newUser);
        logger.info("Added User id: " + testUserId + " Name: "+ newUser.getUserName());

        User testUser = userDao.getById(testUserId);
        logger.info("Got User id: " + testUserId + " Name: " + testUser.getUserName());

        testUser.setUserName("update");
        userDao.update(testUser);
        User testUser2 = userDao.getById(testUserId);
        logger.info("updated User id: " + testUserId + " Name: " + testUser2.getUserName());

        userDao.delete(testUser);
        logger.info("Deleted User id: " + testUserId + " Name: " + testUser2.getUserName());
        assert true;
    }

    @Test
    public void delete() {
        logger.info("Test Delete User");
        User newUser = new User();
        newUser.setUserName("testcreate");
        newUser.setUserPass("testcreate");
        testUserId = userDao.create(newUser);
        logger.info("Added User id " + testUserId);
        userDao.delete((User)userDao.getById(testUserId));
        logger.info("Deleted User id " + testUserId);
        assert true;
    }
}