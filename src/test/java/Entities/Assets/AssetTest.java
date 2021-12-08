package Entities.Assets;

import Entities.Containers.Transaction;
import Entities.Containers.Vote;
import Entities.Users.User;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssetTest {
    private Asset asset;
    private Asset asset2;

    @Before
    public void setUp() {
        String teslaName = "Tesla";
        String teslaSymbol = "TSLA";
        String currencyName = "Pool";
        String currencySymbol = "USD";

        asset = new Asset(10, 1, teslaName, teslaSymbol);
        asset2 = new Asset(15, 1, teslaName,teslaSymbol);
        Currency c1 = new Currency(10, 1, currencyName, currencySymbol);
        Asset asset3 = new CryptoCurrency(10, 1, "c", "Cryptocurrency");

        User bob = new User("Bob");

    }

    @After
    public void tearDown() {
        Vote vote = null;
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
        assertEquals(10, this.asset.getVolume());
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
        this.asset.setPrice(1);
        this.asset2.setPrice(1);
        assertEquals(this.asset.getPrice(), 1);
        assertEquals(this.asset2.getPrice(), 1);
    }

    @Test(timeout = 500)
    public void testInitialPrice(){
        assertEquals(this.asset.getInitialPrice(), 1);
        assertEquals(this.asset2.getInitialPrice(), 1);
        asset.setPrice(100);
        asset2.setPrice(100);
        assertEquals(this.asset.getInitialPrice(), 1);
        assertEquals(this.asset2.getInitialPrice(), 1);
        // rollback
        asset.setPrice(1);
        asset2.setPrice(1);
    }

    @Test(timeout = 500)
    public void testInitialValue(){
        assertEquals(this.asset.getInitialValue(), 10);
        assertEquals(this.asset2.getInitialValue(), 15);
    }

}