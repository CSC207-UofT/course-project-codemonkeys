package Manager;

import Client.Portfolio;
import Client.Regular;

public class TradeManager {
    public boolean buy(Regular user, Portfolio portfolio, double price) {
        System.out.println("Trading...");
        user.netChange(price);
        System.out.println("Successfully bought " + portfolio.getName() + " with $" + price + ".");
        return true;
    }
}
