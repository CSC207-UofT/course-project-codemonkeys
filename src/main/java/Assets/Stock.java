package Assets;

public class Stock implements AssetType{
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
    /**
     * add more information about the stock
     */

}

