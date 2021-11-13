package Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<AssetOLD> assets;

    public User(String n) {
        this.name = n;
        this.assets = new ArrayList<AssetOLD>();
    }

    public String getName() {
        return this.name;
    }

    public List<AssetOLD> getAssetSnapshot() {
        List<AssetOLD> res = new ArrayList<AssetOLD>();
        for (AssetOLD a : this.assets){
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

    public AssetOLD getAsset(String type) {
        for (AssetOLD a : this.assets) {
            if (a.getType().equalsIgnoreCase(type)){
                return a;
            }
        }
        return null;
    }

    public void addAsset(String assetName) {
        AssetOLD a = new AssetOLD(assetName);
        this.assets.add(a);
    }

    public void addInitialAsset(int value) {
        AssetOLD a = new AssetOLD("USD");
        Transaction[] t = Transaction.generateTransactionPair("_", "USD", value);
        a.addTransaction(t[0]);
        a.addTransaction(t[1]);
        this.assets.add(a);
    }
}
