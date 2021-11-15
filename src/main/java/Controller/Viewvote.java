package Commands;

import Users.User;

import java.util.ArrayList;
import java.util.UUID;

public class Viewvote implements Command{
    public Viewvote() {
    }

    @Override
    public boolean execute(User user, String[] args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the viewvote command";
    }

    @Override
    public String name() {
        return "viewvote";
    }

}
