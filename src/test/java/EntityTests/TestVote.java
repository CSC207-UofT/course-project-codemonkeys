import Entities.User;
import Entities.Vote;
import org.junit.*;
import static org.junit.Assert.*;

public class TestVote {
    @Test(timeout = 50)
    public void testVotegetValue() {
        User user = new User("test");
        Vote vote = new Vote(user, "USD", "TSLA", 100);
        assertEquals(vote.getValue(), 100, 0);
    }
}
