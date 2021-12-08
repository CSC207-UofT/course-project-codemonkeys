package UseCase.Commands;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.DataAccessInterface;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Interfaces.ClientInterface;
import Entities.Users.User;
import UseCase.Managers.AssetManager;
import UseCase.Managers.TransactionManager;
import UseCase.Managers.VoteManager;

import java.util.UUID;


/**
 * Command to initiate sell orders. A sell order is a Transaction from an Asset to USD.
 */
public class Sell extends Command{

    public Sell(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }

    /**
     * Initiates a sell order. Sells an Asset in return for USD.
     * this.args syntax: [UUID String]
     * @returns if successful
     */
    @Override
    public boolean execute() {
        if (this.args.length != 1 && this.args.length != 2) return false;

        UUID id;
        Asset sell;

        //Convert input to UUID. Look for Asset. Create Transaction.
        try{
            id = UUID.fromString(this.args[0]);
        }
        catch (IllegalArgumentException e){
            return false;
        }
        if (!AssetManager.getInstance().findAsset(id)){
            return false;
        }
        Asset asset = AssetManager.getInstance().getAsset(id);
        if (this.args.length == 1){
            asset.updatePrice(api);
            Asset sell1 = new Stock(asset.getVolume(), asset.getPrice(), asset.getType(), asset.getSymbol());
            Currency usd = new Currency(sell1.getValue(), 1, "USD", "USD");
            Transaction trans = new Transaction(this.initiator, sell1, usd);
            VoteManager.getInstance().addVote(trans, initiator, true);
            TransactionManager.getInstance().addTransaction(trans);
        }
        if (this.args.length == 2){
            Asset sell1 = new Stock(Double.parseDouble(this.args[1]), asset.getPrice(), asset.getType(), asset.getSymbol());
            Currency usd = new Currency(sell1.getValue(), 1, "USD", "USD");
            Transaction trans = new Transaction(this.initiator, sell1, usd);
            VoteManager.getInstance().addVote(trans, initiator, true);
            TransactionManager.getInstance().addTransaction(trans);
        }

        return true;
    }

    @Override
    public String help() {
        return "This is the sell Command";
    }

    @Override
    public String name() {
        return "sell";
    }
}
