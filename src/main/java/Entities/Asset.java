package Entities;

public class Asset {
    //____________________ Variables ___________________________________________________________________________________
    private final String symbol;  // Symbol representing the asset
    private double price; // price of the asset in USD
    private final double quantity; // value of the asset in USD

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for an Clients.Asset
     * @param symbol is the symbol of the asset listed on exchanges
     * @param quantity is the value of the asset in USD
     */
    public Asset(String symbol, Double quantity){
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = 0.0;
    }

    //____________________ Methods _____________________________________________________________________________________


    //____________________ Generic Overrides ___________________________________________________________________________


    //____________________ Getters and Setters__________________________________________________________________________

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() { return quantity; }

    public double getValue() {
        return price * quantity;
    }
}