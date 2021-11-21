
package Users;
import Containers.Portfolio;
import Identification.Identifiable;

public abstract class User extends Identifiable {      // Apply the decoration design pattern.
    private Portfolio user_portfolio; // portfolio of the user
    private String name; // name of the user

    public User(String name){
        super(name);  // create user's UUID from the user's name
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_portfolio(Portfolio user_portfolio) {
        this.user_portfolio = user_portfolio;
    }

    public Portfolio getUser_portfolio(){
        return this.user_portfolio;
    }

    public Boolean Check_Authority(String Authority) {
        // Check if the user has the corresponding authorities.
        return false;  // Since an ordinary User has no authorities.
    }
}