package Entities;
import java.util.UUID;

public class BanAuthority extends UserAuthorities{

    public BanAuthority(User authorized_user){
        super(authorized_user);
    }

    public void Ban_User(UUID user_id){
        //TODO TO BE IMPLEMENTED
    }

}
