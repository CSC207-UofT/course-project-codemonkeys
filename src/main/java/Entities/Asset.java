package Entities;

import java.util.ArrayList;
import java.util.List;

public class Asset {
    //____________________ Variables ___________________________________________________________________________________
    private String type;
    private List<Transaction> transactionList;
    //____________________ Constructors ________________________________________________________________________________

    public Asset(String type){
        this.type = type;
        this.transactionList = new ArrayList<Transaction>();
    }

    public String getType() {
        return type;
    }

    public void addTransaction(Transaction t) {
        this.transactionList.add(t);
    }

    public static boolean transfer(Asset from, Asset to, double value) {
        if (from.getTotalValue() < value) {
            return false;  // transaction denied
        }
        Transaction[] t = Transaction.generateTransactionPair(from.getType(), to.getType(), value);
        from.addTransaction(t[0]);
        to.addTransaction(t[1]);
        return true;  // Transaction approved.
    }


    public double getTotalValue(){
        double sum = 0;
        for (Transaction t : this.transactionList) {
            if (t.getTo_type() == "_") continue;
            sum += t.getValue();
        }
        return sum;
    }

    public Asset copy() {
        Asset clone = new Asset(this.type);
        for (Transaction t : this.transactionList) {
            clone.transactionList.add(t);
        }
        return clone;
    }
}