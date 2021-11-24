package Users;

import Containers.Portfolio;
import org.junit.*;
import static org.junit.Assert.*;

public class AdminTest {
    private BanAuthority BanAdmin;
    private ControlVoteAuthority VoteAdmin;

    @Before
    public void setUp() {
        BanAdmin  = new BanAuthority(new CommonUser("Bob"));
        VoteAdmin = new ControlVoteAuthority(new CommonUser("Leon"));
    }

    @After
    public void tearDown() {
        BanAdmin = null;
        VoteAdmin = null;
    }

    @Test(timeout = 500)
    public void testNames() {
        assertEquals("Bob", BanAdmin.getName());
        assertEquals("Leon", VoteAdmin.getName());
    }

    @Test(timeout = 500)
    public void testSingleAuthority(){
        assert(BanAdmin.checkAuthority("Ban"));
        assert(VoteAdmin.checkAuthority("Vote"));
    }

    @Test(timeout = 500)
    public void testNotHaveAuthority(){
        assertFalse(BanAdmin.checkAuthority("Vote"));
        assertFalse(VoteAdmin.checkAuthority("Ban"));

    }

    @Test(timeout = 500)
    public void testDoubleAuthority() {
        User BothAdmin = new BanAuthority(VoteAdmin);
        assert(BothAdmin.checkAuthority("Ban"));
        assert(BothAdmin.checkAuthority("Vote"));
    }

    @Test(timeout = 500)
    public void testConstantUUID(){
        User BothAdmin = new BanAuthority(VoteAdmin);
        assert(BothAdmin.getId() == VoteAdmin.getId());
    }

    @Test(timeout = 500)
    public void testConstantPortfolio(){
        VoteAdmin.setUserPortfolio(Portfolio.getInstance());
        User BothAdmin = new BanAuthority(VoteAdmin);
        assert(BothAdmin.getUserPortfolio().equals(VoteAdmin.getUserPortfolio()));
    }

    @Test(timeout = 500)
    public void testConstantName(){
        User BothAdmin = new BanAuthority(VoteAdmin);
        assert(BothAdmin.getName().equals("Leon"));
    }
}
