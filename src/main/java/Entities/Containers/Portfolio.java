package Entities.Containers;

import Entities.Assets.Asset;
import Entities.Assets.DataAccessInterface;
import UseCase.PortfolioHelper.AssetProcessor;
import UseCase.PortfolioHelper.ProfitabilityCalculator;
import UseCase.PortfolioHelper.TransactionProcessor;
import UseCase.PortfolioHelper.VoteProcessor;

import java.io.Serializable;
import java.util.*;

/**
 * This is the concrete class for the portfolio class
 * It is a facade that instantiates and delegating to various processors
 *  - AssetProcessor
 *  - ProfitabilityCalculator
 *  - TransactionProcessor
 *  - VoteProcessor
 *
 * Author Zixin (Charlie) Guo
 * Date: Dec 05 2021
 * Version: 1.0
 */

// Portfolio is a manager and data storage class for managing common wealth among all users.
// The common wealth among all users is stored in the form of individual assets.
// More assets can be added, or be subtracted from the system. The manager will only perform operation on the same type of assets.
// The manager can calculate the value of one or all assets.
// The manager is also responsible for updating the price of an asset to correctly calculate its value.
public class Portfolio implements Serializable {

    private Portfolio portfolio;

    //Facade: Create processor for asset, transaction, and vote
    private AssetProcessor assetProcessor;
    private VoteProcessor voteProcessor;
    private TransactionProcessor transactionProcessor;
    private ProfitabilityCalculator profitabilityCalculator;


    public Portfolio() {
        this.transactionProcessor = new TransactionProcessor();
        this.voteProcessor = new VoteProcessor();
        this.assetProcessor = new AssetProcessor();
        this.profitabilityCalculator = new ProfitabilityCalculator();
    }

    /**
     * Looks for an Asset in the Portfolio by UUID
     * @param id is the UUID
     * @returns if the Asset if found, null otherwise
     */
    public Asset get(UUID id){
        return this.assetProcessor.get(id);
    }


    // Add an asset to the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void add(Asset asset) {
        this.assetProcessor.add(asset);
    }

    // Add an transaction to the system.
    public void add(Transaction transaction) {
        this.transactionProcessor.add(transaction);
    }

    // Add a vote to the system.
    public void add(Vote vote) {
        this.voteProcessor.add(vote);
    }

    // Subtracts an asset from the system.
    // This method only takes a snapshot of its parameter, the parameter object can be safely modified afterwards.
    public void sub(Asset asset0) {
        this.assetProcessor.sub(asset0);
    }

    public void sub(Transaction transaction0) {
        this.transactionProcessor.sub(transaction0);
    }

    public void sub(Vote vote0) {
        this.voteProcessor.sub(vote0);
    }

    // Calculates the value of a specific asset.
    // If the asset is not found, this method will return zero.
    public double getValue(String symbol) {
        return this.assetProcessor.getValue(symbol);
    }

    // Calculates the value of all assets in the system.
    // If there's no asset in the system, this method will return zero.
    public double getValue() {
        return this.assetProcessor.getValue();
    }

    // Calculates the updated value of all assets in the system through the provided data access interface.
    // If there's no asset in the system, this method will return zero.
    public double getValue(DataAccessInterface api) {
        return this.assetProcessor.getValue(api);
    }

    // Getter and Setter for profitability
    public double getProfitability() {
        return this.profitabilityCalculator.getProfitability();
    }

    public void setProfitability(double profitability) {
        this.profitabilityCalculator.setProfitability(profitability);
    }

    // Getter and Setter for assets, transactions, and votes

    public List<Asset> getAssetList() {
        return this.assetProcessor.getAssetList();
    }

    public List<Transaction> getTransactionList() {
        return this.transactionProcessor.getTransactionList();
    }

    public List<Vote> getVotingHistory() {
        return this.voteProcessor.getVotingHistory();
    }

    /**
     * Refactor the string representation to show the details about assets in the portfolio.
     @return A string of assets information in the portfolio.
     */
    @Override
    public String toString() {
       return this.assetProcessor.toString();
    }
}


