package Managers.AssetMangers;

import Assets.Asset;
import Assets.AssetType;
import Assets.Stock;
import Interfaces.DataAccessInterface;

public class AssetPriceManager {
    /**
     * Updates the price a given asset
     */

    public static void updateAssetPrice(Asset asset, DataAccessInterface source) {
        double price;
        price = source.getUpdate(((AssetType) asset.getType()).getSymbol());
        asset.setPrice(price);
    }


}
