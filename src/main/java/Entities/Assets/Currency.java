package Entities.Assets;

// Can be considered as pool assets. In this case, the volume is the amount of money and price is 1 or ratio with USD.
public class Currency extends Asset{
    public Currency(double volume, double price, String type, String symbol) {
        super(volume, price, type, symbol);
    }

    @Override
    public void updatePrice(DataAccessInterface source) {
        /*
          Do nothing upon price update for the time being
         */
    }
}
