package UseCase.Managers;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.DataAccessInterface;
import Entities.Assets.Stock;
import Interfaces.YahooFinanceStockAPI;
import org.junit.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AssetManagerTest {
    private final AssetManager am = AssetManager.getInstance();
    Asset asset1, asset2, asset3, asset4, asset5;
    DataAccessInterface api = new YahooFinanceStockAPI();

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
        for (Asset asset: am.getAssetList()){
            am.removeAsset(asset);
        }
    }

    @Test
    public void testGetInitialTypeValue(){
        assertEquals(14500, am.getTypeInitialValue("TSLA"));
        assertEquals(2000, am.getTypeInitialValue("AAPL"));
        assertEquals(6000, am.getTypeInitialValue("USD"));
    }

    @Test
    public void testGetTypeVolume(){
        assertEquals(15, am.getTypeVolume("TSLA"));
        assertEquals(10, am.getTypeVolume("AAPL"));
        assertEquals(6000, am.getTypeVolume("USD"));
    }

    @Test
    public void testGetInitialAssetInfo(){
        assertTrue(am.getInitialAssetInfo().containsKey("TSLA"));
        assertTrue(am.getInitialAssetInfo().containsKey("AAPL"));
        assertTrue(am.getInitialAssetInfo().containsKey("USD"));
        assertArrayEquals(new double[]{15, 14500}, am.getInitialAssetInfo().get("TSLA"));
        assertArrayEquals(new double[]{10, 2000}, am.getInitialAssetInfo().get("AAPL"));
        assertArrayEquals(new double[]{6000, 6000}, am.getInitialAssetInfo().get("USD"));
    }

    @Test
    public void testOther(){
        assertFalse(am.findAsset(UUID.randomUUID()));
        assertNull(am.getAsset(UUID.randomUUID()));
        assertEquals(3, am.getAssetSnapshot(api).size());
    }

}
