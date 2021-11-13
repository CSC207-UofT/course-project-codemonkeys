package EntityTests;

import Entities.Asset;
import Entities.AssetFactory;
import Entities.Asset;
import Entities.User;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;


public class TestAsset {
    Asset testAsset0;
    Asset testAsset1;
    final static String symbol0 = "testAsset";
    final static String symbol = "TSLA";
    final static double price = 1000;
    final static boolean valid = true;
    final static boolean liquid = false;
    final static String username = "Charlie";
    final static double amount = 10;


    @Before
    public void testAssetSetup() {
        AssetFactory f = new AssetFactory();
        testAsset0 = f.getAsset("Asset", symbol0);
        testAsset1 = f.getAsset("Stock", symbol);

    }

    @Test
    public void testAssetCreate() {
        assertNull(testAsset0.getSymbol());
        assertEquals(0, testAsset0.getOwnerList().size());
    }

    @Test
    public void testStockCreate() {
        assertEquals(symbol, testAsset1.getSymbol());
        assertEquals(0, testAsset1.getOwnerList().size());
        assertEquals(0, testAsset1.getPrice(), 1.0); // allow delta=$1.0 off for double precisions
        assertEquals("Stock", testAsset1.getType());
    }

    // TODO testCryptocurrencyCreate

    @Test
    public void testAssetPrice() {
        testAsset1.setPrice(price);
        assertEquals(price, testAsset1.getPrice(), 1.0);
    }

    // TODO testAssetSymbol, testAssetType


    @Test // TODO: complete "create" new User
    public void testAssetOwner() {
//        User u = new User(username);
//        testAsset1.addOwner(u.UUID, amount);
//
//        Map<UUID, Double> expected = new HashMap<>();
//        expected.put(u.UUID, amount);
//        assertEquals(1, testAsset1.getOwnerList().size());
//        assertEquals(expected, testAsset1.getOwnerList());
    }

    // TODO testGetTotalPrice

}
