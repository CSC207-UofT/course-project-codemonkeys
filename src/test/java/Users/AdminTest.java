package Users;

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
        User Both_admin = new BanAuthority(VoteAdmin);
        assert(Both_admin.checkAuthority("Ban"));
        assert(Both_admin.checkAuthority("Vote"));
    }
}
