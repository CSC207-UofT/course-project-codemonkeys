package Containers;

import Assets.Asset;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    List<Asset> assetList;

    public Portfolio() {
        this.assetList = new ArrayList<>();
    }

    public boolean add(Asset asset){
        return this.assetList.add(asset);
    }

    public boolean remove(Asset asset){
        return this.assetList.remove(asset);
    }

    public boolean contains(Asset asset){
        return this.assetList.contains(asset);
    }

    public Asset get(Asset asset){
        return this.assetList.get(assetList.indexOf(asset));
    }
}
