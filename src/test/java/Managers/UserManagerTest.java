package Managers;

import Users.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserManagerTest {
    UserManager userManager;
    @Before
    public void setUp() {
        userManager  = UserManager.getInstance();
    }
    @After
    public void tearDown() {
        userManager = null;
    }

    @Test(timeout = 500)
    public void testUser() {
//        assertEquals("Bob", userManager.getName());
    }

    @Test(timeout = 500)
    public void testUser2() {
    }

}
