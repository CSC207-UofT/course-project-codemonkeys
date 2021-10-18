package Controller;

import UseCases.UserManager;
import UseCases.VoteManager;
import Entities.Admin;
import Entities.User;
import Entities.Vote;

import java.util.UUID;

public class CommandLineParser {
    VoteManager voteManager;

    private void join(String name, boolean isAdmin, int init_USD){
        this.voteManager = VoteManager.getInstance();
        name = UserManager.checkUserName(name);
        if (UserManager.isUserPresent(name)) {
            throw new IllegalStateException("User Already in the system");
        }
        User user;
        if (isAdmin){
            user = new Admin(name);
            user.addInitialAsset(init_USD);
        } else {
            user = new User(name);
            user.addInitialAsset(init_USD);
        }
        UserManager.getInstance().addUser(user);
    }

    private void join(String name, boolean isAdmin){
        this.voteManager = VoteManager.getInstance();
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

    public void join(String name, int init) {
        this.join(name, false, init);
    }

    public void joinAdmin(String name, int init) {
        this.join(name, true, init);
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

    public String viewVotes() {
        return this.voteManager.viewVotes();
    }

    public int voterNumer(UUID id) {
        return this.voteManager.getVote(id).upVoterSize() + this.voteManager.getVote(id).downVoterSize();
    }

    public int userNumber() {
        return UserManager.getInstance().getUserSize();
    }

    public void upVote(UUID id, String name) {
        this.voteManager.getVote(id).upVote(UserManager.getInstance().getUser(name));
    }

    public void downVote(UUID id, String name) {
        this.voteManager.getVote(id).downVote(UserManager.getInstance().getUser(name));
    }

    public boolean checkVoteFinish(UUID id) {
        int members = UserManager.getInstance().getUserSize();
        return this.voteManager.getVote(id).checkApprove(members);
    }

    public String getVoteInfo(UUID voteId) {
        return null;
    }

    public void createVote(String username, String type, double value) {
        this.voteManager.addVote(UserManager.getInstance().getUser(username), type, value);
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

    //TODO finish this methods.
    public boolean sell(String from, String to, double val) {
        return true;
    }

}
