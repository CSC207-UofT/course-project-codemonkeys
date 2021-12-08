package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.Transaction;
import UseCase.ClientInterface.ClientInterface;
import Entities.Users.User;
import UseCase.Managers.VoteManager;
import UseCase.Managers.TransactionManager;

import java.util.UUID;

public class ViewVote extends Command{
    public ViewVote(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
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
        return "This is the ViewVote command." +
                "Syntax: '! viewvote' or '! viewvote [symbol]'";
    }

    @Override
    public String name() {
        return "viewvote";
    }
}
