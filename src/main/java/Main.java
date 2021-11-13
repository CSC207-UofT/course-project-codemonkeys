import Entities.Asset;
import Entities.Stock;
import Interfaces.CommandLine;
import UseCases.Commands.*;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Asset<Stock> asset = new Asset(10, 10 );

        /**
         * Test the help command
         * TODO: implement functionality for other commands
         */

        Object[] a = {Kick.class, Help.class};

        new Help().execute(new ArrayList(Arrays.asList(a)));

        CommandLine cmd = new CommandLine();

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
