package Assets;

public class Currency implements AssetType {

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
}
