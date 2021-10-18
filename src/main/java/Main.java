<<<<<<< HEAD
import Client.Admin;
import Client.Portfolio;
import Client.Regular;
import Client.User;
import Manager.SessionManager;
import Manager.TradeManager;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Admin a = new Admin("A");
        Regular user = new Regular("User 1");
        Portfolio p1 = new Portfolio("P1");
        Portfolio p2 = new Portfolio("P2");

        SessionManager session1 = new SessionManager(1);
        session1.setAdmin(a);

        session1.addProduct(p1);
        session1.addProduct(p2);
        session1.display();

        System.out.println("Please enter a price to buy: ");


        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();

        boolean success = false;
        TradeManager trader1 = new TradeManager();
        if (session1.tradable(user, p1)) {
            success = trader1.buy(user, p1, price);
        }
        if (success) {
            session1.remove(p1);
        }
=======

import Entities.Asset;
import Interfaces.YahooFinanceAPI;
import UseCases.AssetManager;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import Interfaces.CommandLine;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
>>>>>>> Andrew
    }
}
