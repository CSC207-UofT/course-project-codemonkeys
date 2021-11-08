package Entities;

public abstract class UserAuthorities implements User{ // The abstract decorator class
    protected User authorized_user;

    public UserAuthorities(User authorized_user){
        this.authorized_user = authorized_user;
    }
}
