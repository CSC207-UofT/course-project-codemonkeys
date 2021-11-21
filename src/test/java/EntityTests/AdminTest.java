package EntityTests;

import Users.BanAuthority;
import Users.CommonUser;
import Users.ControlVoteAuthority;
import Users.User;
import org.junit.*;
import static org.junit.Assert.*;

public class AdminTest {
    private BanAuthority Ban_admin;
    private ControlVoteAuthority Vote_admin;

    @Before
    public void setUp() {
        Ban_admin  = new BanAuthority(new CommonUser("Bob"));
        Vote_admin = new ControlVoteAuthority(new CommonUser("Leon"));
    }

    @After
    public void tearDown() {
        Ban_admin = null;
        Vote_admin = null;
    }

    @Test(timeout = 500)
    public void testNames() {
        assertEquals("Bob", Ban_admin.getName());
        assertEquals("Leon", Vote_admin.getName());
    }

    @Test(timeout = 500)
    public void testSingleAuthority(){
        assert(Ban_admin.Check_Authority("Ban"));
        assert(Vote_admin.Check_Authority("Vote"));
    }

    @Test(timeout = 500)
    public void testNotHaveAuthority(){
        assertFalse(Ban_admin.Check_Authority("Vote"));
        assertFalse(Vote_admin.Check_Authority("Ban"));

    }

    @Test(timeout = 500)
    public void testDoubleAuthority() {
        User Both_admin = new BanAuthority(Vote_admin);
        assert(Both_admin.Check_Authority("Ban"));
        assert(Both_admin.Check_Authority("Vote"));
    }
}
