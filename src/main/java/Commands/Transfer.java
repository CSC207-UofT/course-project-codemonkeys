package Commands;

import Assets.Asset;
import Containers.Transaction;
import Interfaces.YahooFinanceAPI;
import Managers.VoteManager;
import Users.User;

import java.util.ArrayList;
import java.util.UUID;

public class Transfer implements Command{
    public Transfer() {
    }

    @Override
    // User: transaction 100 Dollar USD RMB CNY
    public boolean execute(User user, String[] args) {
        if(args.length != 3) {
            return false;
        }
        double amount = Double.parseDouble(args[0]);
        String type_src = args[1];
        String type_dest = args[2];
        double value_src = new YahooFinanceAPI().getUpdate(type_src);
        double value_dest = new YahooFinanceAPI().getUpdate(type_dest);
        Asset asset_src = new Asset(amount, value_src, type_src);
        Asset asset_dest = new Asset(amount / value_src * value_dest, value_dest, type_dest);
        Transaction transaction = new Transaction(user, asset_src, asset_dest);
        VoteManager.getInstance().createVote(transaction);
        System.out.println("Transaction request registered! Reference id " + transaction.id);
        return true;
    }

    @Override
    public String help() {
            return "this is info for the create user command";
        }

    @Override
    public String name() {
        return "buy";
    }

}
