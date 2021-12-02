package Containers;

import Assets.Asset;
import Assets.DataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AssetProcessor extends Processor{
    // assetList: a list of asset in the portfolio
    private List<Asset> assetList;

    public AssetProcessor(){
        this.assetList = new ArrayList<>();
    }

    /**
     * Looks for an Asset in the Portfolio by UUID
     * @param id is the UUID
     * @returns if the Asset if found, null otherwise
     */
    public Asset get(UUID id){
        for (Asset asset : this.assetList){
            if (asset.getId().equals(id))
                return asset;
        }
        return null;
    }

    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset) {
        if(asset != null){
            this.assetList.add(asset);
        }
    }

    // Subtracts an asset from the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void sub(Asset asset0) {
        if (this.assetList.contains(asset0)) {
            this.assetList.remove(asset0);
        }
        else{
            System.out.println("Current portfolio does not contain " + asset0);
        }
    }

    // Calculates the value of a specific asset.
    // If the asset is not found, this method will return zero.
    public double getValue(String symbol) {
        double value = 0;
        for (Asset a: this.assetList){
            if (a.getSymbol().equals(symbol)){
                value += a.getValue();
            }
        }
        return value;
    }

    // Calculates the value of all assets in the system.
    // If there's no asset in the system, this method will return zero.
    public double getValue() {
        double value = 0;
        for (Asset a: this.assetList){
            value += a.getValue();
        }
        return value;
    }

    // Calculates the updated value of all assets in the system through the provided data access interface..
    // If there's no asset in the system, this method will return zero.
    public double getValue(DataAccessInterface api) {
        double value = 0;
        for (Asset a: this.assetList){
            a.updatePrice(api);
            value += a.getValue();
        }
        return value;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    /**
     * Refactor the string representation to show the details about assets in the portfolio.
     @return A string of assets information in the portfolio.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wealth Manager Debug Report: \n");
        for(Asset asset : this.assetList) {
            sb.append(asset.getType()).append('[');
            sb.append(asset.getVolume()).append(" x $").append(asset.getPrice());
            sb.append(" (= $").append(asset.getValue()).append(")]\n");
        }
        sb.append("Total value: $").append(this.getValue()).append('\n');
        return sb.toString();
    }
}
