package Users;

public abstract class UserAuthorities extends User { // The abstract decorator class
    protected User authorizedUser;

    /**
     *
     * @param authorizedUser the user that the authority is given to
     */
    public UserAuthorities(User authorizedUser){
        super(authorizedUser.getName(), authorizedUser.getUserPortfolio(), authorizedUser.getId());
        this.authorizedUser = authorizedUser;
    }
}
