package Containers;

import Assets.Asset;

import java.io.Serializable;
import java.util.*;

// Portfolio is a manager and data storage class for managing common wealth among all users.
// TODO: change its name to WealthManager and move it into package Managers.
// The common wealth among all users is stored in the form of individual assets.
// More assets can be added, or be subtracted from the system. The manager will only perform operation on the same type of assets.
// The manager can calculate the value of one or all assets.
// The manager is also responsible for updating the price of an asset to correctly calculate its value.
public class Portfolio implements Serializable {

    private static Portfolio commonPortfolio;

    static {
        Portfolio.commonPortfolio = new Portfolio();
    }

    public static Portfolio getInstance() {
        return Portfolio.commonPortfolio;
    }



    // assetList: a list of asset in the portfolio
    private List<Asset> assetList;
    // transactionList: a list of transaction in the portfolio
    private List<Transaction> transactionList;
    // votingHistory: a history of votes in the portfolio
    private List<Vote> votingHistory;
    private double profitability;

    private Portfolio() {
        this.assetList = new ArrayList<>();
        this.transactionList = new ArrayList<>();
        this.votingHistory = new ArrayList<>();
        this.profitability = 0.0;
    }


    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset0) {
        this.assetList.add(asset0);
    }

    // Add an asset to the system.
    public void add(Transaction transaction0) {
        this.transactionList.add(transaction0);
    }

    // Add a vote to the system.
    public void add(Vote vote0) {
        this.votingHistory.add(vote0);
    }

    // Subtracts an asset from the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void sub(Asset asset0) {
        if (this.assetList.contains(asset0)) {
            this.assetList.remove(asset0);
        }
        else{
            System.out.println("Current portfolio does not contain " + asset0);
        }
    }

    public void sub(Transaction transaction0) {
        if (this.transactionList.contains(transaction0)) {
            this.transactionList.remove(transaction0);
        }
        else{
            System.out.println("Current portfolio does not contain " + transaction0);
        }
    }

    public void sub(Vote vote0) {
        if (this.votingHistory.contains(vote0)) {
            this.votingHistory.remove(vote0);
        }
        else{
            System.out.println("Current portfolio does not contain " + vote0);
        }
    }

    // Calculates the value of a specific asset.
    // If the asset is not found, this method will return zero.
    public double getValue(String symbol) {
        double value = 0;
        for (Asset a: this.assetList){
            if (a.getSymbol().equals(symbol)){
                value += a.getValue();
            }
        }
       return value;
    }

    // Calculates the value of all assets in the system.
    // If there's no asset in the system, this method will return zero.
    public double getValue() {
        double value = 0;
        for (Asset a: this.assetList){
            value += a.getValue();
        }
        return value;
    }

    // Getter and Setter for profitability
    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    // Getter and Setter for assets, transactions, and votes

    public List<Asset> getAssetList() {
        return assetList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public List<Vote> getVotingHistory() {
        return votingHistory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wealth Manager Debug Report: \n");
        for(Asset asset : this.assetList) {
            sb.append(asset.getType()).append('[');
            sb.append(asset.getVolume()).append(" x $").append(asset.getPrice());
            sb.append(" (= $").append(asset.getValue()).append(")]\n");
        }
        sb.append("Total value: $").append(this.getValue()).append('\n');
        return sb.toString();
    }
}


