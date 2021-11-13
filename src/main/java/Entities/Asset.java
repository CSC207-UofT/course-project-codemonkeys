package Entities;

import java.util.*;

public class Asset {
    //____________________ Variables ___________________________________________________________________________________
    private String type;
    private List<Transaction> transactionList;

    //____________________ Constructors ________________________________________________________________________________

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public Asset(String type){
        this.type = type;
        this.transactionList = new ArrayList<Transaction>();
    }

    public String getType() {
        return this.type;
    }

    public double getValue() {
        double res = 0.0;
        for (Transaction t: this.transactionList) {
//            if (t.getFrom_type().equals("_") || t.getTo_type().equals("_")) continue;
//            if (t.getFrom_type().equals(this.type)) {
//                res -= t.getValue();
//            }
            if (t.getTo_type().equals(this.type)) {
                res += t.getValue();
            }
        }
        return res;
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

    //--------------------------------------------------------------
    private String symbol;
    private double price;
    private boolean valid = true;
    private boolean liquid = false;

    // TODO: Iterable
    private Map<UUID, Double> owner = new HashMap<>();



    public Asset () {}

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public void setSymbol(String newSymbol) {
        this.symbol = newSymbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean isValid() {
        return this.valid;
    };

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isLiquid() {
        return this.liquid;
    }

    public void setLiquid(boolean liquid) {
        this.liquid = liquid;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public Map<UUID, Double> getOwnerList() {
        return this.owner;
    }

    public void addOwner(UUID user, Double amount) {
        this.owner.put(user, this.owner.containsKey(user) ? this.owner.get(user) + amount : amount);
    }

    public void removeOwner(UUID user, Double amount) {
        //TODO
    }

    public boolean canSell(UUID user, Double amount) {
        return this.owner.get(user) >= amount;
    }

    public double getTotalPriceOwned() {
        // TODO
        // return this.getPrice() * sum(this.owner.values());
        return 0.0;
    }

    // TODO: record a transaction history
    public void recordTransctionHistory() {
//        if (from.getTotalValue() < value) {
//            return false;  // transaction denied
//        }
//        Transaction[] t = Transaction.generateTransactionPair(from.getType(), to.getType(), value);
//        from.addTransaction(t[0]);
//        to.addTransaction(t[1]);
//        return true;  // Transaction approved.
    }

}