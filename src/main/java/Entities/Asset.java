package Entities;

import Entities.Identification.Identifiable;

import java.util.*;

public class Asset<T extends AssetType> extends Identifiable<T> {
    //____________________ Variables ___________________________________________________________________________________

    private User owner;
    private double volume;
    private double price;

    //____________________ Constructors ________________________________________________________________________________

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Asset(double volume, double price, T type) {
        super(type);
        this.volume = volume;
        this.price = price;
    }

    //____________________ Methods _____________________________________________________________________________________

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