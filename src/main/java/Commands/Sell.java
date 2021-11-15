package Commands;

import java.util.ArrayList;
import java.util.UUID;

public class Sell implements Command{
    public Sell() {
    }

    @Override
    public boolean execute(String user, String[] args) {
       return false;
    }

    @Override
    public String help() {
        return "this is info for the sell command";
    }

    @Override
    public String name() {
        return "sell";
    }
}
