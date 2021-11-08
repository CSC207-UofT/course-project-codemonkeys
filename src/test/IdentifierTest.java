import Client.User;
import Identification.Identifier;
import org.junit.*;
import static org.junit.Assert.*;

public class IdentifierTest {
    private Identifier id;
    private User user;
    @Before
    public void setUp() {
        id = new Identifier("Hello");
        user = new User("bob", id);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testId() {
        assertEquals(user.getId(), id);
        assertEquals(id, user.getId());
    }
}