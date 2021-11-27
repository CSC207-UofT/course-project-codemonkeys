package Managers;

import Assets.DataAccessInterface;
import Containers.Transaction;
import Users.User;

import java.util.List;
import java.util.Objects;

public class ExecutionChecker {
    /**
     * Get the instantaneous voting power of a user based on if each of the recent 10 buy transaction the user
     * participated are profitable.
     * @param user a user
     * @param yahoo yahoo finance stock API
     * @return the user's instantaneous voting power
     */
    public double votingPower(User user, DataAccessInterface yahoo){
        double result = 1.0;
        List<Transaction> transactionList = user.getUserPortfolio().getTransactionList();
        VoteManager vm = VoteManager.getInstance();
        for (int i = transactionList.size() - 10; i < transactionList.size(); i++){
            Transaction trans = transactionList.get(i);
            double a = trans.buy.getInitialPrice();
            trans.buy.updatePrice(yahoo);
            double b = trans.buy.getPrice();
            // When the transaction is profitable, if the user is the initiator of the transaction, his/her voting power
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
            // When the transaction is not profitable, if the user is the initiator of the transaction, his/her voting
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

    /**
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the total of upVoter's voting power of the transaction
     */
    public double upVotePower(Transaction trans, DataAccessInterface yahoo){
        VoteManager vm = VoteManager.getInstance();
        double result = 0;
        User[] users = vm.getUpVoters(trans).toArray(new User[0]);
        for (User user: users){
            result += votingPower(user, yahoo);
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
        User[] users = vm.getDownVoters(trans).toArray(new User[0]);
        for (User user: users){
            result += votingPower(user, yahoo);
        }
        return result;
    }

    /**
     * get amount of money to be spent on the transaction as a percentage of the total amount of USD in the pool
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the money to be spent on the transaction as a percentage of the total amount of USD in the pool
     */
    public double getTransactionValueRatio(Transaction trans, DataAccessInterface yahoo){
        AssetManager am = AssetManager.getInstance();
        double usd = am.getTypeInitialValue("USD");
        trans.buy.updatePrice(yahoo);
        double buy = trans.buy.getValue();
        return buy/usd;
    }

    /**
     * check if the number of votes for the transaction reached the accepting state, the accepting state is the number
     * of votes is greater than 3 and greater than the TransactionValueRatio times the total number of users
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return the money to be spent on the transaction as a percentage of the total amount of USD in the pool
     */
    public boolean reachVoteNum(Transaction trans, DataAccessInterface yahoo){
        VoteManager vm = VoteManager.getInstance();
        UserManager um = UserManager.getInstance();
        int numVotes = (int)(um.numUser() * getTransactionValueRatio(trans, yahoo));
        return vm.numVoters(trans) >= 3 && vm.numVoters(trans) >= numVotes;
    }

    /**
     * check if the transaction passes, a transaction will pass if it reached the accepting vote number and the total
     * of upVoter's voting power is greater than the total of downVoter's voting power
     * @param trans the pending transaction
     * @param yahoo yahoo finance stock API
     * @return true if the transaction is able to execute
     */
    public boolean executable(Transaction trans, DataAccessInterface yahoo){
        return reachVoteNum(trans, yahoo) && upVotePower(trans, yahoo) > downVotePower(trans, yahoo);
    }
}