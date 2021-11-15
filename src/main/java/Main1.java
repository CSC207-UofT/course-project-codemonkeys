import Assets.Asset;
import Assets.AssetType;
import Assets.Stock;
import Commands.Help;
import Commands.Kick;
import Interfaces.CommandLine;
import Interfaces.YahooFinanceAPI;
import Managers.AssetMangers.AssetManager;
import Managers.AssetMangers.AssetPriceManager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main1 {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Stock tesla = new Stock();
        tesla.symbol = "TSLA";

        Asset teslaStock = new Asset(1,0.0, tesla);
        YahooFinanceAPI yahoo = new YahooFinanceAPI();
        while (true) {
            AssetPriceManager.updateAssetPrice(teslaStock, yahoo);
            double value = teslaStock.getValue();
            double price = teslaStock.getPrice();

            Thread.sleep(2000);

            System.out.println(" Tesla Stock is now worth $" + value + " at price $" + price);
    }}
}
