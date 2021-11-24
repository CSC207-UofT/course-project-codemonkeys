package Users;

public class BanAuthority  extends UserAuthorities{

    // Authorize an user to ban or unban other users.

    public BanAuthority(User authorizedUser){
        super(authorizedUser);
    }

    /**
     * Overwrite checkAuthority so that when given "Ban" it returns true.
     * @param Authority: A string representing a certain authority
     * @return true if user has the authority, and false otherwise.
     */
    @Override
    public  Boolean checkAuthority(String Authority) {
        // Authority can be selected.
        if(authorizedUser.checkAuthority(Authority)){ // Check if the authorized user have the authority first
            return true;
        }
        return Authority.equals("Ban");
    }

}

