package Commands;

import Containers.Transaction;
import Interfaces.ClientInterface;
import Users.User;
import Managers.VoteManager;
import Managers.TransactionManager;

import java.util.UUID;

public class ViewVote extends Command{
    public ViewVote(User initiator, ClientInterface client, String[] args) {
        super(initiator, client, args);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain UUID of given transaction
     * @returns if successful
     */

    @Override
    public boolean execute() {
        if(this.args.length > 1) {return false;}
        // if there is no given transaction, we will get whole vote
        if(this.args.length == 0) {VoteManager.getInstance().viewVote();}
        //get transaction manager and find the transaction we need
        Transaction tran = TransactionManager.getInstance().getTransactions(UUID.fromString(this.args[0]));
        VoteManager.getInstance().viewVote(tran);
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
