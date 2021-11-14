package Managers;

import Users.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
