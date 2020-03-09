/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-März-05
 */

public class main {
    public static void main(String[] args) {
        Window chat = new Window(new User("Peter"));
        chat.addUser(new User("Leo"));
        chat.addUser(new User("Gergos"));
        chat.addUser(new User("Maddin"));
    }
}
