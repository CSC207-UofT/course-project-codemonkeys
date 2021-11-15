package EntityTests;

import Entities.ConcreteUser;
import Entities.User;
import Entities.UserPortfolio;
import Entities.Vote;
import org.junit.*;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class TestVote {
    Vote testVote;
    ConcreteUser u1, u2, u3, u4;
    final static String fromType = "Stock";
    final static String toType = "Cryptocurrency";
    final static double value = 1000.0;

    @Before
    public void testVoteSetup() {
        u1 = new ConcreteUser("A");
        u2 = new ConcreteUser("B");
        u3 = new ConcreteUser("C");
        u4 = new ConcreteUser("D");
        testVote = new Vote(u1, fromType, toType, value);
    }

    @Test
    public void testVoteCreate() {
        assertEquals(fromType, testVote.getFromType());
        assertEquals(toType, testVote.getToType());
        assertNotNull(testVote.getId());
        assertEquals(value, testVote.getValue(), 0.1); // $0.1 precision
    }

    @Test
    public void testUpVote() {
        testVote.upVote(u1);
        testVote.upVote(u2);
        testVote.upVote(u3);
        assertEquals(3, testVote.upVoterSize());
    }

    @Test
    public void testDownVote() {
        testVote.downVote(u4);
        assertEquals(1, testVote.downVoterSize());
    }

    @Test
    public void testGetUpVoters() {
        ArrayList<User> expectedUpVoteList = new ArrayList<>();
        expectedUpVoteList.add(u1);
        expectedUpVoteList.add(u2);
        expectedUpVoteList.add(u3);
        assertEquals(expectedUpVoteList, testVote.getUpVoters());
    }

    @Test
    public void testGetDownVoters() {
        ArrayList<User> expectedDownVoteList = new ArrayList<>();
        expectedDownVoteList.add(u4);
        assertEquals(expectedDownVoteList, testVote.getDownVoters());
    }

    @Test
    public void testCheckApprove() {
        // (TODO): make portfolio in setup first, make sure u1-u4 have enough money
        boolean actual = testVote.checkApprove(4);
        assertTrue(actual);
    }

    @Test
    public void testEligible() {
        // (TODO): make portfolio in setup first, make sure u1 doesn't have enough money to vote
        // (TODO): (add later) make sure u2 have enough money to pull a vote
        assertFalse(testVote.isEligible());
        Vote testVote2 = new Vote(u2, toType, fromType, 100.0);
        assertTrue(testVote2.isEligible());
    }


}
