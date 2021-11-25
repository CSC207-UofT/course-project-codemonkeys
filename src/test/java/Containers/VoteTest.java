package Containers;

import Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        this.testVote = null;
        this.u1 = null;
    }
}