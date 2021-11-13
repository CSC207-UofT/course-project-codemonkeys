import Client.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("faye", 123);
        System.out.println(user1.getId());
        User user2 = new User("bob", 123423);
        System.out.println(user1.getId()+ " " + user2.getId());
    }
}
