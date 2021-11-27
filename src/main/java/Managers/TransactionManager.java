package Managers;

import Assets.DataAccessInterface;
import Containers.Transaction;

import java.util.*;

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
    public static TransactionManager getInstance(){
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
    public UUID getId(Transaction transaction){
        UUID answer = null;
        for (Map.Entry<UUID, Transaction> t : this.transactionMap.entrySet()) {
            if (t.getValue().equals(transaction)) {
                answer = t.getKey();
            }
        }
        return answer;
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

    /**
     * return the number of transaction contains in the manager
     * @return the number of transaction contained
     */
    public int size(){
        return transactionMap.size();
    }

    public void executeTransaction(boolean executable, Transaction transaction, DataAccessInterface api){
        new TransactionExecutor().execute(executable, transaction, api);
    }

    public List<Transaction> view(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>(this.transactionMap.values());
        return transactions;
    }
}
