package Managers;
import Users.*;
import java.io.Serializable;
import java.util.*;

public class UserManager implements Serializable{
    private final Map<UUID, User> userMap;

    //create an object of UserManager
    private static final UserManager instance = new UserManager();


    public Map<UUID, User> getUserMap() {
        return this.userMap;
    }

    private UserManager() {this.userMap = new HashMap<>();}

    //Get the only object available
    public static UserManager getInstance() {return instance;}

    public void addUser(User u) {
        this.userMap.put(u.id, u);
    }

    /**
     * creat and add user without authorities
     * @param name name of the user
     */
    public void addUser(String name){
        User user = new User(name);
        this.userMap.put(user.id, user);
    }

    /**
     * creat and add user with authorities
     * @param name name of the user
     * @param authorities the authorities a user has
     */
    public void addUserAuthorities(String name, String[] authorities){
        User user = new User(name);
        for (String authority: authorities){
            user.addAuthority(authority);
        }
        this.userMap.put(user.id, user);
    }

    /**
     * give a user in userMap authorities
     * @param name name of the user
     * @param authorities the authorities a user is given
     */
    public void giveUserAuthorities(String name, String[] authorities){
        for (User user: this.userMap.values()){
            if (Objects.equals(user.getName(), name)) {
                for (String authority: authorities){
                    user.addAuthority(authority);
                }
            }
        }
    }

    /**
     * remove a user's authorities
     * @param name name of the user
     * @param authorities the authorities a user is to be removed
     */
    public void removeUserAuthorities(String name, String[] authorities){
        for (User user: this.userMap.values()){
            if (Objects.equals(user.getName(), name)) {
                for (String authority: authorities){
                    user.removeAuthority(authority);
                }
            }
        }
    }

    public void delUser(User u) {
        this.userMap.remove(u.id);
    }

    public void delUser(String name) {
        for (User user: this.userMap.values()) {
            if (Objects.equals(user.getName(), name)) {
                this.userMap.remove(user.id);
            }
        }
    }

    /**
     * Find the user in the system using the user's name
     * @param name the user name
     * @return User or null if did not find the user
     */
    public User findUser(String name) {
        for (User user: this.userMap.values()) {
            if (Objects.equals(user.getName(), name)) {
                return user;
            }
        }
        return null;
    }

    public int numUser(){
        return this.userMap.size();
    }

}
