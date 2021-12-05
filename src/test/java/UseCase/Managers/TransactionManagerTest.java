package UseCase.Managers;

import Entities.Assets.Asset;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Entities.Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionManagerTest {
    private Transaction[] transactions;
    private Asset[] assets;
    private TransactionManager tm = TransactionManager.getInstance();
    private User user;

    @Before
    public void setUp() {
        /*
          Setup
          1. Clear TransactionManager
          2. Refresh transactions and assets
          3. Make assets with volume = i and price = i*10
          4. Make transactions with those assets
          5. Put those transactions in the transaction manager
         */
        transactions = new Transaction[10];
        assets = new Asset[10];
        user = new User("dog");

        for (int i = 0; i < 10; i++){
            assets[i] = new Stock(i, 10*i, "stock", "ABC");
            transactions[i] = new Transaction(user, assets[i], assets[i]);
            tm.addTransaction( transactions[i]);
        }

    }

    @After
    public void tearDown() {

    }

    @Test(timeout = 500)
    public void testTransactionManager(){
        /*
         * Testing:
         * 1. Remove a transaction
         * 2. Test to see if the transaction is still in the TransactionManager
         * 3. Test to see if the price of the 9th transaction added is the same as how we set it
         * 4. Test to see if TransactionManager now has only 9 transactions
         * 5. Test to see if TransactionManager return the correct UUID.
         * 6. Add a transaction
         */
        tm.remove(transactions[0].getId()); // 1
        assertFalse(tm.checkTransactions(transactions[0]) ||
                tm.checkTransactions(transactions[0].getId())); // 2
        assertEquals(90 ,tm.getTransactions(transactions[9].getId()).buy.getPrice(),0.1); // 3
        //assertEquals(9, tm.size()); // 4
        assertEquals(transactions[1].getId(), tm.getId(transactions[1])); // 5
        tm.addTransaction(new Transaction(user, assets[1], assets[2])); //6
        //assertEquals(10, tm.size()); //6
    }
}