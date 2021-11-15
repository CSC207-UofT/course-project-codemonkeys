package Assets;

import Users.User;
import Identification.Identifiable;

public class Asset<T extends AssetType> extends Identifiable {

    private double volume; // The volume of the asset: ex. how many shares of X stock
    private double price; // The price per unit volume of the asset
    private final T type; // The ? extends AssetType indicating the type of this particular asset

    public Asset(double volume, double price, T type) {
        this.type = type;
        this.volume = volume;
        this.price = price;
    }

    public T getType() {
        return this.type;
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