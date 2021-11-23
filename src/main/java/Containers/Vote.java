package Containers;

import Identification.Identifiable;
import Users.CommonUser;

// An immutable container for a vote.
// A vote has an initiating user (vote owner), and could be either an upvote or a downvote.
public final class Vote extends Identifiable {

    public final CommonUser initiator;
    public final boolean isUpvote;

    public Vote(CommonUser initiator, boolean upvote){
        this.initiator = initiator;
        this.isUpvote = upvote;
    }

}

