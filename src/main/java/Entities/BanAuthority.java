package Entities;
import java.util.UUID;

public class BanAuthority extends UserAuthorities{
    // Authorize an user to ban or unban other users.

    public BanAuthority(User authorized_user){
        super(authorized_user);
    }

    public void Ban_User(User user){
        // Ban the user
        if(user instanceof ConcreteUser){
            ((ConcreteUser) user).setBanned(true);
        }
    }

    public void UnBan_User(User user){
        // UnBan the user
        if(user instanceof ConcreteUser){
            ((ConcreteUser) user).setBanned(false);
        }
    }

}
