package Managers;
import Users.*;

import java.util.*;

public class UserManager {
    private final Map<UUID, User> userMap;

    //create an object of UserManager
    private static final UserManager instance = new UserManager();

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
    public void addCommonUser(String name){
        User user = new CommonUser(name);
        this.userMap.put(user.id, user);
    }

    /**
     * creat and add user with authorities
     * @param name name of the user
     * @param authorities the authorities a user has
     */
    public void addUserAuthorities(String name, String authorities){
        if (authorities.equalsIgnoreCase("Vote")){
            User user = new ControlVoteAuthority(new CommonUser(name));
        }
        if (authorities.equalsIgnoreCase("Ban")){
            User user = new BanAuthority(new CommonUser(name));
        }
        if (authorities.equalsIgnoreCase("Vote Ban") ||
                authorities.equalsIgnoreCase("Ban Vote")){
            User user = new BanAuthority(new ControlVoteAuthority(new CommonUser(name)));
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


// Todo: Add method give user authority
}
