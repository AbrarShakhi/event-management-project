package com.event.management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandle {
	protected static final String DATA_FOLDER = ".database";
	protected static final String LOGGED_IN_USERNAME = ".loggedin_username.txt";
	protected static final String REGISTERED_USER = ".registered_users.txt";
	protected static final String ADDED_EVENT = ".added_event.txt";

	protected static boolean isAlreadyLoggedIn() {
		if (!isExists(DATA_FOLDER + "/" + LOGGED_IN_USERNAME) &&
				!isExists(DATA_FOLDER + "/" + REGISTERED_USER))
			return false;

		boolean userFound = false;

		File logFile = null;
		Scanner scanner = null;

		try {
			logFile = new File(DATA_FOLDER + "/" + LOGGED_IN_USERNAME);
			scanner = new Scanner(logFile);

			scanner.next();
			if (scanner.hasNextLine())
				userFound = true;

		} catch (FileNotFoundException e) {
			return false;
		} catch (Exception e) {
			resetFile(LOGGED_IN_USERNAME, "username");
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return userFound;
	}

	protected static boolean isExists(String path) {
		return new File(path).exists();
	}

	protected static void createDir(String dir) {
		File path = new File(dir);

		if (!path.exists())
			path.mkdir();
	}

	protected static void resetFile(String filePath, String outpuString) {

		createDir(DATA_FOLDER);

		FileWriter fr = null;

		try {
			fr = new FileWriter(DATA_FOLDER + "/" + filePath);
			fr.write(outpuString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e) {
			}
		}

	}

	protected static void AppendFile(String fileName, String promt) {
		createDir(FileHandle.DATA_FOLDER);

		String path = FileHandle.DATA_FOLDER + "/" + fileName;
		FileWriter fr = null;
		try {
			if (!isExists(path)) {
				try {
					fr = new FileWriter(path);
					fr.write("");
				} catch (Exception e) {
				} finally {
					if (fr != null)
						try {
							fr.close();
						} catch (Exception e) {
						}
				}
			}

			fr = new FileWriter(path, true);
			fr.append("\n" + promt);
		} catch (Exception e) {
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (Exception e) {
				}
		}
	}

	public static ArrayList<UserEvent> getEventList() {
		ArrayList<UserEvent> eventList = new ArrayList<>();

		if (!isExists(DATA_FOLDER + "/" + ADDED_EVENT))
			return eventList;

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(DATA_FOLDER + "/" + ADDED_EVENT));
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				if (input == null)
					continue;
				if (input.length() < 1 || input.isEmpty())
					continue;

				String[] eventInfo = input.split(";");
				for (int i = 0; i < eventInfo.length; i++) {
					eventInfo[i] = eventInfo[i].trim();
				}
				eventList.add(new UserEvent(eventInfo[0], eventInfo[1], eventInfo[2], eventInfo[3], eventInfo[4],
						eventInfo[5]));
			}
		} catch (Exception e) {
			return new ArrayList<UserEvent>();
		}

		return eventList;
	}
}
