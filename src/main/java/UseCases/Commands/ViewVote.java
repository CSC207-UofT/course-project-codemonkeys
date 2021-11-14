package UseCases.Commands;

import java.util.ArrayList;

public class ViewVote implements Command{

    public ViewVote() {}

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the viewvote command";
    }
}
