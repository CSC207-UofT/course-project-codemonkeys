package Assets;

import Containers.Transaction;
import Containers.Vote;
import Users.User;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

class AssetTest {
    private Vote vote;

    @Before
    public void setUp() {
        Stock tesla = new Stock();
        tesla.name = "Tesla";
        tesla.symbol = "TSLA";

        Asset<Stock> asset = new Asset<Stock>(10, 99, tesla);
        Asset<Stock> asset2 = new Asset<Stock>(15, 55, tesla);

        User bob = new User("Bob");

        Transaction trans = new Transaction(bob, asset, asset);

        Vote vote = new Vote(bob, trans, true);
    }

    @After
    public void tearDown() {
        vote = null;
    }

    @Test(timeout = 500)
    public void testVote(){

    }
}