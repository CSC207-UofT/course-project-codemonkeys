package Containers;

import Users.Admin;
import Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class VoteTest {
    Vote testVote;
    User u1;

    @Before
    public void setUp() {
        u1 = new User("test");
        testVote = new Vote(u1, true);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testVoteCreate() {
    }

    @Test(timeout = 500)
    public void testUser2() {

    }
}