package Users;

public class BanAuthority  extends UserAuthorities{

    // Authorize an user to ban or unban other users.

    public BanAuthority(User authorizedUser){
        super(authorizedUser);
    }

    @Override
    public  Boolean checkAuthority(String Authority) {
        // Authority can be selected.
        if(authorizedUser.checkAuthority(Authority)){ // Check if the authorized user have the authority first
            return true;
        }
        return Authority.equals("Ban");
    }

}

