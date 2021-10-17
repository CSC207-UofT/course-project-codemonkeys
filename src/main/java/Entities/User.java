package Entities;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;

public class User {
    private String name;
    private List<Asset> assets;

    public User(String n) {
        this.name = n;
        this.assets = new ArrayList<Asset>();
    }

    public String getName() {
        return this.name;
    }

    public List<Asset> getAssetSnapshot() {
        List<Asset> res = new ArrayList<Asset>();
        for (Asset a : this.assets){
            res.add(a.copy());
        }
        return res;
    }

    public double getAssetValue(String type) {
        return this.getAsset(type).getTotalValue();
    }

    public double getLiquidAssetValue() {
        return this.getAssetValue("USD");
    }

    public boolean hasAssetValue(String type, double value) {
        return this.getAssetValue(type) >= value;
    }

    public Asset getAsset(String type) {
        for (Asset a : this.assets) {
            if (a.getType().equalsIgnoreCase(type)){
                return a;
            }
        }
        return null;
    }

    public void addAsset(String assetName) {
        Asset a = new Asset(assetName);
        this.assets.add(a);
    }

    public void addInitialAsset(int value) {
        Asset a = new Asset("USD");
        Transaction[] t = Transaction.generateTransactionPair("_", "USD", value);
        a.addTransaction(t[0]);
        a.addTransaction(t[1]);
        this.assets.add(a);
    }
}
