import auth.LoginUserHandle;
import ui.WelcomePage;
import utility.FileDir;
import utility.FilePaths;

public class MainApp {
	public static void main(String[] args) {
		boolean alreadyLogedIn;

		if (!FileDir.isExists(FilePaths.DATA_FOLDER + "/" + FilePaths.LOGGED_IN_USERNAME) &&
				!FileDir.isExists(FilePaths.DATA_FOLDER + "/" + FilePaths.REGISTERED_USER))
			alreadyLogedIn = false;
		else {
			alreadyLogedIn = LoginUserHandle.isLoggedIn();
		}

		new WelcomePage(alreadyLogedIn);
		return;
	}
}
