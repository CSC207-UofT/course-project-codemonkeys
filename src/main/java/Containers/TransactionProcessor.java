package Containers;

import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor extends Processor{
    // transactionHistory: a list of historical transaction in the portfolio
    private List<Transaction> transactionHistory;

    public TransactionProcessor(){
        this.transactionHistory = new ArrayList<>();
    }

    // Add an transaction to the system.
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
