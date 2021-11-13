package Managers;
import Assets.Asset;
import Containers.Transaction;
import Users.User;

import java.util.UUID;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Author: Raymond Zhang
 */

public class TransactionManager {
    private static TransactionManager instance;
    private HashMap<UUID, Transaction> transactionHashMap;

    private TransactionManager() {
        this.transactionHashMap = new HashMap<UUID, Transaction>();
    }

    static {
        instance = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return instance;
    }

    public void add(User user, Asset in, Asset out) {
        Transaction trans = new Transaction(user, in, out);
        this.transactionHashMap.put(trans.getId(), trans);
    }

    public void add(Transaction transaction){
        this.transactionHashMap.put(transaction.getId(), transaction);
    }

    public HashMap<UUID, Transaction> getTransactions() {
        return this.transactionHashMap;
    }

    public boolean hasTransaction(UUID id) {
        return this.transactionHashMap.containsKey(id);
    }

    public void delete(Transaction trans) {
        this.transactionHashMap.remove(trans.getId());
    }

    public void delete(UUID id) {
        this.transactionHashMap.remove(id);
    }
}