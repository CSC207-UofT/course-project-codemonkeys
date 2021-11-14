package UseCases.Commands;

import java.util.ArrayList;

public class CreateUser implements Command{

    public CreateUser() {
    }

    @Override
    public boolean execute(ArrayList args) {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the createuser command";
    }
}
