package Commands;

import java.util.ArrayList;
import java.util.UUID;

public class Viewvote implements Command{
    public Viewvote() {
    }

    @Override
    public boolean execute(String user, String[] args) {
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
