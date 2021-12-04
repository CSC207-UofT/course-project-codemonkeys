package Commands;

import Assets.Currency;
import Assets.DataAccessInterface;
import Containers.Transaction;
import Interfaces.ClientInterface;
import Managers.ExecutionChecker;
import Managers.TransactionExecutor;
import Managers.TransactionManager;
import Managers.VoteManager;
import Users.User;

import java.util.UUID;

public class DownVote extends Command{
    public DownVote(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain UUID of the given transaction or null
     * @returns if successful
     */

    @Override
    public boolean execute() {
        if(this.args.length != 1) {return false;}
//        May add is_ban method, so we have to check if this user can vote.
//        if(this.INITIATOR.is_ban) {return false;}

        //get transaction manager and find the transaction we need
        TransactionManager tm = TransactionManager.getInstance();
        if (!tm.checkTransactions(UUID.fromString(this.args[0]))){
            System.out.println("Cannot find the transaction");
            return true;
        }
        Transaction tran = tm.getTransactions(UUID.fromString(this.args[0]));
        VoteManager.getInstance().addVote(tran, this.initiator, false);
        System.out.println("Successfully add DownVote");

        //check if the transaction is able to execute and execute it if possible
        ExecutionChecker checker = new ExecutionChecker(tran, api);
        boolean check;
        if (tran.sell instanceof Currency){
            check = checker.buyExecutable();
        }
        else {
            check = checker.sellExecutable();
        }
        if (check){
            new TransactionExecutor().execute(tran, api);
        }
        return true;
    }

    @Override
    public String help() {
        return "Downvote: add an Downvote(against this transaction) Vote to an existing transaction\n"+
                "Syntax: Downvote [symbol]\n";
    }

    @Override
    public String name() {
        return "downvote";
    }
}