package auth;

public class RegisterUserHandle {
	LoginUserHandle loginUserHandle;

	public boolean checkUserAvailibility(String targetInput) {
		loginUserHandle = new LoginUserHandle();

		String[] registerInput = loginUserHandle.findRgisteredUser(targetInput);
		if (registerInput == null)
			return true;
		
		if (registerInput.length != 5)
			return true;

		return false;

	}

}