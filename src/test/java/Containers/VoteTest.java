package Containers;

import Users.CommonUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteTest {
    Vote testVote;
    CommonUser u1;

    @Before
    public void setUp() {
        u1 = new CommonUser("test");
        testVote = new Vote(u1, true);
    }

    @After
    public void tearDown() {
        this.testVote = null;
        this.u1 = null;
    }

    @Test(timeout = 500)
    public void testVoteCreate() {
    }

    @Test(timeout = 500)
    public void testUser2() {

    }
}