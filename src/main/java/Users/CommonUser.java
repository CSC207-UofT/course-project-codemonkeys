package Users;

public class CommonUser extends User {
    private String name;
    private boolean banned;

    /**
     * Constructor that only sets the name.
     */
    public CommonUser(String name) {
        super(name);
    }
}