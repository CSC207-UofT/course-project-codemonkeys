package Assets;

public class Cryptocurrency implements AssetType {

    private String symbol;
    private String name;

    public String tradeMec() {return "Cryptocurrency trading mechanism";}

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}
