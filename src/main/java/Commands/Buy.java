package Commands;

import java.util.ArrayList;
import java.util.UUID;

public class Buy implements Command{
    public Buy() {
    }

    @Override
    public boolean execute(String user, String[] args) {
        return true;
    }

    @Override
    public String help() {
            return "this is info for the create user command";
        }

    @Override
    public String name() {
        return "buy";
    }

}
