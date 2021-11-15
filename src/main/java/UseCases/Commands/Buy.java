<<<<<<< HEAD
package Commands;

import java.util.ArrayList;
import java.util.UUID;

public class Buy implements Command{
        public Buy() {
        }
        @Override
        public boolean execute(ArrayList args) {
            return true;
=======
package UseCases.Commands;

import java.util.ArrayList;

public class Buy implements Command{

        public Buy() {
        }

        @Override
        public boolean execute(ArrayList args) {
            return false;
>>>>>>> origin/main
        }

        @Override
        public String help() {
<<<<<<< HEAD
            return "this is info for the create user command";
        }
    }
}
=======
            return "this is info for the Buy command";
        }
}


>>>>>>> origin/main
