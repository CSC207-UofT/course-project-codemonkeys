package Managers;

import Users.User;

import java.util.HashMap;
import java.util.UUID;

public class UserManager {
    private static UserManager instance;
    private HashMap<UUID, User> userHashMap;

    private UserManager(){
        this.userHashMap = new HashMap<UUID, User>();
    }

    static {
        instance = new UserManager();
    }


    /**
     * Gets the singleton instance of UserManager
     * @returns the instance
     */
    public static UserManager getInstance(){
        return instance;
    }


    /**
     * Gets a user by their UUID
     * @param id is the id of the user
     * @returns the desired User
     * @throws UserNotFoundException
     */
    public User getUser(UUID id) throws UserNotFoundException {
        if(!this.userHashMap.containsKey(id))
            throw new UserNotFoundException("User "+id+" not found.");
        return this.userHashMap.get(id);
    }

    /**
     * Custom exception for user not found in UserManager
     */
    class UserNotFoundException extends Exception{
        public UserNotFoundException(String errorMessage){
            super(errorMessage);
        }
    }
}
