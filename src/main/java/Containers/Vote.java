package Containers;

import Identification.Identifiable;
import Users.User;

// An immutable contaner for a vote.
// A vote has an initiating user, and could be either an upvote or a downvote.
public final class Vote extends Identifiable {

    public final User initiator;
    public final boolean isUpvote;

    public Vote(User initiator, boolean upvote){
        this.initiator = initiator;
        this.isUpvote = upvote;
    }

}

