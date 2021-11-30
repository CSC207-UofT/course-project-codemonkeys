package Users;

import Containers.Portfolio;
import org.junit.*;

import javax.sound.sampled.Port;

import static org.junit.Assert.*;

public class TestUser {
    private User user;
    private Portfolio portfolio;

    @Before
    public void setUp() {
        user = new User("test");
        portfolio = Portfolio.getInstance();
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test(timeout = 50)
    public void testUserGetName() {
        assertEquals(user.getName(), "test");
    }

    @Test(timeout = 50)
    public void testUserSetName(){
        user.setName("Bob");
        assertEquals("Bob", user.getName());
    }

    @Test(timeout = 50)
    public void testUserSetPortfolio(){
        user.setUserPortfolio(portfolio);
        assert(user.getUserPortfolio().equals(portfolio));
    }


}