package Containers;

import Assets.Asset;

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

    public static Portfolio getInstance() {
        return Portfolio.commonPortfolio;
    }

    // Storage: The UUID of asset and the reference of asset
    private final HashMap<String, Asset> storage;

    private Portfolio() {
        this.storage = new LinkedHashMap<String, Asset>();
    }

    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset0) {
        Asset asset = this.storage.get(asset0.getType());
        if(asset == null) {
            asset = new Asset(0, asset0.getPrice(), asset0.getType(), asset0.getSymbol());
            this.storage.put(asset.getType(), asset);
        }
        asset.setVolume(asset.getVolume() + asset0.getVolume());
    }

    // Subtracts an asset from the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void sub(Asset asset0) {
        Asset asset = this.storage.get(asset0.getType());
        if(asset == null) {
            asset = new Asset(0, asset0.getPrice(), asset0.getType(), asset0.getSymbol());
            this.storage.put(asset.getType(), asset);
        }
        asset.setVolume(asset.getVolume() - asset0.getVolume());
    }

    // Calculates the value of a specific asset.
    // If the asset is not found, this method will return zero.
    public double getValue(String type) {
        double value = 0;
        Asset asset = this.storage.get(type);
        if(asset == null) return 0;
        return asset.getValue();
    }

    // Calculates the value of all assets in the system.
    // If there's no asset in the system, this method will return zero.
    public double getValue() {
        double value = 0;
        Collection<Asset> assets = this.storage.values();
        for(Asset asset : assets) {
            value += asset.getValue();
        }
        return value;
    }

    // Update the price of a specific asset.
    public void updatePrice(String type, double price) {
        Asset asset = this.storage.get(type);
        if(asset == null) return;
        asset.setPrice(price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wealth Manager Debug Report: \n");
        for(String type : this.storage.keySet()) {
            Asset asset = this.storage.get(type);
            sb.append(asset.getType()).append('[');
            sb.append(asset.getVolume()).append(" x $").append(asset.getPrice());
            sb.append(" (= $").append(asset.getValue()).append(")]\n");
        }
        sb.append("Total value: $").append(this.getValue()).append('\n');
        return sb.toString();
    }
}

// All tests passed
