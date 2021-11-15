package Containers;

import Assets.Asset;
import Assets.AssetType;
import Assets.Currency;

import java.util.*;

// Portfolio is a manager and data storage class for managing common wealth among all users.
// TODO: change its name to WealthManager and move it into package Managers.
// The common wealth among all users is stored in the form of individual assets.
// More assets can be added, or be subtracted from the system. The manager will only perform operation on the same type of assets.
// The manager can calculate the value of one or all assets.
// The manager is also responsible for updating the price of an asset to correctly calculate its value.
public class Portfolio {

    private static Portfolio commonPortfolio;

    static {
        Portfolio.commonPortfolio = new Portfolio();
    }

    public static Portfolio getCommonPortfolio() {
        return Portfolio.commonPortfolio;
    }

    // Storage: The UUID of asset and the reference of asset
    private final HashMap<UUID, Asset> storage;

    private Portfolio() {
        this.storage = new LinkedHashMap<UUID, Asset>();
    }

    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset0) {
        Asset asset = this.storage.get(asset0.id);
        if(asset == null) {
            asset = new Asset(0, asset0.getPrice(), asset0.getType());
            this.storage.put(asset.id, asset);
        }
        asset.setVolume(asset.getVolume() + asset0.getVolume());
    }

    // Subtracts an asset from the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void sub(Asset asset0) {
        Asset asset = this.storage.get(asset0.id);
        if(asset == null) asset = new Asset(0, asset0.getPrice(), asset0.getType());
        asset.setVolume(asset.getVolume() - asset0.getVolume());
    }

    // Calculates the value of a specific asset.
    // If the asset is not found, this method will return zero.
    public double getValue(Class assetType) {
        double value = 0;
        Collection<Asset> assets = this.storage.values();
        for(Asset asset : assets) {
            if(!assetType.isAssignableFrom(asset.getType().getClass())) continue;
            value += asset.getValue();
        }
        return value;
    }

    // Calculates the value of all assets in the system.
    // If there's no asset in the system, this method will return zero.
    public double getValue() {
        return getValue(AssetType.class);
    }

    // Update the price of a specific asset.
    public void updatePrice(Class assetType, double price) {
        Collection<Asset> assets = this.storage.values();
        for(Asset asset : assets) {
            if(!assetType.isAssignableFrom(asset.getType().getClass())) continue;
            asset.setPrice(price);
        }
    }

}


