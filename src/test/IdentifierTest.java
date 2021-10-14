import Identification.Identifier;
import Identification.StringIdentifier;
import org.junit.*;
import org.junit.Assert;
import org.junit.rules.*;
import java.io.*;

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