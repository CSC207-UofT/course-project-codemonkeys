
package Users;
import Containers.Portfolio;
import Identification.Identifiable;

public abstract class User extends Identifiable {      // Apply the decoration design pattern.
    private Portfolio userPortfolio; // portfolio of the user
    private String name; // name of the user

    public User(String name){
        super();
        this.name = name;

    }
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

    public Boolean checkAuthority(String Authority) {
        // Check if the user has the corresponding authorities.
        return false;  // Since an ordinary User has no authorities.
    }
}