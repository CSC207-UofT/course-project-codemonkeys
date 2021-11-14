package UseCases.Commands;

import java.util.ArrayList;

public class Downvote implements Command{
    public Downvote() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the downvote command";
    }
}