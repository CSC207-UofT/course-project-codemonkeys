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
    // transactionHistory: a list of historical transaction in the portfolio
    private List<Transaction> transactionHistory;
    // votingHistory: a history of votes in the portfolio
    private List<Vote> votingHistory;
    private double profitability;

    private Portfolio() {
        this.assetList = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
        this.votingHistory = new ArrayList<>();
        this.profitability = 0.0;
    }

    /**
     * Looks for an Asset in the Portfolio by UUID
     * @param id is the UUID
     * @returns if the Asset if found, null otherwise
     */
    public Asset get(UUID id){
        for (Asset asset : this.assetList){
            if (asset.getId().equals(id))
                return asset;
        }
        return null;
    }


    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset) {
        if(asset != null){
            this.assetList.add(asset);
        }

    }

    // Add an transaction to the system.
    public void add(Transaction transaction) {
        if(transaction != null){
            this.transactionHistory.add(transaction);
        }
    }

    // Add a vote to the system.
    public void add(Vote vote) {
        if (vote != null) {
            this.votingHistory.add(vote);
        }

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
        if (this.transactionHistory.contains(transaction0)) {
            this.transactionHistory.remove(transaction0);
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
        return transactionHistory;
    }

    public List<Vote> getVotingHistory() {
        return votingHistory;
    }

    /**
     * Refactor the string representation to show the details about assets in the portfolio.
     @return A string of assets information in the portfolio.
     */
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


