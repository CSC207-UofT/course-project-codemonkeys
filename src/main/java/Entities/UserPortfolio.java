package Entities;

import java.util.ArrayList;
import java.util.UUID;
import java.io.*;

public  class UserPortfolio implements Serializable {
    public ArrayList<Asset> assets;

    public UserPortfolio(){
        this.assets = new ArrayList<Asset>();
    }

    public void addasset(Asset asset){
        this.assets.add(asset);
    }

    public ArrayList<Asset> GetAssets(){
        // get a list of all assets in the portfolio.

        return this.assets;
    }

    public boolean Contains(Asset asset){

        return this.assets.contains(asset);
    }

    public double GetTotalValue(){
        // Calculate the total price of assets in this portfolio.

        double result = 0;
        for(Asset a: this.assets){
            result += a.getValue()
            ;
        }
        return result;
    }

    public Asset GetAsset(UUID id){
        for(Asset a: this.assets){
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }

}
