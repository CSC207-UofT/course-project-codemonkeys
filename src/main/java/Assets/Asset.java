package Assets;

import Identification.Identifiable;

public class Asset extends Identifiable {

    private double volume; // The volume of the asset: ex. how many shares of X stock
    private double price; // The price per unit volume of the asset
    private final String type; // The string indicating the type of this particular asset
    private final String symbol;

    // We do not use symbol for now
    // TODO: add type to symbol database
    public Asset(double volume, double price, String type) {
        this(volume, price, type, null);
    }

    public Asset(double volume, double price, String type, String symbol) {
        this.type = type;
        this.volume = volume;
        this.price = price;
        this.symbol = symbol;
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
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() { // Dynamically calculated from current price
        return this.volume * this.price;
    }

}