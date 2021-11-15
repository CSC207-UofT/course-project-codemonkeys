package Managers;

import Assets.Asset;
import Containers.Transaction;
import Containers.Vote;
import Users.User;

import java.util.*;

public class VoteManager extends HashMap<Transaction, List<Vote>> {

    //_______________________________________________ Variables ________________________________________________________

    private static VoteManager instance;

    private VoteManager(){
        super();
    }

    //______________________________________________ Constructors ______________________________________________________


    static {
        instance = new VoteManager();
    }

    //_________________________________________________ Methods ________________________________________________________

    /**
     * Gets the singleton instance
     * @return the instance
     */
    public static VoteManager getInstance() {
        return instance;
    }

    public  void addUpVote(Transaction transaction, User u){
        Vote vote = new Vote(u, transaction, true);
        instance.get(transaction).add(vote);
    }

    public  void addDownVote(Transaction transaction, User u){
        Vote vote = new Vote(u, transaction, false);
        instance.get(transaction).add(vote);
    }

    /**
     * Gets the vote for a transaction based on UUID
     * @param transaction is the queried transaction
     * @param id is the UUID associated with the desired vote
     * @return the vote object
     */
    public Vote getVoteFor(Transaction transaction, UUID id){
        for (Vote vote : instance.get(transaction)){
            if (vote.getId() == id)
                return vote;
        }
        return null;
    }

    /**
     * Returns information in string format on votes for a given transaction
     * @param transaction is the queried transaction
     * @return information
     */

    public String viewVote(Transaction transaction){
        StringBuilder res = new StringBuilder();
        double u = instance.upVoters(transaction);
        double d = instance.downVoters(transaction);
        Asset a = transaction.getBuy();
        res.append("transaction id: ").append(transaction.getId()).append(", name: ").append(a.getType().toString()).
                append(", value: ").append(a.getValue()).append(", number of upVoters: ").append(u).
                append(", number of upVoters: ").append(d);
        return res.toString();
    }

    /**
     * Returns number of upVoters for a given transaction
     * @param transaction is the queried transaction
     * @return the number of upvoters in double
     */
    public double upVoters(Transaction transaction) {
        double result = 0;
        for (Vote vote : this.get(transaction)) {
            if (vote.isUpvote()) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * Returns number of downVoters for a given transaction
     * @param transaction is the queried transaction
     * @return the number of downVoters in double
     */
    public double downVoters(Transaction transaction) {
        double result = 0;
        for (Vote vote : this.get(transaction)) {
            if (!(vote.isUpvote())) {
                result += 1;
            }
        }
        return result;
    }

}
