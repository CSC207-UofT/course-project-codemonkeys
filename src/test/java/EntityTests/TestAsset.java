import Entities.Asset;
import org.junit.*;
import static org.junit.Assert.*;


public class TestAsset {

    @Test(timeout = 50)
    public void TestAssetCopy() {
        Asset asset = new Asset("test");
        Asset asset2 = asset.copy();
        assertEquals(asset.getType(), asset2.getType());
        assertNotEquals(asset, asset2);
    }

}
