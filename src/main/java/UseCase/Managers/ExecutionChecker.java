package UseCase.Managers;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.Transaction;
import Entities.Users.User;

import java.util.List;
import java.util.Objects;

public class ExecutionChecker {

    public Transaction trans;
    public DataAccessInterface api;

    public ExecutionChecker(Transaction trans, DataAccessInterface api){
        this.trans = trans;
        this.api = api;
    }
    /**
     * Get the instantaneous voting power of a user based on if each of the recent 10 buy transaction the user
     * participated are profitable.
     * @param user a user
     * @param yahoo yahoo finance stock API
     * @return the user's instantaneous voting power
     */
    public static double votingPowerCalculator(User user, List<Transaction> transactionList, DataAccessInterface yahoo){
        double result = 1.0;
        VoteManager vm = VoteManager.getInstance();
        for (Transaction trans : transactionList){
            double a = trans.buy.getInitialPrice();
            trans.buy.updatePrice(yahoo);
            double b = trans.buy.getPrice();
            // When the transaction is profitable, if the user is the INITIATOR of the transaction, his/her voting power
            // will increase by 40%, if the user is a upVoter, his/her voting power will increase by 20%, if the user
            // is a downVoter, his/her voting power will decrease by 10%
            if (a - b < 0){
                if (Objects.equals(trans.initiator, user)){
                    result = result * 1.4;
                }
                else {
                    if (vm.getUpVoters(trans).contains(user)){
                        result = result * 1.2;
                    }
                    else {result = result * 0.9;}
                }
            }
            // When the transaction is not profitable, if the user is the INITIATOR of the transaction, his/her voting
            // power will decrease by 20%, if the user is a upVoter, his/her voting power will decrease by 10%, if the
            // user is a downVoter, his/her voting power will increase by 20%
            if (a - b > 0){
                if (Objects.equals(trans.initiator, user)){
                    result = result * 0.8;
                }
                else {
                    if (vm.getUpVoters(trans).contains(user)){
                        result = result * 0.9;
                    }
                    else {result = result * 1.2;}
                }
            }
        }
        return result;
    }

    public static double getVotingPower(User user, DataAccessInterface api){
        AssetManager assetManager = AssetManager.getInstance();
        List<Transaction> transactionList = user.getUserPortfolio().getTransactionList();

        if (transactionList.size() < 10){
            return votingPowerCalculator(user, transactionList, api);
        }
        else {
            return votingPowerCalculator(user,
                    transactionList.subList(transactionList.size()-10, transactionList.size()-1), api);
        }
    }

    /**
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the total of upVoter's voting power of the transaction
     */
    public double upVotePower(Transaction trans, DataAccessInterface yahoo){
        VoteManager vm = VoteManager.getInstance();
        double result = 0;
        List<User> users = vm.getUpVoters(trans);
        for (User user: users){
            result += getVotingPower(user, yahoo);
        }
        return result;
    }

    /**
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the total of downVoter's voting power of the transaction
     */
    public double downVotePower(Transaction trans, DataAccessInterface yahoo){
        VoteManager vm = VoteManager.getInstance();
        double result = 0;
        List<User> users = vm.getDownVoters(trans);
        for (User user: users){
            result += getVotingPower(user, yahoo);
        }
        return result;
    }

    /**
     * get amount of money to be spent on the transaction as a percentage of the total amount of USD in the pool
     * @param trans the pending transaction
     * @return the money to be spent on the transaction as a percentage of the total amount of USD in the pool
     */
    public double getTransactionValueRatio(Transaction trans){
        AssetManager am = AssetManager.getInstance();
        double usd = am.getTypeInitialValue("USD");
        double buy = - trans.sell.getValue();
        return buy/usd;
    }

    /**
     * the number of votes needed for the transaction to pass is greater than or equal to 3 and greater than the
     * TransactionValueRatio times the total number of users
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the number of votes needed for the transaction to pass
     */
    public int needNumVote(Transaction trans, DataAccessInterface yahoo){
        UserManager um = UserManager.getInstance();
        int numVotes = (int)(um.numUser() * getTransactionValueRatio(trans));
        return Math.max(numVotes, 3);
    }

    /**
     * check if the number of votes for the transaction reached the accepting state, the accepting state is the number
     * of votes is greater than 3 and greater than the TransactionValueRatio times the total number of users
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return true if the number of votes for the transaction is greater than or equal to the number of votes needed
     * for the transaction to pass
     */
    public boolean reachVoteNum(Transaction trans, DataAccessInterface yahoo){
        VoteManager vm = VoteManager.getInstance();
        int numVotes = needNumVote(trans, yahoo);
        return vm.numVoters(trans) >= numVotes;
    }

    /**
     * check if the buy transaction passes, a transaction will pass if it reached the accepting vote number and the total
     * of upVoter's voting power is greater than the total of downVoter's voting power
     * @return true if the buy transaction is able to execute
     */
    public boolean buyExecutable(){
        return getTransactionValueRatio(trans) < 1 && reachVoteNum(trans, api)
                && upVotePower(trans, api) > downVotePower(trans, api);
    }

    /**
     * check if the sell transaction passes, a transaction will pass if its number of voter is greater than three and
     * the total of upVoter's voting power is greater than the total of downVoter's voting power
     * @return true if the sell transaction is able to execute
     */
    public boolean sellExecutable() {
        VoteManager vm = VoteManager.getInstance();
        return vm.numVoters(trans) > 3 && upVotePower(trans, api) > downVotePower(trans, api);
    }
}
