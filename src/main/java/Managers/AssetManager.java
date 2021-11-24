package Managers;

import Assets.Asset;

import java.util.*;

public class AssetManager {
    private final Map<UUID, Asset> assetMap;

    //create an object of AssetManager
    private static final AssetManager instance = new AssetManager();

    private AssetManager() {this.assetMap = new HashMap<>();}

    //Get the only object available
    public static AssetManager getInstance() {return instance;}

    public void addAsset(Asset a){
        this.assetMap.put(a.id, a);
    }

    public void delAsset(Asset a){
        this.assetMap.remove(a.id);
    }

    /**
     * Return the value of a specific type of asset
     * @param symbol the symbol of the queried type of asset
     * @return the total value of the queried type of asset
     */
    public double getTypeValue(String symbol){
        double value = 0;
        for (Asset a: this.assetMap.values()){
            if(Objects.equals(a.getSymbol(), symbol)){
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

    /**Return the information of all type of asset, includes the symbol of each type of asset and the total volume and
     * total value of each type of asset.
     * @return A map, which Key is the symbol of the asset and the value is a double array, the first element in the
     * array is the total volume of this type of asset and the second element in the array is the total value of this
     * type of asset
     */
    public Map<String, double[]> getAssetInfo(){
        Map<String, double[]> result = new HashMap<>();
        for (Asset a: this.assetMap.values()){
            if(!result.containsKey(a.getSymbol())){
                result.put(a.getSymbol(),
                        new double[]{this.getTypeVolume(a.getSymbol()), this.getTypeValue(a.getSymbol())});
            }
        }
        return result;
    }
    // Todo: Add method to calculate global profit once the API is added

}
