package Client;
import java.util.Objects;

public abstract class User {

    //____________________ Variables ___________________________________________________________________________________

    private String name; // username
    private Portfolio portfolio; // shadow portfolio for the user
    private int userId; // the user's identification number

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for a user
     * @param name is the username
     * @param userId is the user's identification number
     */
    public User(String name, int userId){
        this.name = name;
        this.userId = userId;
    }

    public User(String name){
        this.name = name;
    }

    //____________________ Methods _____________________________________________________________________________________



    //____________________ Generic Overrides ___________________________________________________________________________

    /**
     * Compares this Object to another
     * @param o is the other Object
     * @return true if o is a Clients.User or a child of Clients.User
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    /**
     * TODO: Javadoc and hashCode function possibly for future use???
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


    //____________________ Getters and Setters__________________________________________________________________________
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
