package UseCases;
import Entities.Asset;

public class AssetManager {
    public static void updateAssetPrice(Asset asset, DataAccessInterface source) {
        double price = source.getUpdate(asset.getType());
    }
}
