package Managers;

import Containers.PendingDecision;
import Containers.Transaction;
import Containers.Vote;
import Helpers.VotingPowerHelper;
import Users.User;

import java.util.*;

// VoteManager is a management and storage class for all pending decisions and their related votes.
// A pending transaction is a transaction that is not carried out and undergoing a voting process.
// The pending transaction's identifier is the transaction's identifier. No user is involved in storage.
public class VoteManager {

    private static VoteManager instance;

    static {
        VoteManager.instance = new VoteManager();
    }

    public static VoteManager getInstance() {
        return VoteManager.instance;
    }

    // The UUID of transaction and its related pending decision (transaction itself + votes)
    private final HashMap<UUID, PendingDecision> storage;

    private VoteManager() {
        this.storage = new LinkedHashMap<UUID, PendingDecision>();
    }

    // Register a new transaction to be pending and enabling the voting process.
    public void createVote(Transaction transaction, Date expiresOn) {
        PendingDecision pendingDecision = new PendingDecision(transaction, expiresOn);
        this.storage.put(transaction.id, pendingDecision);
    }

    // Obtain a snapshot of all votes currently associated with a pending decision.
    // If the transaction is not in the registry the method will return null.
    public Vote[] getVotes(Transaction transaction) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return null;
        return pendingDecision.votes.toArray(new Vote[0]);
    }

    // Obtain the number of votes currently associated with a pending decision.
    // If the transaction is not in the registry the method will return -1.
    public int getVoteCount(Transaction transaction) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return -1;
        return pendingDecision.votes.size();
    }

    // Performs an up vote on a pending transaction.
    // If the transaction is not registered it will return false,
    // otherwise it will return true.
    public boolean doUpVote(Transaction transaction, User user) {
        return this.doVote(transaction, new Vote(user, true));
    }

    // Performs a down vote on a pending transaction.
    // If the transaction is not registered it will return false,
    // otherwise it will return true.
    public boolean doDownVote(Transaction transaction, User user) {
        return this.doVote(transaction, new Vote(user, false));
    }

    // Internal method to append a vote to a pending decision.
    private boolean doVote(Transaction transaction, Vote vote) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return false;
        pendingDecision.votes.add(vote);
        return true;
    }

    // Calculate the total voting power for a specific pending decision.
    // If the transaction is not registered it will return NaN.
    // This method uses the voting power obtained from TransactionManager.
    public double calcVotingPower(Transaction transaction) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return Double.NaN;
        double votingPowerSum = 0;
        for(Vote vote : pendingDecision.votes) votingPowerSum = VotingPowerHelper.countVote(votingPowerSum, TransactionManager.getInstance().getVotingPower(vote.initiator), vote.isUpvote);
        return votingPowerSum;
    }

    public int checkVote(Transaction transaction) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return 0;
        return
    }

    // Perform the pending transaction and remove the transaction from the internal registry.
    // If the transaction is not registered, or errors occured while performing, it will return false. The pending transaction will not be removed from internal registry.
    // If the transaction is successfully performed, the pending transaction will be removed from internal registry and the method will return true.
    // This method uses the perform transaction method from TransactionManager.
    public boolean performTransaction(Transaction transaction) {
        PendingDecision pendingDecision = this.storage.get(transaction.id);
        if(pendingDecision == null) return false;
        if(!TransactionManager.getInstance().performTransaction(transaction)) return false;
        this.storage.remove(transaction.id);
        return true;
    }



}
