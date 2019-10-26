package com.epam.model.dao;

import com.epam.model.configuration.ConnectionConfigurator;
import com.epam.model.entity.User;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConnectionConfigurator.class)
public class UserDaoTest {


    @Autowired
    private UserDao userDao;

    @Autowired
    private Flyway flyway;

    private Date sqlDate;


    @Before
    public void setUp() throws Exception {
        flyway.migrate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2018-11-06";
        sqlDate = simpleDateFormat.parse(date);
    }

    @After
    public void tearDown() throws Exception {
        flyway.clean();
    }

    @Test
    public void getUserById() {
        User expectedUser = new User(4, "Rebecka", "rgoodliff3@blog.com", sqlDate);
        User actualUser = userDao.getUserById(4);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getAllUsers() {
        int expectedUserList = 50;
        int actualUserList = userDao.getAllUsers().size();

        assertEquals(expectedUserList, actualUserList);

    }

    @Test
    public void updateUser() {
        User expectedUser = new User(40, "NameChanged", "rharron13@virginia.edu", sqlDate);
        userDao.updateUser(expectedUser);
        User actualUser = userDao.getUserById(40);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void removeUSer() {
        userDao.removeUSer(50);

        int expectedUserListAfterRemoval = 49;
        int actualUserListAfterRemoval = userDao.getAllUsers().size();

        assertEquals(expectedUserListAfterRemoval, actualUserListAfterRemoval);
    }

    @Test
    public void addUser() {
        User expectedUser = new User(51, "NameChanged", "rharron13@virginia.edu", sqlDate);
        userDao.addUser(expectedUser);
        User actualUser = userDao.getUserById(51);

        assertEquals(expectedUser, actualUser);
    }
}