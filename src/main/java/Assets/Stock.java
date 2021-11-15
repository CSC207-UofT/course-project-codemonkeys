package Assets;

public class Stock extends AssetType{
    public int rank;
    public String name;
    public String symbol;

    public boolean liquid;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    public String company;
    public double marketCap;

    /**
     * add more information about the stock
     */


    @Override
    public String toString() {
        return name + " (" + symbol + ") " + "Stock. " + company;
    }
}

