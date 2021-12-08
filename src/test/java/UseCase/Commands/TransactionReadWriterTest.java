package UseCase.Commands;

import Entities.Assets.Asset;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Entities.Users.User;
import UseCase.Managers.TransactionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TransactionReadWriterTest {
    private Transaction[] transactions;
    private Asset[] assets;
    private final TransactionManager tm = TransactionManager.getInstance();
    private User user;
    private TransactionReadWriter trw;

    @Before
    public void setUp() {
        transactions = new Transaction[10];
        assets = new Asset[10];
        user = new User("dog");
        trw = new TransactionReadWriter();
        for (int i = 0; i < 10; i++) {
            assets[i] = new Stock(i, 10 * i, "stock", "ABC");
            transactions[i] = new Transaction(user, assets[i], assets[i]);
            tm.addTransaction(transactions[i]);
        }

    }

    @After
    public void tearDown() {
        for (Transaction transaction : tm.view()) {
            tm.remove(transaction.getId());
        }
        transactions = null;
        assets = null;
        user = null;
        trw = null;
    }

    @Test(timeout = 500)
    public void testReadWrite() throws IOException, ClassNotFoundException {
        trw.saveToFile("./transactionManager.ser", tm);
        TransactionManager newManager = trw.readFromFile("./transactionManager.ser");
        assert(newManager.view().size() == tm.view().size() && newManager.view().size()  == 10);
        }
    }

