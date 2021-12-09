package usecase.portfolio.portfolioHelper;

import usecase.portfolio.Processor;
import entities.containers.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the concrete class for processing transactions
 * It includes getters, add and remove methods
 *
 * Author Zixin (Charlie) Guo
 * Date: Dec 05 2021
 * Version: 1.0
 */

public class TransactionProcessor extends Processor {
    // transactionHistory: a list of historical transaction in the portfolio
    private final List<Transaction> transactionHistory;

    public TransactionProcessor(){
        this.transactionHistory = new ArrayList<>();
    }

    // Add a transaction to the system.
    public void add(Transaction transaction) {
        if(transaction != null){
            this.transactionHistory.add(transaction);
        }
    }

    public void sub(Transaction transaction0) {
        if (this.transactionHistory.contains(transaction0)) {
            this.transactionHistory.remove(transaction0);
        }
        else{
            System.out.println("Current portfolio does not contain " + transaction0);
        }
    }

    public List<Transaction> getTransactionList() {
        return transactionHistory;
    }
}
