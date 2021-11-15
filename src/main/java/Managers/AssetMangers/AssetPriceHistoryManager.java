package Managers.AssetMangers;

import java.util.HashMap;
import Assets.Asset;
import java.util.*;


/**
 * Manages and stores the price history of existing assets. (Queue size 25)
 */


public class AssetPriceHistoryManager extends HashMap<Asset, Queue<Double>>{
    //____________________ Variables ___________________________________________________________________________________

    private static AssetPriceHistoryManager instance;

    //____________________ Constructors ________________________________________________________________________________
    private AssetPriceHistoryManager(){
        super();
    }

    //____________________ Methods _____________________________________________________________________________________
    public static AssetPriceHistoryManager getInstance() {return instance;}

    public void enqueueAssetPrice(Asset asset) {
        double price = asset.getPrice();

        if (!this.containsKey(asset)){
            Queue<Double> netQueue = new LinkedList<>();
            this.put(asset, netQueue);
        }

        Queue<Double> theQueue = this.get(asset);

        theQueue.add(price);

        if (theQueue.size() > 25)
            theQueue.remove();

    }
}



