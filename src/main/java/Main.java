import Assets.Asset;
import Assets.AssetType;
import Assets.Currency;
import Assets.Stock;
import Commands.*;
import Interfaces.CommandLine;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        /**
         * Create a stock
         */
        Stock tesla = new Stock();
        tesla.name = "Tesla";
        tesla.symbol = "TSLA";

        Currency usd = new Currency();
        usd.name = "United States Dollar";
        usd.symbol = "USD";

        /**
         * Make an asset for that stock
         */
        Asset<Stock> asset = new Asset<Stock>(10, 10, tesla);
        System.out.println(asset.getType().name);
        System.out.println(asset.getType().symbol);
        System.out.println(asset.getPrice());
        System.out.println(asset.getVolume());
        System.out.println(asset.getId());

        /**
         * Test the help command
         * TODO: implement functionality for other commands
         */

        Object[] a = {Kick.class, Help.class};

        // new Help().execute(new ArrayList(Arrays.asList(a)));

        CommandLine cmd = new CommandLine();
        boolean flag = true;
        while(flag) {
            flag = cmd.getCommand();
        }

//        Asset teslaStock = new Asset("TSLA", 3.123);
//        YahooFinanceAPI yahoo = new YahooFinanceAPI();
//        while (true) {
//            AssetManager.updateAssetPrice(teslaStock, yahoo);
//            double value = teslaStock.getValue();
//            double price = teslaStock.getPrice();
//            double quantity = teslaStock.getQuantity();
//            Thread.sleep(2000);
//
//            System.out.println(quantity + " Tesla Stock is now worth $" + value + " at price $" + price);
    }



}
