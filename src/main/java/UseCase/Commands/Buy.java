package UseCase.Commands;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.DataAccessInterface;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Interfaces.ClientInterface;
import UseCase.Managers.AssetManager;
import UseCase.Managers.TransactionManager;
import UseCase.Managers.VoteManager;
import Entities.Users.User;


/**
 * Command to initiate buy orders. A buy order is a Transaction from Currency (like USD) to
 * an Asset (like Google stock).
 */
public class Buy extends Command{


    public Buy(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }


    /**
     * Initiates a buy order. Uses USD to buy an Asset.
     * this.args syntax: [symbol] [value]
     * @returns if successful
     */
    @Override
    public boolean execute() {
        if (this.args.length != 2) return false;

        // Arguments
        String symbol = this.args[0];
        String value = this.args[1];

        Currency usd = getFunds(Double.parseDouble(value));
        System.out.println(usd);
        if (usd == null) return false;

        // Convert to Asset objects
        Asset buy = getBuyAsset(symbol, value);
        System.out.println(buy);
        if (buy == null) return false;

        // Add transaction to the system
        Transaction trans = new Transaction(this.initiator, usd, buy);
        TransactionManager.getInstance().addTransaction(trans);
        VoteManager.getInstance().addVote(trans, initiator, true);
        return true;
    }

    /**
     * Helper method to check if there is enough funds to proceed with the transaction
     * @param volume is how much USD
     * @returns a USD Currency object that has negative volume (to indicate sold) or null if insufficient funds
     */
    public Currency getFunds(double volume){

        // Check if we have enough USD
        if (AssetManager.getInstance().getTypeVolume("USD") < volume) return null;

        return new Currency(-volume,1, "USD","USD");
    }


    /**
     * Helper method for getting the buy Asset object
     * @param symbol is the symbol of the asset to buy
     * @param value is how much to buy (not in $)
     * @returns a corresponding Asset object if successful, otherwise null
     */
    public Asset getBuyAsset(String symbol, String value){
        try {
            double price = this.api.update(symbol);
            if(price == 0) return null;
            return new Stock(Double.parseDouble(value)/price, price, symbol, symbol);
        }
        catch (NumberFormatException e){
            return null;
        }
    }


    @Override
    public String help() {
        return "Fail to buy or wrong Syntax\nSyntax: ! buy [symbol] [amount]";
    }

    @Override
    public String name() {
        return "buy";
    }
}
