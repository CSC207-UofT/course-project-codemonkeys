package Entities.Containers;

import Entities.Assets.Stock;
import Entities.Users.User;
import org.junit.*;
import Entities.Assets.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    User u1;
    Currency currency;
    Stock stock;
    Transaction transaction;

    @Before
    public void setUp() {
        u1 = new User("test");
        currency = new Currency(120, 7, "American Dollar", "USD");
        stock = new Stock(100, 124, "Tesla", "TSLA");
        transaction = new Transaction(u1, currency, stock);
    }

    @After
    public void tearDown() {
        u1 = null;
        currency = null;
        stock = null;
        transaction = null;
    }

    @Test(timeout = 500)
    public void testCheckIsValid(){
        System.out.println(transaction.toString());
        assertFalse(transaction.checkIsValid()); // Because the currency is not enough to buy the stock.
    }


}