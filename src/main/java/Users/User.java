package Users;
import Containers.Portfolio;
import Identification.Identifiable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A user class that stores a portfolio, name and a list of authorities.
 */
public class User extends Identifiable implements Serializable{      // Apply the decoration design pattern.
    private Portfolio userPortfolio; // portfolio of the user
    private String name; // name of the user
    private final ArrayList<String> authorities;

    /**
     * Constructor that sets the name of the user.
     * @param name the name to be setted.
     */
    public User(String name){
        super();
        this.name = name;
        this.authorities = new ArrayList<>();
        this.userPortfolio = new Portfolio();
    }

    /**
     * Add an authority to the user.
     * @param authority The authority to be added.
     * @return true if the authority is successfully added, false if the user already have the authority.
     */
    public boolean addAuthority(String authority){
        if(authorities.contains(authority)){
            return false;
        }else{
            authorities.add(authority);
            return true;
        }
    }

    /**
     * Add an authority to the user.
     * @param authority The authority to be removed.
     * @return true if the authority is successfully removed, false if the user do not have the authority.
     */
    public boolean removeAuthority(String authority){
        if(authorities.contains(authority)){
            authorities.remove(authority);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Check if the user has the given authority
     * @param authority the authority to be checked
     * @return true if the user have the authority, false otherwise.
     */
    public Boolean checkAuthority(String authority) {
        return authorities.contains(authority);
    }

    /**
     * Getters and Setters for user attributes.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserPortfolio(Portfolio userPortfolio) {
        this.userPortfolio = userPortfolio;
    }

    public Portfolio getUserPortfolio(){
        return this.userPortfolio;
    }
}

