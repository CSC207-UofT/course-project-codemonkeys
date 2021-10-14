import java.util.Objects;

public abstract class User {

    //____________________ Variables ___________________________________________________________________________________
    private String name;
    private int userId;

    //____________________ Constructors ________________________________________________________________________________
    public User(String name, int userId){
        this.name = name;
        this.userId = userId;
    }

    //____________________ Methods _____________________________________________________________________________________



    //____________________ Generic Overrides ___________________________________________________________________________
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

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

    public String getuserId(){
        return this.userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }
}
