package Assets;

public class Stock extends AssetType{
    public int rank;
    public String name;
    public String symbol;
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

