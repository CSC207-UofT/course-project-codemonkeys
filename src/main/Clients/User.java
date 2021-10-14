package Clients;

import java.util.Objects;

public abstract class User {

    //____________________ Variables ___________________________________________________________________________________
    private String name; // username

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for a user
     * @param name is the username
     */
    public User(String name){
        this.name = name;
    }

    //____________________ Methods _____________________________________________________________________________________



    //____________________ Generic Overrides ___________________________________________________________________________

    /**
     * Compares this Object to another
     * @param o is the other Object
     * @return true if o is a User or a child of User
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
}
