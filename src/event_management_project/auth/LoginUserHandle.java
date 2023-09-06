package auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import utility.FileDir;
import utility.FilePaths;

public class LoginUserHandle {





	public static boolean isLoggedIn() {

		boolean userFound = false;

		File logFile = null;
		Scanner scanner = null;

		try {
			logFile = new File(FilePaths.DATA_FOLDER + "/" + FilePaths.LOGGED_IN_USERNAME);
			scanner = new Scanner(logFile);

			scanner.next();
			if (scanner.hasNextLine())
				userFound = true;

		} catch (FileNotFoundException e) {
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "permition denied", "ERROR",
					JOptionPane.ERROR_MESSAGE);

			FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return userFound;
	}
}
