package UseCases.Commands;

public class CreateUser implements Command{

    public CreateUser() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the createuser command";
    }
}
