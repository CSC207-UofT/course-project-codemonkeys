package EntityTests;

import Users.BanAuthority;
import Users.CommonUser;
import Users.ControlVoteAuthority;
import org.junit.*;
import static org.junit.Assert.*;

public class TestUser {
    private CommonUser user;

    @Before
    public void setUp() {
        user = new CommonUser("test");
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test(timeout = 50)
    public void testUsergetName() {
        assertEquals(user.getName(), "test");
    }

    @Test(timeout = 50)
    public void testUsersetName(){
        user.setName("Bob");
        assertEquals("Bob", user.getName());
    }
}
