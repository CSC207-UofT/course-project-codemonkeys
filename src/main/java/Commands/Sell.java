package Commands;

import Assets.Asset;
import Assets.Currency;
import Containers.Transaction;
import Interfaces.ClientInterface;
import Managers.AssetManager;
import Managers.UserManager;
import Users.User;

import java.util.List;
import java.util.UUID;


/**
 * Command to initiate sell orders. A sell order is a Transaction from an Asset to USD.
 *
 * Author: Langson Zhang
 * Date: Nov 26 2021
 * Version: 1.0
 */
public class Sell extends Command{

    public Sell(User initiator, ClientInterface client, String[] args) {
        super(initiator, client, args);
    }

    /**
     * Initiates a sell order. Sells an Asset in return for USD.
     * this.args syntax: [UUID String]
     * @returns if successful
     */
    @Override
    public boolean execute() {
        if (this.args.length != 1) return false;

        UUID id;
        Asset sell;

        //Convert input to UUID. Look for Asset. Create Transaction.
        List<Asset> assets = this.initiator.getUserPortfolio().getAssetList();
        try{
            id = UUID.fromString(this.args[0]);
        }
        catch (IllegalArgumentException e){
            return false;
        }
         sell = this.initiator.getUserPortfolio().get(id);
        if(sell == null) return false;
        Currency usd = new Currency(sell.getInitialPrice(), 1, "USD", "DXY");
        Transaction trans = new Transaction(this.initiator, sell, usd);
        //TODO add transaction.
        //TransactionManager.getInstance().add(trans);
        return true;
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }
}
