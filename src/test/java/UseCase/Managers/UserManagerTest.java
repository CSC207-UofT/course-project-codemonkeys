package UseCase.Managers;

import Entities.Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private final UserManager um = UserManager.getInstance();
    User user1, user2, user3;

    @Before
    public void setUp() {
        user1 = new User("a");
        user2 = new User("b");
        user3 = new User("c");
        user3.addAuthority("Kick");
        um.addUser(user1);
        um.addUser(user2);
        um.addUser(user3);
        um.addUser("d");
    }

    @After
    public void teardown(){
        for(User user: um.getUserList()){
            um.delUser(user);
        }
    }

    @Test
    public void testGiveUserAuthorities(){
        assertFalse(user1.checkAuthority("Ban"));
        um.giveUserAuthorities("a", new String[]{"Ban"});
        assertTrue(user1.checkAuthority("Ban"));
    }

    @Test
    public void TestRemoveUserAuthorities(){
        assertTrue(user3.checkAuthority("Kick"));
        um.removeUserAuthorities("c", new String[]{"Kick"});
        assertFalse(user3.checkAuthority("Kick"));
    }

    @Test
    public void TestAddUserAuthorities(){
        assertNull(um.findUser("e"));
        um.addUserAuthorities("e", new String[] {"Ban", "Kick"});
        User user4 = um.findUser("e");
        assertTrue(user4.checkAuthority("Kick"));
        assertTrue(user4.checkAuthority("Ban"));

    }

    @Test
    public void TestViewUserAsset(){
        System.out.println(um.viewUserAsset(user1));
    }


}
