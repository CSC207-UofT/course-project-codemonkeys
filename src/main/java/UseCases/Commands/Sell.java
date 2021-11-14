package UseCases.Commands;

import java.util.ArrayList;

public class Sell implements Command{

    public Sell() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the sell command";
    }
}
