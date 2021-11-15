package Commands;
import Managers.UserManager;

import java.util.ArrayList;
import java.util.UUID;

public class CreateUser implements Command{
        public CreateUser() {
        }
        /**
         * Create new users
         * @param args list of users
         * @returns whether the execution was successful
         */

        @Override
        public boolean execute(ArrayList args) {
            UserManager um = UserManager.getInstance(); //get the UserManager

            for(Object o : args){ //loop through the arguments
                if (!(o instanceof UUID)){ //if not create before
                }
                else {return false;
                }
            }
            return true;
        }

    @Override
    public String help() {
        return "this is info for the create user command";
    }
}
