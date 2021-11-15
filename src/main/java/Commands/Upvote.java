package Commands;

import Users.User;

import java.util.ArrayList;

public class Upvote implements Command{

    public Upvote() {
    }

    @Override
    public boolean execute(User user, String[] args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the upvote command";
    }

    @Override
    public String name() {
        return "upvote";
    }
}
