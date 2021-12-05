package Entities.Assets;

import Entities.Identification.Identifiable;

public class Asset extends Identifiable {

    private double volume; // The volume of the asset: ex. how many shares of X stock
    private double currentPrice; // The price per unit volume of the asset
    private final String type; // The string indicating the type of this particular asset
    private final String symbol;
    private double initialPrice;

    // We do not use symbol for now
    // TODO: add type to symbol database
    public Asset(double volume, double price, String type) {
        this(volume, price, type, null);
    }

    public Asset(double volume, double price, String type, String symbol) {
        this.type = type;
        this.volume = volume;
        this.symbol = symbol;
        this.initialPrice = price;
        this.currentPrice = price;
    }

    public String getType() {
        return this.type;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return this.currentPrice;
    }

    public void setPrice(double price) {
        this.currentPrice = price;
    }

    public double getValue() { // Dynamically calculated from current price
        return this.volume * this.currentPrice;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double price){
        this.initialPrice = price;
    }

    public double getInitialValue() {
        return this.volume * this.initialPrice;
    }

    public void updatePrice(DataAccessInterface source) {
        /*
          Updates asset price data from the provided data source.
         */
        this.setPrice(source.update(this.symbol));
    }

}