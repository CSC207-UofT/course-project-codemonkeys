package usecase.commands;
import usecase.managers.UserManager;
import entities.users.User;
import java.io.IOException;

/**
 * This is the concrete class for serializing and deserializing user manager
 * It includes saveToFile and readFromFile methods
 *
 * Author Zixin (Charlie) Guo
 * Date: Dec 05 2021
 * Version: 1.0
 */

public class UserReadWriter extends ReadWriter<UserManager>{
    // a brief demo code for using the read writer
    public static void main(String[] args) throws IOException {
        UserManager um = UserManager.getInstance();
        User u = new User("aaa");
        um.addUser(u);
        ReadWriter<UserManager> uw = new UserReadWriter();
        try {
            // will save to the desired location
            uw.saveToFile("./users.ser", um);
        } catch (Exception e) {
            System.out.println("cant save");
        }
        try {
            UserManager um2 = uw.readFromFile("./users.ser");
            System.out.println(um2.findUser("aaa").getName());
        } catch (Exception e) {
            System.out.println("can't read");
        }
    }
}
