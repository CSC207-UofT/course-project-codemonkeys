package UseCases.Commands;

import java.util.ArrayList;

public class Viewvote implements Command{
    public Viewvote() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the view vote command";
    }
}
