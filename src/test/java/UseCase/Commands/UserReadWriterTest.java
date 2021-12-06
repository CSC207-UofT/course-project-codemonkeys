package UseCase.Commands;

import Entities.Assets.Asset;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Entities.Users.User;
import UseCase.Managers.TransactionManager;
import UseCase.Managers.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class UserReadWriterTest {
    private User user1;
    private final UserManager um = UserManager.getInstance();
    private User user2;
    private UserReadWriter urw;

    @Before
    public void setUp() {
        user1 = new User("test1");
        user2 = new User("test2");
        um.addUser(user1);
        um.addUser(user2);
        urw = new UserReadWriter();
        }

    @After
    public void tearDown() {
        um.delUser(user1);
        um.delUser(user2);
        user1 = null;
        user2 = null;
        urw = null;
    }

    @Test(timeout = 500)
    public void testReadWrite() throws IOException, ClassNotFoundException {
        urw.saveToFile("./userManager.ser", um);
        UserManager newManager = urw.readFromFile("./userManager.ser");
        assert(newManager.getUserMap().size() == um.getUserMap().size());
    }
}
