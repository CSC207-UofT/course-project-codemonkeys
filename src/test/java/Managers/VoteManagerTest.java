package Managers;

import Users.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteManagerTest {
    VoteManager voteManager;
    @Before
    public void setUp() {
        voteManager  = VoteManager.getInstance();
    }

    @After
    public void tearDown() {
        voteManager = null;
    }

    @Test(timeout = 500)
    public void testUser() {
//        assertEquals("Bob", admin.getName());
    }

    @Test(timeout = 500)
    public void testUser2() {

    }
}
