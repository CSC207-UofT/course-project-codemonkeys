import Clients.Admin;
import org.junit.*;
import static org.junit.Assert.*;

public class AdminTest {
    private Admin admin;

    @Before

    public void setUp() {
        admin  = new Admin("Bob");
    }

    @After
    public void tearDown() {
        admin = null;
    }

    @Test(timeout = 500)
    public void testUser() {
        assertEquals("Bob", admin.getName());
    }

    @Test(timeout = 500)
    public void testUser2() {

    }
}
