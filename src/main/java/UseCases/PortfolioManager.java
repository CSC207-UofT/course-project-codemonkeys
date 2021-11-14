package UseCases;
import Entities.Portfolio;
import Entities.User;
import Entities.Asset;
import UseCases.TransactionManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class PortfolioManager {
    private  Map<User, Portfolio> portfoliomap;

    private PortfolioManager() {
        this.portfoliomap = new HashMap<>();
    }

    public void addPortfolio(User name) {
        this.portfoliomap.put(name, name.getPortfolio());
    }

    public void delPortfolio(User name) {
        this.portfoliomap.remove(name);
    }

    public double getgloablvalue() {
        double value = 0;
        for(Portfolio p: this.portfoliomap.values()) {
            value += p.GetTotalValue();
        }
        return value;
    }

    //public double getprofit() {}
}
