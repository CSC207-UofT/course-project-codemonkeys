package Entities.Assets;

public class Stock extends Asset{
    private double marketCap;
    private double twentyFourChange;

    public Stock(double volume, double price, String type, String symbol) {
        super(volume, price, type, symbol);
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double price) {
        this.marketCap = price;
    }

    public double getTwentyFourChange() {
        return twentyFourChange;
    }

    public void setTwentyFourChange(double change) {
        this.twentyFourChange = change;
    }
}
