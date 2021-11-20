package Assets;

import Assets.*;

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
        String currencyName = "Pool";
        String currencySymbol = "USD";

        Asset asset = new Asset(10, 1, tesla_name, tesla_symbol);
        Asset asset2 = new Asset(15, 1, tesla_name,tesla_symbol);
        Currency c1 = new Currency(10, 1, currencyName, currencySymbol);

        User bob = new User("Bob");

        Transaction trans = new Transaction(bob, c1, asset);
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
        assertEquals(this.asset.getPrice(), 1);
        assertEquals(this.asset2.getPrice(), 1);
    }

    @Test(timeout = 500)
    public void testGetValue(){
        assertEquals(this.asset.getValue(), 10);
        assertEquals(this.asset2.getValue(), 15);
    }

    @Test(timeout = 500)
    public void testSetPrice(){
        this.asset.setPrice(1000);
        this.asset2.setPrice(100);
        assertEquals(this.asset.getPrice(), 1000);
        assertEquals(this.asset2.getPrice(), 100);
        // rollback
        this.asset.setPrice(10);
        this.asset2.setPrice(15);
        assertEquals(this.asset.getPrice(), 10);
        assertEquals(this.asset2.getPrice(), 15);
    }

    @Test(timeout = 500)
    public void testInitialPrice(){
        assertEquals(this.asset.getInitialPrice(), 10);
        assertEquals(this.asset2.getInitialPrice(), 15);
        asset.setPrice(100);
        asset2.setPrice(100);
        assertEquals(this.asset.getInitialPrice(), 10);
        assertEquals(this.asset2.getInitialPrice(), 15);
        // rollback
        asset.setPrice(10);
        asset2.setPrice(15);
    }

    @Test(timeout = 500)
    public void testInitialValue(){
        assertEquals(this.asset.getInitialValue(), 10);
        assertEquals(this.asset2.getInitialValue(), 15);
    }

}