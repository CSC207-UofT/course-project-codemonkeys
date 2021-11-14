package Managers;

import Containers.Transaction;
import Containers.Vote;

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

    /**
     * Gets the vote for a transaction based on UUID
     * @param transaction is the queried transaction
     * @param id is the UUID associated with the desired vote
     * @return the vote object
     */
    public Vote getVoteFor(Transaction transaction, UUID id){
        for (Vote vote : this.get(transaction)){
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

    public String votesFor(Transaction transaction){
        StringBuilder res = new StringBuilder();
        List<Vote> votes = this.get(transaction);

        return ""; // TODO : return information about the votes, finish this method
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
