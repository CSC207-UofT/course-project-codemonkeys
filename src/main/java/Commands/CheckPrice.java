package Commands;

import java.util.ArrayList;

public class CheckPrice implements Command{

    public CheckPrice() {
    }

    @Override
    public boolean execute(String user, String[] args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the upvote command";
    }

    @Override
    public String name() {
        return "checkprice";
    }
}
