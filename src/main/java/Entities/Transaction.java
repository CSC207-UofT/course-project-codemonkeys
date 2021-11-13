package Entities;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private User initializer;
    private String from_type;
    private String to_type;
    private double from_price;  // the price of the to_type
    private double from_quantity;  // the quantity of the to_type
    private double to_price;  // the price of the to_type
    private double to_quantity;  // the quantity of the to_type

    private Transaction(UUID id, String from, User initializer, String to,
                        double from_price, double from_quantity, double to_price, double to_quantity){
        this.id = id;
        this.from_type = from;
        this.to_type = to;
        this.from_price = from_price;
        this.from_quantity = from_quantity;
        this.to_price = to_price;
        this.to_quantity = to_quantity;
        this.initializer = initializer;
    }


    public UUID getId() {
        return this.id;
    }

    public String getFrom_type() {
        return this.from_type;
    }

    public String getTo_type() {
        return this.to_type;
    }

    public double getFrom_price() {
        return this.from_price;
    }

    public double getFrom_quantity() {
        return this.from_quantity;
    }

    public double getTo_price() {
        return this.to_price;
    }

    public double getTo_quantity() {
        return this.to_quantity;
    }

    public User getInitializer(){return this.initializer;}


}
