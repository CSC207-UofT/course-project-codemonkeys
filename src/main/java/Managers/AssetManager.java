package Managers;

import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import java.io.Serializable;

import java.util.*;

public class AssetManager implements Serializable{
    private final Map<UUID, Asset> assetMap;

    //create an object of AssetManager
    private static final AssetManager instance = new AssetManager();

    private AssetManager() {this.assetMap = new HashMap<>();}

    //Get the only object available
    public static AssetManager getInstance() {return instance;}

    public boolean containAsset(Asset asset){
        return this.assetMap.containsValue(asset);
    }

    public List<Asset> assetList () {
        return (List<Asset>) this.assetMap.values();
    }

    public void addAsset(Asset a){
        this.assetMap.put(a.id, a);
    }

    public void delAsset(Asset a){
        this.assetMap.remove(a.id);
    }

    /**
     * Return the InitialValue of a specific type of asset
     * @param symbol the symbol of the queried type of asset
     * @return the total value of the queried type of asset
     */
    public double getTypeInitialValue(String symbol){
        double value = 0;
        for (Asset a: this.assetMap.values()){
            if(Objects.equals(a.getSymbol(), symbol)){
                value += a.getInitialValue();
            }
        }
        return value;
    }

    /**
     * Return the RealValue of a specific type of asset
     * @param symbol the symbol of the queried type of asset
     * @return the total real value of the queried type of asset
     */
    public double getTypeRealValue(String symbol, DataAccessInterface api){
        double value = 0;
        for (Asset a: this.assetMap.values()){
            if(Objects.equals(a.getSymbol(), symbol)){
                a.updatePrice(api);
                value += a.getValue();
            }
        }
        return value;
    }

    /**
     * Return the volume of a specific type of asset
     * @param symbol the symbol of the queried type of asset
     * @return the total volume of the queried type of asset
     */
    public double getTypeVolume(String symbol){
        double volume = 0;
        for (Asset a: this.assetMap.values()){
            if(Objects.equals(a.getSymbol(), symbol)){
                volume += a.getVolume();
            }
        }
        return volume;
    }

    /**
     * Return the information of all type of asset, includes the symbol of each type of asset and the total volume and
     * total value of each type of asset.
     * @return A map, which Key is the symbol of the asset and the value is a double array, the first element in the
     * array is the total volume of this type of asset and the second element in the array is the total initialValue of
     * this type of asset
     */
    public Map<String, double[]> getInitialAssetInfo(){
        Map<String, double[]> result = new HashMap<>();
        for (Asset a: this.assetMap.values()){
            if(!result.containsKey(a.getSymbol())){
                result.put(a.getSymbol(),
                        new double[]{this.getTypeVolume(a.getSymbol()), this.getTypeInitialValue(a.getSymbol())});
            }
        }
        return result;
    }

    /**
     * Return am AssetSnapshot, which gives the information of the symbol of each type of asset and the total real
     * value of each type of asset
     * @param api YahooFinanceStockAPI
     * @return A Map, which Key is the symbol of the asset and the value is the total real value of this type of asset
     */
    public Map<String, Double> getAssetSnapshot(DataAccessInterface api){
        Map<String, Double> result = new HashMap<>();
        for (Asset a: this.assetMap.values()){
            if(a instanceof Currency){
                if (!result.containsKey(a.getSymbol())){
                    result.put(a.getSymbol(), this.getTypeInitialValue(a.getSymbol()));
                }
            }
            if (!result.containsKey(a.getSymbol())){
                result.put(a.getSymbol(), this.getTypeRealValue(a.getSymbol(), api));
            }
        }
        return result;
    }
}
