import Assets.Asset;
import Containers.Portfolio;
import Containers.Transaction;
import Managers.TransactionManager;
import Managers.UserManager;
import Managers.VoteManager;
import Users.Admin;
import Users.User;

import javax.sound.sampled.Port;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Admin admin = new Admin("admin");
        User user1 = new User ("User1");
        User  user2 = new User ("User2");
        User  user3 = new User ("User3");

        Asset currency = new Asset(10, 1.0, "USD", "$");
        Asset stock = new Asset(10, 2.0, "GOOGLE", "SS");

        UserManager.getInstance().addUser(admin);
        UserManager.getInstance().addUser(user1);
        UserManager.getInstance().addUser(user2);
        UserManager.getInstance().addUser(user3);

        Portfolio.getInstance().add(currency);
        Portfolio.getInstance().add(stock);
        Portfolio.getInstance().add(stock);

        System.out.println(Portfolio.getInstance());

/*
        Asset currencySpent = new Asset(4, 1.0, "USD", "$");
        Asset stockGained = new Asset(2, 2.0, "GOOGLE", "SS");

        Transaction transaction = new Transaction(admin, currencySpent, stockGained);
        VoteManager.getInstance().createVote(transaction);

        VoteManager.getInstance().doUpVote(transaction, user1);
        VoteManager.getInstance().doDownVote(transaction, user2);
        VoteManager.getInstance().doUpVote(transaction, user3);

        VoteManager.getInstance().performTransaction(transaction);

        transaction = new Transaction(admin, currencySpent, stockGained);
        VoteManager.getInstance().createVote(transaction);

        VoteManager.getInstance().doUpVote(transaction, admin);
        VoteManager.getInstance().doDownVote(transaction, user2);
        VoteManager.getInstance().doUpVote(transaction, user3);

        System.out.println(Portfolio.getCommonPortfolio());
        System.out.println(TransactionManager.getInstance());
        System.out.println(VoteManager.getInstance());*/

    }
}
