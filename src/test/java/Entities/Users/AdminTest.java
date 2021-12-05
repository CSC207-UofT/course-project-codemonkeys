package Entities.Users;

import org.junit.*;
import static org.junit.Assert.*;

public class AdminTest {
    private User banAdmin;
    private User voteAdmin;

    @Before
    public void setUp() {
        banAdmin  = new User("test1");
        voteAdmin = new User("test2");
        banAdmin.addAuthority("Ban");
        voteAdmin.addAuthority("Vote");
    }

    @After
    public void tearDown() {
        banAdmin = null;
        voteAdmin = null;
    }

    @Test(timeout = 500)
    public void testNames() {
        assertEquals("test1", banAdmin.getName());
        assertEquals("test2", voteAdmin.getName());
    }

    @Test(timeout = 500)
    public void testCheckAuthority(){
        assert(banAdmin.checkAuthority("Ban"));
        assert(voteAdmin.checkAuthority("Vote"));
    }

    @Test(timeout = 500)
    public void testNotHaveAuthority(){
        assertFalse(banAdmin.checkAuthority("Vote"));
        assertFalse(voteAdmin.checkAuthority("Ban"));
    }

    @Test(timeout = 500)
    public void testDoubleAuthority() {
        voteAdmin.addAuthority("Ban");
        assert(voteAdmin.checkAuthority("Ban"));
        assert(voteAdmin.checkAuthority("Vote"));
    }

    @Test(timeout = 500)
    public void testRemoveAuthority(){
        assert(voteAdmin.removeAuthority("Vote"));
        assertFalse(voteAdmin.removeAuthority("Ban"));
        assert(banAdmin.removeAuthority("Ban"));
        assertFalse(banAdmin.removeAuthority("Vote"));
    }

    @Test(timeout = 500)
    public void testAddAuthority(){
        assert(voteAdmin.addAuthority("Ban"));
        assertFalse(voteAdmin.addAuthority("Vote"));
        assertFalse(banAdmin.addAuthority("Ban"));
        assert(banAdmin.addAuthority("Vote"));

    }
}
