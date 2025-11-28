import library.LibraryManager;
import user.User;

public class Main {
    public static void main (String[] args) {

        LibraryManager manager = new LibraryManager();
        User user = new User("Aren");
        AppController controller = new AppController(manager, user);

        controller.start();
    }
}
