package Commands;

import java.util.ArrayList;

public class Leave implements Command{

    public Leave() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info fo rhte leave command";
    }
}
