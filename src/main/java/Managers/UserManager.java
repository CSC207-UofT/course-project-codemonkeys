package Managers;

import Users.Admin;
import Users.User;

import java.util.*;

public class UserManager extends HashMap<UUID, User>{
    //_______________________________________________ Variables ________________________________________________________

    private static UserManager instance;

    //______________________________________________ Constructors ______________________________________________________

    private UserManager(){
        super();
    }

    static {
        instance = new UserManager();
    }

    //_________________________________________________ Methods ________________________________________________________
    public void addUser(User u) {
        instance.put(u.getId(), u);
    }

    public void addUser(String u) {
        User user = new User(u);
        instance.put(user.getId(), user);
    }

    public void delUser(String u) {
        for (User user: instance.values()) {
            if (Objects.equals(user.getName(), u)) {
                instance.remove(user.getId());
            }
        }
    }

    public void delUser(User u) {
        instance.remove(u.getId());
    }

    public User findUser(String s){
        for (User user: instance.values()) {
            if (Objects.equals(user.getName(), s)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Gets the singleton instance of UserManager
     * @returns the instance
     */
    public static UserManager getInstance(){
        return instance;
    }

    /**
     * Gets a list of all admins
     * @return
     */
    public List<Admin> getAdminList(){
        List<Admin> admins = new ArrayList<>();
        for (User user : this.values()){
            if (user instanceof Admin)
                admins.add((Admin) user);
        }
        return admins;
    }

    /**
     * Checks if a UUID is associated with an admin
     * @param id is the UUID
     * @returns whether that user, if they exist, is an admin
     */
    public boolean isAdmin(UUID id){
        return this.get(id) instanceof Admin;
    }

}
