package Managers;

import Assets.Asset;
import Assets.Currency;
import Assets.Stock;
import Managers.AssetManager;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssetManagerTest {
    private final AssetManager am = AssetManager.getInstance();
    Asset asset1, asset2, asset3, asset4, asset5;

    @Before
    public void setUp() {
        AssetManager am = AssetManager.getInstance();
        asset1 = new Stock(10, 1000, "tesla", "TSLA");
        asset2 = new Currency(10000, 1, "usDollar", "USD");
        asset3 = new Stock(5, 900, "tesla", "TSLA");
        asset4 = new Stock(10, 200, "apple", "AAPL");
        asset5 = new Currency(-4000, 1, "usDollar", "USD");
        am.addAsset(asset1);
        am.addAsset(asset2);
        am.addAsset(asset3);
        am.addAsset(asset4);
        am.addAsset(asset5);
    }

    @After
    public void tearDown() {
        am.delAsset(asset1);
        am.delAsset(asset2);
        am.delAsset(asset3);
        am.delAsset(asset4);
        am.delAsset(asset5);
    }

    @Test
    public void testGetTypeValue(){
        assertEquals(14500, am.getTypeValue("TSLA"));
        assertEquals(2000, am.getTypeValue("AAPL"));
        assertEquals(6000, am.getTypeValue("USD"));
    }

    @Test
    public void testGetTypeVolume(){
        assertEquals(15, am.getTypeVolume("TSLA"));
        assertEquals(10, am.getTypeVolume("AAPL"));
        assertEquals(6000, am.getTypeVolume("USD"));
    }

    @Test
    public void testGetAssetInfo(){
        assertTrue(am.getAssetInfo().containsKey("TSLA"));
        assertTrue(am.getAssetInfo().containsKey("AAPL"));
        assertTrue(am.getAssetInfo().containsKey("USD"));
        assertArrayEquals(new double[]{15, 14500}, am.getAssetInfo().get("TSLA"));
        assertArrayEquals(new double[]{10, 2000}, am.getAssetInfo().get("AAPL"));
        assertArrayEquals(new double[]{6000, 6000}, am.getAssetInfo().get("USD"));
    }
}
