package UseCases.Commands;

public class Leave implements Command{

    public Leave() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info fo rhte leave command";
    }
}
