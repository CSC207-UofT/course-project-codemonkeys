package Containers;

import Assets.Asset;
import Assets.AssetType;
import Assets.Currency;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.*;

public class Portfolio extends HashMap<UUID, Asset> {

    public Portfolio(){
        super();
    }

    /**
     * Quick add for the portfolio
     * @param asset is the asset we want to add
     */
    public void add(Asset asset){
        this.put(asset.getId(), asset);
    }

    /**
     * Returns all assets of a given type
     * @param type is the class of the AssetType
     * @param <T> is an AssetType
     * @returns a List of Assets with the AssetType <T>
     */
    public <T extends AssetType> List<Asset<T>> getAssetsOfType(Class<T> type){
        List<Asset<T>> assetList = new ArrayList<>(); // Create a list
        for (Asset asset : this.values()){ // Iterate though the Portfolio
            if(type.isInstance(asset.getType())) //If the asset has the same type as <type> then
                assetList.add(asset); // Add it
        }
        return assetList;
    }
}
