package Assets;

import Containers.Transaction;
import Containers.Vote;
import Users.User;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssetTest {
    private Vote vote;
    private Asset asset;
    private Asset asset2;
    @Before
    public void setUp() {
        String tesla_name = "Tesla";
        String tesla_symbol = "TSLA";

        Asset asset = new Asset(10, 99, tesla_name, tesla_symbol);
        Asset asset2 = new Asset(15, 55, tesla_name,tesla_symbol);

        User bob = new User("Bob");

        Transaction trans = new Transaction(bob, asset, asset);
    }

    @After
    public void tearDown() {
        vote = null;
    }

    @Test(timeout = 500)
    public void testGetType(){
        assertEquals(this.asset.getType(), "Tesla");
    }

    @Test(timeout = 500)
    public void testGetSymbol(){
        assertEquals(this.asset.getSymbol(), "TSLA");
    }

    @Test(timeout = 500)
    public void testGetVolume(){
        assertEquals(this.asset.getVolume(), 10);
        assertEquals(this.asset2.getVolume(), 15);
    }

    @Test(timeout = 500)
    public void testGetPrice(){
        assertEquals(this.asset.getPrice(), 99);
        assertEquals(this.asset2.getPrice(), 55);
    }

    @Test(timeout = 500)
    public void testGetValue(){
        assertEquals(this.asset.getValue(), 990);
        assertEquals(this.asset2.getValue(), 825);
    }


}