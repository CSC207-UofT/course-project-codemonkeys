package usecase.managers;
import static org.junit.jupiter.api.Assertions.*;

import entities.assets.Currency;
import entities.assets.Stock;
import entities.containers.Transaction;
import entities.containers.Vote;
import entities.users.User;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoteManagerTest {
    VoteManager vm = VoteManager.getInstance();
    Currency currency1, currency2;
    Stock stock1, stock2;
    Transaction transaction1, transaction2;
    User user1, user2, user3, user4, user5;
    Vote vote1, vote2, vote3, vote4, vote5, vote6, vote7, vote8, vote9;

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
    }

    @After
    public void tearDown(){
        vm.removeTrans(transaction1);
        vm.removeTrans(transaction2);
    }

    @Test
    public void testVoteFor(){
        assertEquals(transaction1, vm.voteFor(vote1));
        assertEquals(transaction2, vm.voteFor(vote2));
    }

    @Test
    public void testGetVotes(){
        assertEquals(new ArrayList<>(Arrays.asList(vote1, vote3, vote4, vote5)), vm.getVotes(transaction1));
        assertEquals(new ArrayList<>(Arrays.asList(vote2, vote6, vote7, vote8, vote9)), vm.getVotes(transaction2));
        System.out.println(vm.viewVote());
        System.out.println(vm.viewVote(transaction1));
    }

    @Test
    public void testGetVoters(){
        assertEquals(new ArrayList<>(Arrays.asList(user1, user2, user3, user4)), vm.getVoters(transaction1));
        assertEquals(new ArrayList<>(Arrays.asList(user2, user1, user3, user4, user5)), vm.getVoters(transaction2));
    }

    @Test
    public void testGetUpVoters(){
        assertEquals(new ArrayList<>(Arrays.asList(user1, user3)), vm.getUpVoters(transaction1));
        assertEquals(new ArrayList<>(Arrays.asList(user2, user1, user3, user5)), vm.getUpVoters(transaction2));
    }

    @Test
    public void testGetDownVoters(){
        assertEquals(new ArrayList<>(Arrays.asList(user2, user4)), vm.getDownVoters(transaction1));
        assertEquals(new ArrayList<>(List.of(user4)), vm.getDownVoters(transaction2));
    }

    @Test
    public void testNumUpVoters(){
        assertEquals(2, vm.numUpVoters(transaction1));
        assertEquals(4, vm.numUpVoters(transaction2));
    }

    @Test
    public void testNumDownVoters(){
        assertEquals(2, vm.numDownVoters(transaction1));
        assertEquals(1, vm.numDownVoters(transaction2));
    }
}
