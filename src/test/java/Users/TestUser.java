package Users;

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
