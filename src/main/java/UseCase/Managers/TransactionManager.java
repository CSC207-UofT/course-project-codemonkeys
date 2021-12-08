package UseCase.Managers;

import Entities.Containers.Transaction;
import UseCase.Commands.ReadWriter;
import UseCase.Commands.TransactionReadWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * This is a Class for managing the Transactions that have not yet completed.
 * It includes add, delete, search for Transactions
 *
 * Author Raymond Zhang
 * Date: Nov 24 2021
 * Version: 1.0
 */
public class TransactionManager implements Serializable {

    private static TransactionManager instance;
    private HashMap<UUID, Transaction> transactionMap;
    private static final ReadWriter<TransactionManager> rw = new TransactionReadWriter();

    /*
      Default Constructors
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
     * @param transaction that need to be stored
     */
    public void addTransaction(Transaction transaction){
        this.transactionMap.put(transaction.id, transaction);
    }

    /**
     * Gets the singleton instance
     * @return instance
     */
    public static TransactionManager getInstance() {
        return instance;
    }

    public static void load(){
        try{
            instance = rw.readFromFile("./output/transactionManager.ser");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Read Transaction Manager Error: " + e.getMessage());
        }
    }

    // serialize the current transaction manager
    public void save() {
        try {
            rw.saveToFile("./output/transactionManager.ser", instance);
        }
        catch (IOException e){
            System.out.println("Save Transaction Manager Error: " + e.getMessage());
        }
    }
    /**
     * Remove the Transaction based on UUID provided
     * @param uuid is the uuid
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

    /**
     * return a list of pending transactions
     * @return list of transactions
     */
    public List<Transaction> view(){
        return new ArrayList<>(this.transactionMap.values());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Current Transactions In Progress: \n");
        for(Transaction t: this.transactionMap.values()){
            sb.append(t.toString());
        }
        return sb.toString();
    }

}
