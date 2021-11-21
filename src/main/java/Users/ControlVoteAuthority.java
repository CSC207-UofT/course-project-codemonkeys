package Users;

public class ControlVoteAuthority extends UserAuthorities {


    public ControlVoteAuthority(CommonUser authorized_user) {
        super(authorized_user);
    }

    @Override
    public  Boolean Check_Authority(String Authority) {
        // Authority can be selected.
        if(authorized_user.Check_Authority(Authority)){ // Check if the authorized user have the authority first
            return true;
        }
        return Authority.equals("Vote");
    }
}
