package EntityTests;

import Containers.Portfolio;
import Users.User;
import org.junit.*;
import static org.junit.Assert.*;

public class TestUser {
    User tested_user;
    final static String user_name = "test";

    @Before
    public void set_up() {
        this.tested_user = new User("test");
    }

    @Test(timeout = 50)
    public void testUsergetName() {
        assertEquals(this.tested_user.getName(), "test");
    }

    @Test(timeout = 50)
    public void testUsersetName() {
        this.tested_user.setName("test2");
        assertEquals(this.tested_user.getName(), "test2");
    }

    @Test(timeout = 50)
    public void testUsergetPortfolio() {
        Portfolio port = this.tested_user.getPortfolio();
        assert (port.values().isEmpty());
    }

}
