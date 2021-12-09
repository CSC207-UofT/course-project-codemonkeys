package entities.users;
import usecase.portfolio.Portfolio;
import entities.identification.Identifiable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A user class that stores a portfolio, name and a list of authorities.
 */
public class User extends Identifiable implements Serializable{      // Apply the decoration design pattern.
    private Portfolio userPortfolio; // portfolio of the user
    private String name; // name of the user
    private final ArrayList<String> authorities;
    private boolean banned;

    /**
     * Constructor that sets the name of the user.
     * The user is not banned when created.
     * @param name the name to be set.
     */
    public User(String name){
        super();
        this.name = name;
        this.authorities = new ArrayList<>();
        this.userPortfolio = new Portfolio();
        this.banned = false;
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
     * Check if the user is banned.
     * @return true if the user is banned and false otherwise
     */
    public Boolean isBanned(){
        return this.banned;
    }

    /**
     * Reset the ban status of the current user.
     * @param decision whether the user is set to be banned or unbanned.
     */
    public void setBanned(boolean decision){
        this.banned = decision;
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

