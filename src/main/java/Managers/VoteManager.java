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
     * @returns the instance
     */
    public static VoteManager getInstance() {
        return instance;
    }

    /**
     * Gets the vote for a transaction based on UUID
     * @param transaction is the queried transaction
     * @param id is the UUID associated with the desired vote
     * @returns the vote object
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
     * @returns information
     */
    public String votesFor(Transaction transaction){
        return ""; // TODO : return information about the votes
    }

}
