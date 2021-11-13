package Entities;

public class Stock extends Asset {

    public Stock (String symbol) {
        super(symbol);
        this.setType("Stock");
    }

    public String tradeMec() {return "stock trading mechanism";}

}
