package Managers;
import Assets.Asset;
import Containers.Transaction;
import Users.User;

import java.util.UUID;
import java.util.*;

/**
 * @Author: Raymond Zhang
 */

public class TransactionManager extends HashMap<UUID, Transaction>{

    //_______________________________________________ Variables ________________________________________________________

    private static TransactionManager instance;

    //______________________________________________ Constructors ______________________________________________________

    private TransactionManager() {
        super();
    }

    static {
        instance = new TransactionManager();
    }

    //_________________________________________________ Methods ________________________________________________________

    /**
     * Gets the singleton instance
     * @return the instance
     */
    public static TransactionManager getInstance() {
        return instance;
    }

    /**
     * Initiate a transaction component-wise
     * @param initiator is the person who is starting the transaction
     * @param in is the Asset to be exchanged
     * @param out is the Asset to be exchanged for
     */
    public void add(User initiator, Asset in, Asset out){
        Transaction transaction = new Transaction(initiator, in, out);
        this.put(transaction.getId(), transaction);
    }

    /**
     * Add a transaction to the TransactionManager
     * @param transaction is the Transaction to add
     */
    public void add(Transaction transaction){
        this.put(transaction.getId(), transaction);
    }

    public UUID getid(Transaction transaction){
        for (Map.Entry<UUID, Transaction> entry : instance.entrySet()) {
            if(entry.getValue() == transaction){
                return entry.getKey();
            }
        }
        return null;
    }

}