package Entities;

import Entities.Identification.Identifiable;

import java.util.*;

public class Asset<T extends AssetType> extends Identifiable<T> {
    //____________________ Variables ___________________________________________________________________________________

    private User owner; // The owner of the asset
    private double volume; // The volume of the asset: ex. how many shares of X stock
    private double price; // The price per unit volume of the asset

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor.
     * @param volume is how much asset
     * @param price is how much $
     * @param type holds the information about the type of asset
     */
    public Asset(double volume, double price, T type) {
        super(type);
        this.volume = volume;
        this.price = price;
    }

    //____________________ Methods _____________________________________________________________________________________

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getVolume() {
        return volume;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }


}