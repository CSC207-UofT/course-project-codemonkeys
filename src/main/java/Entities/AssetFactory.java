package Entities;

public class AssetFactory {
    public Asset getAsset(String assetType, String symbol) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("Stock")) {
            return new Stock(symbol);
        } else if (assetType.equalsIgnoreCase("Cryptocurrency")) {
            return new Cryptocurrency();
        } else if (assetType.equalsIgnoreCase("USD")) {
            return new USD();
        } else {
            return new Asset();
        }

    }
}
