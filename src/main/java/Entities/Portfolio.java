package Entities;

import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Asset> assets;

    public Portfolio(ArrayList<Asset> assets){
        this.assets = assets;
    }

    public Portfolio(){
        this.assets = new ArrayList<Asset>();
    }

    public void AddAsset(Asset asset){
        this.assets.add(asset);
    }

    public ArrayList<Asset> GetAssets(){
        // get a list of all assets in the portfolio.

        return this.assets;
    }

    public boolean CheckAssetIn(Asset asset){

        return this.assets.contains(asset);
    }

    public double GetTotalValue(){
        // Calculate the total price of assets in this portfolio.

        double result = 0;
        for(Asset a: this.assets){
            result += a.getTotalPriceOwned();
        }

        return result;
    }

    public double CalculateLiquidValue(){
        double result = 0;
        for(Asset a: this.assets){
            if(a.getType().equals("Liquid")){
                result += a.getTotalPriceOwned();
            }
        }
        return result;
    }

    public double TypeAssetValue(String type){
        // Calculate the total asset value of a specific type of asset in the portfolio.
        double result = 0;
        for(Asset a: this.assets){
            if(a.getType().equals(type)){
                result += a.getTotalPriceOwned();
            }
        }
        return result;
    }

    public Asset GetAsset(String type){
        for(Asset a: this.assets){
            if(a.getType().equals(type)){
                return a;
            }
        }
        return null;
    }
}
