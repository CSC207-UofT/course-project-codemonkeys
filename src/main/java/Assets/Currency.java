package Assets;

public class Currency extends AssetType {
    public String name;
    public String symbol;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    public double usdPerUnit;

}
