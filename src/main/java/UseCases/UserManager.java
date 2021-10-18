package UseCases;

import Entities.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap;

    private UserManager() {
        this.userMap = new HashMap<String, User>();
    }

    private static UserManager instance = null;

    public static UserManager getInstance() {
        if(UserManager.instance == null) {
            UserManager.instance = new UserManager();
        }
        return UserManager.instance;  // UserManager only initiated for once
    }

    public void addUser(User u) {
        this.userMap.put(u.getName(), u);
    }

    public void delUser(User u) {
        this.userMap.remove(u.getName());
    }

    public void delUser(String name) {
        this.userMap.remove(name);
    }

    public Collection<User> getAllUsers(){
        return this.userMap.values();
    }

    public User getUser(String name){
        return this.userMap.get(name);
    }

    public static String checkUserName(String name) {
        if (name == null) {
            throw new NullPointerException("no name");
        }
        name = name.trim();
        if (name.isEmpty()){
            throw new IllegalArgumentException("name cannot be empty");
        }
        return name;
    }

    public static boolean isUserPresent(String name) {
        return UserManager.getInstance().getUser(name) != null;
    }

    public int getUserSize() {
        return this.userMap.size();
    }

    public void addAsset(String username, String AssetName) {  //TODO change return type to boolean
        this.getUser(username).addAsset(AssetName);
    }
}
