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
    }
}
