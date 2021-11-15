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

public class Cryptocurrency extends AssetType {
    public int rank;
    public String name;
    public String symbol;
    public double marketCap;
    public double price;
    public double circulatingSupply;
    public double volume24h;
    public double deltaPercent1h;
    public double deltaPercent24h;
    public double deltaPercent7d;

}
