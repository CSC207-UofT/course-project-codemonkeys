package UseCases;
import Entities.AssetOLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AssetManager {

    // TODO : List<Asset> -> AssetList Iterable
    public List<AssetOLD> assets = new ArrayList<>(); // asset -> totalAssets

    private static AssetManager instance = null;

    public static AssetManager getInstance() {
        if(AssetManager.instance == null) {
            AssetManager.instance = new AssetManager();
        }
        return AssetManager.instance;  // UserManager only initiated for once
    }

    public void updateAssetPrice(DataAccessInterface source) {
        for (AssetOLD asset : this.assets) {
            double price = source.getUpdate(asset.getSymbol());
            asset.setPrice(price);
        }
    }

    public void addAsset(AssetOLD newAsset) {
        this.assets.add(newAsset);
    }

    public void removeAsset(AssetOLD delAsset) {
        this.assets.remove(delAsset);
    }

    public List<AssetOLD> getAllAssets() {
        return this.assets;
    }

    public Map<UUID, Double> getAssetOwner(AssetOLD asset) {
        return asset.getOwnerList();
    }

    public void assetAddOwner(AssetOLD asset, UUID owner, Double amount) {
        asset.addOwner(owner, amount);
    }

    public Asset checkByType(String name){
        for(Asset a: this.assets){
          if(a.getType() == name)  {
              return a;
          };
        };
        return null;
    }

    // TODO: probably strategy pattern
    public List<String> sortAssetByTotalPrice() {
        //"TSLA: $1000"
        return null;
    }

    public AssetOLD findBySymbol(String symbol){
        for (AssetOLD a : this.assets) {
            if (a.getSymbol().equalsIgnoreCase(symbol)) return a;
        }
        return null;
    }

    // TODO
    public List<AssetOLD> getLiquidAssets() {
        // if a.isLiquid()
        return null;
    }

    public List<AssetOLD> getNonLiquidAssets() {
        // copy the previous one
        return null;
    }

    // TODO: convert initiator's share of 1 asset to another
    public void transfer1AssetToAnotherAsset(AssetOLD a, AssetOLD b, UUID initiator) {
        // a = "TSLA" -> {C: 10, J: 10}; TSLA $1000/share
        // b = "Oracle" -> {}; ORC $200/share

        // transfer1AssetToAnotherAsset("TSLA", "ORC", "C")

        // -> a = "TSLA" -> {J: 10}
        // -> b = "Oracle" -> {C: 50}

    }

}
