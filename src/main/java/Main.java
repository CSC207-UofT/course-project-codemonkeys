import Interfaces.CommandLine;
import UseCases.Commands.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        CommandLine cmd = new CommandLine();

        /**
         * Test the help command
         * TODO: implement functionality for other commands
         */
        new Help().execute();

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
