package UseCases.Commands;

import java.util.ArrayList;

public class Buy implements Command{

    public Buy() {}

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the buy command";
    }
}
