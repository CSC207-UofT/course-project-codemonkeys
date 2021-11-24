package Command;

import Users.User;

public class ViewVote implements Command{
    /**
     * view the Votes for an existing Transaction
     * @param args list of users
     * @returns whether the execution was successful
     */

    @Override
    public boolean execute(User user, String[] args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the View-vote command";
    }

    @Override
    public String name() {
        return "view-vote";
    }
}
