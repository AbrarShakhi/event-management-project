package com.event.management;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Auth {

	protected static String findLoggedInUsername() {
		String loggedInUsername = null;
		String path = FileHandle.DATA_FOLDER + "/" + FileHandle.LOGGED_IN_USERNAME;

		if (!FileHandle.isExists(path))
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

	protected static String[] findRgisteredUser(String tergetUsername) {
		String path = FileHandle.DATA_FOLDER + "/" + FileHandle.REGISTERED_USER;

		if (!FileHandle.isExists(path))
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

	public static boolean checkUserAvailibility(String targetInput) {
		String[] registerInput = findRgisteredUser(targetInput);
		if (registerInput == null)
			return true;

		if (registerInput.length != 5)
			return true;

		return false;
	}

	protected static int passwordType(String password) {
		if (!password.equals(password.trim()))
			return -1;

		if (!Auth.validPassword(password))
			return 1;

		return 0;
	}

	protected static boolean validInfoToRegister(String str) {
		if (str.contains(" "))
			return false;
		if (str.contains("\t"))
			return false;
		if (str.contains("\n"))
			return false;
		return true;
	}

	protected static boolean validPassword(String pw) {
		if (pw.length() < 8)
			return false;

		StringBuffer buff = new StringBuffer(pw);
		int length = buff.length();

		boolean hasDigit = false;
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasSpecial = false;

		for (int i = 0; i < length; i++) {

			char ch = buff.charAt(i);
			if (CheckChar.isDigit(ch))
				hasDigit = true;
			else if (CheckChar.isUpperCase(ch))
				hasUpper = true;
			else if (CheckChar.isLowerCase(ch))
				hasLower = true;
			else if (CheckChar.isSpecial(ch))
				hasSpecial = true;
			else
				return false;
		}
		return hasDigit && hasUpper && hasLower && hasSpecial;
	}
}
