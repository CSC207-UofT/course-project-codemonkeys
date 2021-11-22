package Users;

public class BanAuthority  extends UserAuthorities{

    // Authorize an user to ban or unban other users.

    public BanAuthority(User authorizedUser){
        super(authorizedUser);
    }

   // public void Ban_User(User user){
   //     // Ban the user
   //     if(user instanceof ConcreteUser){
    // ((ConcreteUser) user).setBanned(true);
   //     }
   // }

   // public void UnBan_User(User user){
        // UnBan the user
   //     if(user instanceof ConcreteUser){
         //  ((ConcreteUser) user).setBanned(false);
  //      }
   // }

    @Override
    public  Boolean checkAuthority(String Authority) {
        // Authority can be selected.
        if(authorizedUser.checkAuthority(Authority)){ // Check if the authorized user have the authority first
            return true;
        }
        return Authority.equals("Ban");
    }

}

