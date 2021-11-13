package Managers;

import Containers.Transaction;
import Containers.Vote;

import java.util.*;

public class VoteManager {
    private static VoteManager instance;
    private HashMap<Transaction, List<Vote>> transactionVotes;

   private VoteManager(){
       this.transactionVotes = new HashMap<Transaction, List<Vote>>();
   }

   static {
       instance = new VoteManager();
   }

    /**
     * Gets the singleton instance
     * @returns the instance
     */
    public static VoteManager getInstance() {
        return instance;
    }

    /**
     * Gets the list of votes for a given transaction
     * @param transaction is the queried transaction
     * @returns the list of vote objects
     */
    public List<Vote> getVotes(Transaction transaction){
       return transactionVotes.get(transaction);
    }

    /**
     * Gets the vote for a transaction based on UUID
     * @param transaction is the queried transaction
     * @param id is the UUID associated with the desired vote
     * @returns the vote object
     */
    public Vote getVote(Transaction transaction, UUID id){
        for ( Vote v : this.getVotes(transaction)){
            if(v.getId() == id)
                return v;
        }
        return null;
    }
}
