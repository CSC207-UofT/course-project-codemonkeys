package Users;

public abstract class UserAuthorities extends User { // The abstract decorator class
    protected User authorized_user;

    public UserAuthorities(User authorized_user){
        super(authorized_user.getName());
        this.authorized_user = authorized_user;
    }
}
