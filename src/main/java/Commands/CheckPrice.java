package Commands;

import java.util.ArrayList;

public class CheckPrice implements Command{

    public CheckPrice() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the upvote command";
    }
}
