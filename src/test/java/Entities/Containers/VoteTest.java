package Entities.Containers;

import Entities.Users.User;
import org.junit.After;
import org.junit.Before;

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