package Commands;

import Containers.Transaction;
import Interfaces.ClientInterface;
import Managers.TransactionManager;
import Managers.VoteManager;
import Users.User;

import java.util.UUID;

public class DownVote extends Command{
    public DownVote(User initiator, ClientInterface client, String[] args) {
        super(initiator, client, args);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain UUID of the given transaction
     * @returns if successful
     */

    @Override
    public boolean execute() {
        if(this.args.length != 1) {return false;}
//        May add is_ban method, so we have to check if this user can vote.
//        if(this.initiator.is_ban) {return false;}

        //get transaction manager and find the transaction we need
        TransactionManager tm = TransactionManager.getInstance();
        if (!tm.checkTransactions(UUID.fromString(this.args[0]))){
            System.out.println("Cannot find the transaction");
            return true;
        }
        Transaction tran = tm.getTransactions(UUID.fromString(this.args[0]));
        VoteManager.getInstance().addVote(tran, this.initiator, false);
        System.out.println("Successfully add DownVote");
        return true;
    }

    @Override
    public String help() {
        return "";
    }

    @Override
    public String name() {
        return "down-vote";
    }
}