package Commands;

import Users.User;

import java.util.ArrayList;

public class Leave implements Command{

    public Leave() {
    }

    @Override
    public boolean execute(User user, String[] args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info fo rhte leave command";
    }

    @Override
    public String name() {
        return "help";
    }
}
