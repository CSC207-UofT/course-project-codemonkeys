
package Users;
import Containers.Portfolio;
import Identification.Identifiable;

import java.util.UUID;

public abstract class User extends Identifiable {      // Apply the decoration design pattern.
    private Portfolio userPortfolio; // portfolio of the user
    private String name; // name of the user

    /**
     * Constructor that sets the name of the user
     * @param name the name of the user
     */
    public User(String name){
        super();
        this.name = name;
    }

    /**
     * Constructor that sets name, portfolio and UUID
     * @param name the name of the user
     * @param portfolio the user portfolio
     * @param id the user's UUID
     */
    public User(String name, Portfolio portfolio, UUID id){
        super();
        this.name = name;
        this.userPortfolio = portfolio;
        this.setId(id);
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

    /**
     *
     * @param Authority: A string representing a certain authority
     * @return true if user has the authority, and false otherwise.
     */
    public Boolean checkAuthority(String Authority) {
        return false;  // Since an ordinary User has no authorities.
    }
}