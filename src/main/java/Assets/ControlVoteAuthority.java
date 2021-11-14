package Assets;

import Users.User;

import java.util.UUID;

public class ControlVoteAuthority extends UserAuthorities{
    // authorize a user to force pass/veto votes.
    public ControlVoteAuthority(User authorized_user) {
        super(authorized_user);
    }

    public void ControlVote(Vote vote, boolean decision){
        // Given a vote id and a decision, pass the vote if decision is true and
        // veto the vote otherwise.
        if(decision){
            vote.performTransfer(); // Pass a vote by performing the transfer.
        }
        else{
            vote.setStatus(false);
        }
    }
}
