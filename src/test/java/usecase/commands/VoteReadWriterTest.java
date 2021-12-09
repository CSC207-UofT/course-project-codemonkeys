package usecase.commands;

import entities.assets.Currency;
import entities.assets.Stock;
import entities.containers.Transaction;
import entities.containers.Vote;
import entities.users.User;
import usecase.managers.VoteManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class VoteReadWriterTest {
    VoteManager vm = VoteManager.getInstance();
    Currency currency1, currency2;
    Stock stock1, stock2;
    Transaction transaction1, transaction2;
    User user1, user2, user3, user4, user5;
    Vote vote1, vote2, vote3, vote4, vote5, vote6, vote7, vote8, vote9;
    VoteReadWriter vrw;

    @Before
    public void setUp() {
        user1 = new User("test1");
        user2 = new User("test1");
        user3 = new User("test1");
        user4 = new User("test1");
        user5 = new User("test1");
        vote1 = new Vote(user1, true);
        vote2 = new Vote(user2, true);
        vote3 = new Vote(user2, false);
        vote4 = new Vote(user3, true);
        vote5 = new Vote(user4, false);
        vote6 = new Vote(user1, true);
        vote7 = new Vote(user3, true);
        vote8 = new Vote(user4, false);
        vote9 = new Vote(user5, true);
        currency1 = new Currency(500, 1, "American Dollar", "USD");
        currency2 = new Currency(600, 1, "American Dollar", "USD");
        stock1 = new Stock(10, 124, "Tesla", "TSLA");
        stock2 = new Stock(10, 200, "Tesla", "TSLA");
        transaction1 = new Transaction(user1, currency1, stock1);
        transaction2 = new Transaction(user2, currency2, stock2);
        vm.addVote(transaction1, vote1);
        vm.addVote(transaction1, vote3);
        vm.addVote(transaction1, vote4);
        vm.addVote(transaction1, vote5);
        vm.addVote(transaction2, vote2);
        vm.addVote(transaction2, vote6);
        vm.addVote(transaction2, vote7);
        vm.addVote(transaction2, vote8);
        vm.addVote(transaction2, vote9);
        vrw = new VoteReadWriter();
    }

    @After
    public void tearDown(){
        vm.removeTrans(transaction1);
        vm.removeTrans(transaction2);
    }

    @Test(timeout = 500)
    public void testReadWrite() throws IOException, ClassNotFoundException {
        vrw.saveToFile("./voteManager.ser", vm);
        VoteManager newManager = vrw.readFromFile("./voteManager.ser");
        assert(newManager != null);
    }
}
