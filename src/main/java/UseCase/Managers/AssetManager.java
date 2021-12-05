package UseCase.Managers;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.DataAccessInterface;
import Entities.Assets.Stock;

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

    public List<Asset> getAssetList () {
        ArrayList<Asset> assetList = new ArrayList<Asset>();

        for (UUID id : assetMap.keySet()) {
            assetList.add(assetMap.get(id));
        }

        return assetList;
    }

    public void addAsset(Asset a){
        for (Asset asset : assetMap.values()) {
            if (asset.getSymbol().equals(a.getSymbol()) && a.getClass() == asset.getClass()){
                double volume = asset.getVolume() + a.getVolume();
                double bookingPrice = (asset.getInitialValue() + a.getInitialValue()) / volume;
                if (a instanceof Currency){
                    Asset newAsset = new Currency(volume, bookingPrice, a.getType(), a.getSymbol());
                    this.assetMap.remove(asset.id);
                    this.assetMap.put(newAsset.id, newAsset);
                }
                if (a instanceof Stock){
                    Asset newAsset = new Stock(volume, bookingPrice, a.getType(), a.getSymbol());
                    this.assetMap.remove(asset.id);
                    this.assetMap.put(newAsset.id, newAsset);
                }
                return;
            }
        }
        this.assetMap.put(a.id, a);
    }

    public void removeAsset(Asset a) {
        this.assetMap.remove(a.id);
    }

    public void delAsset(Asset a) {
        for (Asset asset : assetMap.values()) {
            if (asset.getSymbol().equals(a.getSymbol()) && a.getClass() == asset.getClass()) {
                double volume = asset.getVolume() - a.getVolume();
                if (volume == 0) {
                    this.assetMap.remove(a.id);
                    return;
                }
                if (a instanceof Currency){
                    Asset newAsset = new Currency(volume, asset.getInitialPrice(), a.getType(), a.getSymbol());
                    this.assetMap.remove(asset.id);
                    this.assetMap.put(newAsset.id, newAsset);
                }
                if (a instanceof Stock){
                    Asset newAsset = new Stock(volume, asset.getInitialPrice(), a.getType(), a.getSymbol());
                    this.assetMap.remove(asset.id);
                    this.assetMap.put(newAsset.id, newAsset);
                }
                return;
            }
        }
    }
    /**
     * @param api the YahooFinanceStockAPI
     * @return the total value of assets in the group
     */
    public double getValue (DataAccessInterface api) {
        double value = 0;
        for (Asset a: this.getAssetList()){
            if (a instanceof Stock){
                a.updatePrice(api);
            }
            value += a.getValue();
        }
        return value;
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

    /**
     *the string representation to show the details about assets in the assetManager.
     @return A string of assets information in the assetManager.
     */
    public String viewAssets(DataAccessInterface api) {
        StringBuilder sb = new StringBuilder("Your assets: \n");
        for(Asset asset : this.getAssetList()) {
            asset.updatePrice(api);
            sb.append("Asset ID: ").append(asset.id);
            sb.append(", Symbol: ");
            sb.append(asset.getSymbol());
            sb.append(", Volume: ").append(asset.getVolume());
            sb.append(", booking price: ").append(asset.getInitialPrice());
            sb.append(", booking value: ").append(asset.getInitialValue());
            sb.append(", present price: ").append(asset.getPrice());
            sb.append(", present value: ").append(asset.getValue()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public boolean findAsset(UUID id){
        return this.assetMap.containsKey(id);
    }

    public Asset getAsset(UUID id){
        return this.assetMap.get(id);
    }
}
