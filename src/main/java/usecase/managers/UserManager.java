package usecase.managers;
import entities.users.*;
import usecase.commands.ReadWriter;
import usecase.commands.UserReadWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class UserManager implements Serializable{
    private final Map<UUID, User> userMap;
    private static final ReadWriter<UserManager> rw = new UserReadWriter();

    //create an object of UserManager
    private static UserManager instance = new UserManager();

    //Get the only object available
    public static UserManager getInstance() {
        return instance;
    }

    public static void load(){
        try{
            instance = rw.readFromFile("./output/userManager.ser");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Read User Manager Error: " + e.getMessage());
        }
    }

    // serialize the current user manager
    public void save() {
        try {
            rw.saveToFile("./output/userManager.ser", instance);
        }
        catch (IOException e){
            System.out.println("Save User Manager Error: " + e.getMessage());
        }
    }


    public Map<UUID, User> getUserMap() {
        return this.userMap;
    }

    public List<User> getUserList () {
        ArrayList<User> userList = new ArrayList<>();

        for (UUID id : userMap.keySet()) {
            userList.add(userMap.get(id));
        }

        return userList;
    }

    private UserManager() {this.userMap = new HashMap<>();}


    public void addUser(User u) {
        if (!this.userMap.containsValue(u)){
            this.userMap.put(u.id, u);
        }
    }

    /**
     * creat and add user without authorities
     * @param name name of the user
     */
    public void addUser(String name){
        if(findUser(name) == null){
            User user = new User(name);
            this.userMap.put(user.id, user);
        }
    }

    /**
     * creat and add user with authorities
     * @param name name of the user
     * @param authorities the authorities a user has
     */
    public void addUserAuthorities(String name, String[] authorities){
        if(findUser(name) == null) {
            User user = new User(name);
            for (String authority : authorities) {
                user.addAuthority(authority);
            }
            this.userMap.put(user.id, user);
        }
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
     * @param name the username
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

    public String viewUserAsset(User u){
        return u.getUserPortfolio().toString();
    }
}
