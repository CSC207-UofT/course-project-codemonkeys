package Containers;

import Identification.Identifiable;
import Users.User;

public class Vote extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________

    private final User initiator;
    private final Transaction transaction;
    private final boolean upvote;

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for a Vote
     * @param initiator is the User who started the vote
     * @param transaction is the transaction to vote for
     * @param upvote is true if it's an upvote or false for downvote
     */
    public Vote(User initiator, Transaction transaction, boolean upvote){
        this.initiator = initiator;
        this.transaction = transaction;
        this.upvote = upvote;
    }

    //____________________ Methods _____________________________________________________________________________________

    public User getInitiator() {
        return initiator;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public boolean isUpvote() {
        return upvote;
    }
}

