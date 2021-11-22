package Users;

public class ControlVoteAuthority extends UserAuthorities {


    public ControlVoteAuthority(User authorizedUser) {
        super(authorizedUser);
    }

    @Override
    public  Boolean checkAuthority(String Authority) {
        // Authority can be selected.
        if(authorizedUser.checkAuthority(Authority)){ // Check if the authorized user have the authority first
            return true;
        }
        return Authority.equals("Vote");
    }
}
