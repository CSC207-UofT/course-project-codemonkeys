package EntityTests;

import Entities.*;
import org.junit.*;
import static org.junit.Assert.*;



public class TestUser {
    @Test(timeout = 50)
    public void testUsergetName() {
        ConcreteUser user = new ConcreteUser("test");
        assertEquals(user.getName(), "test");
    }

    @Test(timeout = 50)
    public void testUsersetName(){
        ConcreteUser user = new ConcreteUser("test");
        user.setName("test2");
        assertEquals(user.getName(), "test2");
    }

    @Test(timeout = 50)
    public void UserisBanned(){
        ConcreteUser user = new ConcreteUser("test");
        assertFalse(user.isBanned());
    }

    @Test(timeout = 50)
    public void UsersetBanned(){
        ConcreteUser user = new ConcreteUser("test");
        user.setBanned(true);
        assertTrue(user.isBanned());
    }

    @Test(timeout = 50)
    public void UsergetPortfolio(){
        ConcreteUser user = new ConcreteUser("test");
        assertNotNull(user.getPortfolio());
    }

    @Test(timeout = 50)
    public void UsersetPortfolio(){
        ConcreteUser user = new ConcreteUser("test");
        user.setPortfolio(new Portfolio());
        assertEquals(user.getPortfolio(), new Portfolio());
    }

    @Test(timeout = 50)
    public void UserBanAuthority(){
        BanAuthority user = new BanAuthority(new ConcreteUser("test"));
        ConcreteUser another = new ConcreteUser("test");
        user.Ban_User(another);
        assertTrue(another.isBanned());
    }

    @Test(timeout = 50)
    public void UserUnBanAuthority(){
        BanAuthority user = new BanAuthority(new ConcreteUser("test"));
        ConcreteUser another = new ConcreteUser("test");
        user.UnBan_User(another);
        assertFalse(another.isBanned());
    }

    @Test(timeout = 50)
    public void UserControlVote(){
        ControlVoteAuthority user = new ControlVoteAuthority(new ConcreteUser("test"));
        ConcreteUser another = new ConcreteUser("test");
        Vote v = new Vote(another, "a", "b", 12);
        user.ControlVote(v, false); // close the vote
        assertFalse(v.getStatus());
    }
}
