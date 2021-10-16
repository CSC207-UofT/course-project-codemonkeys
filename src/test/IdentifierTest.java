import Identification.Identifier;
import org.junit.*;

public class IdentifierTest {
    private Identifier id;

    @Before
    public void setUp() {
        id = new StringIdentifier("Hello");
    }

    @After
    public void tearDown() {
        id = null;
    }

    @Test(timeout = 500)
    public void testId() {
    }
}