package people;

public class User {
	private String name;
	private String username;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
