package program;

public class MainApp {
    public static void main(String[] args) {
        boolean userFound;

        try {
            userFound = FileHandling.findLogedInUser();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        new WelcomePage(userFound);
    }
}
