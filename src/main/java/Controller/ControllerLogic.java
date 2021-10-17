package Controller;

import Entities.Admin;
import Entities.User;
import Entities.Vote;
import org.hamcrest.core.IsInstanceOf;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

public class ControllerLogic {
    private void join(String name, boolean isAdmin){
        name = UserManager.checkUserName(name);
        if (UserManager.isUserPresent(name)) {
            throw new IllegalStateException("User Already in the system");
        }
        User user;
        if (isAdmin){
            user = new Admin(name);
        } else {
            user = new User(name);
        }
        UserManager.getInstance().addUser(user);
    }

    public void join(String name) {
        this.join(name, false);
    }

    public void joinAdmin(String name) {
        this.join(name, true);
    }

    public void leave(String name) {
        name = UserManager.checkUserName(name);
        if (!UserManager.isUserPresent(name)) {
            throw new IllegalStateException("User not in the system");
        }
        UserManager.getInstance().delUser(name);
    }

    public void kick(String operator, String user) {
        operator = UserManager.checkUserName(operator);
        if (!UserManager.isUserPresent(operator)) {
            throw new IllegalStateException("Operator not in the system");
        }
        user = UserManager.checkUserName(user);
        if (!UserManager.isUserPresent(user)) {
            throw new IllegalStateException("User not in the system");
        }
        User operatorObject = UserManager.getInstance().getUser(operator);
        if (!(operatorObject instanceof Admin)) {
            throw new IllegalStateException(operator + " are not an admin");
        }
        this.leave(user);
    }

    public String getVoteInfo(UUID voteId) {
        return null;
    }

    public UUID transferAttempt(String name, String from, String to, double value) {
        name = UserManager.checkUserName(name);
        if (!UserManager.isUserPresent(name)) {
            throw new IllegalStateException("User not in the system");
        }
        User user = UserManager.getInstance().getUser(name);
        if(from.isBlank() || to.isBlank()){
            throw new IllegalArgumentException("from and to cannot be empty");
        }
        Vote vote = new Vote(user, from, to, value);
        VoteManager.getInstance().addVote(vote);
        return this.transferAttempt(vote);
    }

    private UUID transferAttempt(Vote vote) {
        if(vote.check()){
            if(!vote.performTransfer()){
                VoteManager.getInstance().delVote(vote);
                throw new IllegalStateException("Not enough money");
            }
            VoteManager.getInstance().delVote(vote);
            return null;
        }
        return vote.getId();
    }

    public UUID transferAttempt(UUID id) {
        Vote vote = VoteManager.getInstance().getVote(id);
        if(vote == null) {
            throw new IllegalArgumentException("Invalid vote uuid");
        }
        return this.transferAttempt(vote);
    }

}
