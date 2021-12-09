package entities.containers;

import entities.identification.Identifiable;
import entities.users.User;
import java.io.Serializable;

// An immutable container for a vote.
// A vote has an initiating user (vote owner), and could be either an upvote or a downvote.
public final class Vote extends Identifiable implements Serializable{

    public final User initiator;
    public final boolean isUpvote;

    public Vote(User initiator, boolean upvote){
        this.initiator = initiator;
        this.isUpvote = upvote;
    }

}

