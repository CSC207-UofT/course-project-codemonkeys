package EntityTests;

import Containers.Portfolio;
import Users.User;
import org.junit.*;
import static org.junit.Assert.*;

public class TestUser {
    User tested_user;
    final static int test_Authority_Level = 4;
    final static double test_Voting_Power = 2.4;

    @Before
    public void set_up() {
        this.tested_user = new User("test");
    }

    @Test(timeout = 50)
    public void testUserName() {
        assertEquals(tested_user.getName(), "test");
        tested_user.setName("test2");
        assertEquals(tested_user.getName(), "test2");
    }

    @Test(timeout = 50)
    public void testUsergetPortfolio() {
        Portfolio port = tested_user.getPortfolio();
        assert (port.values().isEmpty());
    }

    @Test(timeout = 50)
    public void testUserAuthorityLevel() {
        tested_user.setAuthorityLevel(test_Authority_Level);
        assert(tested_user.getAuthorityLevel() == test_Authority_Level);
    }

    @Test(timeout = 50)
    public void testUserVotingPower() {
        assert(tested_user.getVotingPower() == 1);
        tested_user.setVotingPower(test_Voting_Power);
        assert(tested_user.getVotingPower() == test_Voting_Power);
    }


}
