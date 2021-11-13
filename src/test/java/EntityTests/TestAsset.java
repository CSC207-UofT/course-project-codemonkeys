package EntityTests;

import Entities.AssetOLD;
import org.junit.*;
import static org.junit.Assert.*;


public class TestAsset {
    @Test(timeout = 50)
    public void testAssetCopy() {
        AssetOLD asset = new AssetOLD("test");
        AssetOLD asset2 = asset.copy();
        assertEquals(asset.getType(), asset2.getType());
        assertNotEquals(asset, asset2);
    }
}
