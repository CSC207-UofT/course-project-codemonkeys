package Commands;
import Users.User;

public class DepositMoney implements Command{
    public DepositMoney() {
    }

    @Override
    public boolean execute(User user, String[] args) {
        return true;
    }

    @Override
    public String help() {
            return "this is info for the create user command";
        }

    @Override
    public String name() {
        return "depositmoney";
    }

}
