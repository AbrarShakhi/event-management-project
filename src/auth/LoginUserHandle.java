package auth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import utility.*;

public class LoginUserHandle {

	public void saveUsername(String username){
		BufferedWriter bufferedWriter = null;
		try {
		FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME,"username");
		File app = new File(FilePaths.LOGGED_IN_USERNAME);
		
		FileWriter fileWriter = new FileWriter(app);
		 bufferedWriter = new BufferedWriter(fileWriter);
		
		bufferedWriter.write("username " +inputUsername);		//Getting the input username
		bufferedWriter.close();
		fileWriter.close();	
		
		} catch (Exception e) {
			return ;

		} finally {
			if (bufferedWriter != null)
				bufferedWriter.close();
		}
	}

	public String[] findRgisteredUser(String tergetUsername) {
		String path = FilePaths.DATA_FOLDER + "/" + FilePaths.REGISTERED_USER;

		if (!FileDir.isExists(path))
			return null;

		ArrayList<String> userInfo = new ArrayList<>();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String[] pises = scanner.nextLine().split(" ");

				if (!tergetUsername.equals(pises[0]))
					continue;

				userInfo.add(pises[0]);
				userInfo.add(pises[1]);
				userInfo.add(pises[2]);
				userInfo.add(pises[3]);

				StringBuffer sbf = new StringBuffer();
				for (int i = 4; i < pises.length; i++)
					sbf.append(pises[i] + " ");

				userInfo.add(sbf.toString().trim());
				break;
			}

		} catch (Exception e) {
			return null;

		} finally {
			if (scanner != null)
				scanner.close();
		}

		if (userInfo.size() == 0)
			return null;

		String infoAsString[] = new String[userInfo.size()];
		for (int i = 0; i < infoAsString.length; i++)
			infoAsString[i] = userInfo.get(i);

		return infoAsString;
	}

	public String findLoggedInUsername() {
		String loggedInUsername = null;
		String path = FilePaths.DATA_FOLDER + "/" + FilePaths.LOGGED_IN_USERNAME;

		if (!FileDir.isExists(path))
			return null;

		Scanner sc = null;

		try {
			sc = new Scanner(new File(path));
			String[] str = sc.nextLine().trim().split(" ");

			if (str.length != 2)
				return loggedInUsername;

			loggedInUsername = str[1];

		} catch (Exception e) {
		} finally {
			if (sc != null)
				sc.close();
		}

		return loggedInUsername;
	}

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
