package Users;

public abstract class UserAuthorities extends User { // The abstract decorator class
    protected User authorizedUser;

    public UserAuthorities(User authorizedUser){
        super(authorizedUser.getName());
        this.authorizedUser = authorizedUser;
    }
}
