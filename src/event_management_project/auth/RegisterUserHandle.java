package auth;

import utility.CheckChar;

public class RegisterUserHandle {
	private LoginUserHandle loginUserHandle;

	public RegisterUserHandle() {
		loginUserHandle = new LoginUserHandle();
	}

	public boolean checkUserAvailibility(String targetInput) {

		String[] registerInput = loginUserHandle.findRgisteredUser(targetInput);
		if (registerInput == null)
			return true;

		if (registerInput.length != 5)
			return true;

		return false;

	}

	public boolean validInfoToRegister(String str) {
		if (str.contains(" "))
			return false;
		if (str.contains("\t"))
			return false;
		if (str.contains("\n"))
			return false;
		return true;
	}

	public int passwordType(String password) {
		if (!password.equals(password.trim()))
			return -1;

		if (!validPassword(password))
			return 1;

		return 0;
	}

	private boolean validPassword(String pw) {
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