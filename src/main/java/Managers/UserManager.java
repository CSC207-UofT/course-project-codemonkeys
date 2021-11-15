package Managers;

import Identification.Identifiable;
import Users.Admin;
import Users.User;

import java.util.*;

// The user manager records user and their corresponding id.
// It also integrates permission query interfaces.
public class UserManager {

    private static UserManager instance;

    static {
        instance = new UserManager();
    }

    public static UserManager getInstance() {
        return UserManager.instance;
    }

    // The UUID of the user and the object of the user
    private final HashMap<UUID, User> storage;

    private UserManager() {
        this.storage = new LinkedHashMap<UUID, User>();
    }

    public void addUser(User u) {
        this.storage.put(u.id, u);
    }

    public void delUser(User u) {
        this.storage.remove(u.id);
    }

    public User getUser(UUID id) {
        return this.storage.get(id);
    }
    /*
    public List<Admin> getAdminList(){
        List<Admin> admins = new ArrayList<>();
        for (User user : this.values()){
            if (this.isAdmin(user))
                admins.add((Admin) user);
        }
        return admins;
    }

    */
    public boolean isAdmin(UUID id) {
        User user = this.getUser(id);
        if(user == null) return false;
        return this.isAdmin(this.getUser(id));
    }

    public boolean isAdmin(User user) {
        return user instanceof Admin;
    }

    public User find(String name) {
        Collection<? extends User> users = this.storage.values();
        for(User user : users) {
            if(!user.getName().equals(name)) continue;
            return user;
        }
        return null;
    }

    // WARNING: This method EXPOSES the real reference of User object.
    public List<User> getUserList() {
        return new ArrayList<User>(this.storage.values());
    }
}
