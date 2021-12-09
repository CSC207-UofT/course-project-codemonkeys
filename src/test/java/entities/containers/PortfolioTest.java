package entities.containers;

import entities.assets.Asset;
import entities.assets.Currency;
import entities.assets.Stock;
import entities.users.User;
import org.junit.*;
import usecase.portfolio.Portfolio;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    Portfolio portfolio;
    Asset currency;
    Asset currency2;
    Asset stock;
    Asset stock2;
    Transaction transaction;
    User user;
    Vote vote;

    @Before
    public void setUp() {
        currency = new Currency(120, 7, "American Dollar", "USD");
        currency2 = new Currency(200, 1, "Chinese Yuan", "CNY");
        stock = new Stock(100, 124, "Tesla", "TSLA");
        stock2 = new Stock(200, 524, "Apple", "APLE");
        user = new User("a");
        transaction = new Transaction(user, currency, stock);
        vote = new Vote(user, true);
        portfolio = new Portfolio();
        portfolio.add(currency);
        portfolio.add(currency2);
        portfolio.add(stock);
        portfolio.add(stock2);
        portfolio.add(transaction);
        portfolio.add(vote);

    }

    @After
    public void tearDown() {
        portfolio.sub(currency);
        portfolio.sub(currency2);
        portfolio.sub(stock2);
        portfolio.sub(stock);
        portfolio.sub(transaction);
        portfolio.sub(vote);
        currency = null;
        currency2 = null;
        stock = null;
        stock2 = null;
    }

    @Test(timeout = 500)
    public void testSpecificValue(){
        double actual = portfolio.getValue("TSLA");
        double expected = 100 * 124;
        assertEquals(actual, expected);
    }

    @Test(timeout = 500)
    public void testTotalValue(){
        double actual = portfolio.getValue();
        double expected = (120 * 7) + 200 + (100 * 124) + (200 * 524);
        assertEquals(actual, expected);
    }


    @Test(timeout = 500)
    public void testSubAsset(){
        // Since the sub methods are the same for asset, transaction and vote, we only
        // need to test one of them.
        portfolio.sub(currency);
        assertFalse(portfolio.getAssetList().contains(currency));
        assertNull(portfolio.get(currency.id));
    }

    @Test(timeout = 500)
    public void testOther(){
        portfolio.setProfitability(0);
        assertEquals(0, portfolio.getProfitability());
        assertEquals(1, portfolio.getVotingHistory().size());
    }
}