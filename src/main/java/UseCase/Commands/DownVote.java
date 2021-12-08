package UseCase.Commands;

import Entities.Assets.Currency;
import Entities.Assets.DataAccessInterface;
import Entities.Containers.Transaction;
import UseCase.ClientInterface.ClientInterface;
import UseCase.Managers.ExecutionChecker;
import UseCase.Managers.TransactionExecutor;
import UseCase.Managers.TransactionManager;
import UseCase.Managers.VoteManager;
import Entities.Users.User;

import java.util.UUID;

public class DownVote extends Command{
    public DownVote(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain UUID of the given transaction or null
     * @return if successful
     */

    @Override
    public boolean execute() {
        if(this.args.length != 1) {return false;}
        // When the initiator is banned, the command cannot be executed.
        if(this.initiator.isBanned()) {return false;}

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
            new TransactionExecutor();
            TransactionExecutor.execute(tran, api);
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