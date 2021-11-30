package Commands;

import Assets.DataAccessInterface;
import Containers.Transaction;
import Interfaces.ClientInterface;
import Users.User;
import Managers.VoteManager;
import Managers.TransactionManager;

import java.util.UUID;

public class ViewVote extends Command{
    public ViewVote(User initiator, ClientInterface client, String[] args, DataAccessInterface api) {
        super(initiator, client, args, api);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain UUID of given transaction
     * @return if successful
     */

    @Override
    public boolean execute() {
        if(this.args.length > 1) {return false;}
        // if there is no given transaction, we will get whole vote
        TransactionManager tm = TransactionManager.getInstance();
        if(this.args.length == 0) {
            for (Transaction trans: tm.view()){
                VoteManager.getInstance().viewVote(trans);
            }
        }
        //get transaction manager and find the transaction we need
        if (this.args.length == 1) {
            Transaction tran = tm.getTransactions(UUID.fromString(this.args[0]));
            VoteManager.getInstance().viewVote(tran);
        }
        return true;
    }

    @Override
    public String help() {
        return "";
    }

    @Override
    public String name() {
        return "view-vote";
    }
}
