package Managers;

import Containers.Transaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.UUID;

/**
 * This is a Class for managing the Transactions that have not yet completed.
 * It includes add, delete, search for Transactions
 *
 * Author Raymond Zhang
 * Date: Nov 24 2021
 * Version: 1.0
 */
public class TransactionManager {

    private static TransactionManager instance;
    private HashMap<UUID, Transaction> transactionMap;

    /**
     * Default Constructors
     */
    static{
        TransactionManager.instance = new TransactionManager();
    }

    private TransactionManager(){
        this.transactionMap = new LinkedHashMap<>();
    }

    //_________________________________________________ Methods ________________________________________________________

    /**
     * Add a new Transaction into the Transactions
     * @param transaction
     */
    public void addTransaction(Transaction transaction){
        this.transactionMap.put(transaction.id, transaction);
    }

    /**
     * Gets the singleton instance
     * @return instance
     */
    public TransactionManager getInstance(){
        return TransactionManager.instance;
    }

    /**
     * Remove the Transaction based on UUID provided
     * @param uuid
     */
    public void remove(UUID uuid){
        this.transactionMap.remove(uuid);
    }

    /**
     * Get the Transactions with given id
     * @param id is the UUID of the Transaction
     * @return the Transaction that corresponding to the id provided
     */
    public Transaction getTransactions(UUID id){
        return this.transactionMap.get(id);
    }

    /**
     * Get the id with given Transaction
     * @param transaction is a non completed Transaction
     * @return the id of given Transaction
     */
    public Transaction getId(Transaction transaction){
        return this.transactionMap.get(transaction);
    }

    /**
     * Check if the id has a Transaction that is in the manager
     * @param id the UUID of the Transaction
     * @return true if the UUID is in the manager otherwise return false.
     */
    public boolean checkTransactions(UUID id){
        return this.transactionMap.containsKey(id);
    }

    /**
     * Check if the id has a Transaction that is in the manager
     * @param transaction a non completed Transaction
     * @return true if the Transaction is in the manager otherwise return false.
     */
    public boolean checkTransactions(Transaction transaction){
        return this.transactionMap.containsValue(transaction);
    }



}
