package EntityTests;

import Entities.User;
import org.junit.*;
import static org.junit.Assert.*;

public class TestUser {
    @Test(timeout = 50)
    public void testUsergetName() {
        User user = new User("test");
        assertEquals(user.getName(), "test");
    }
}
