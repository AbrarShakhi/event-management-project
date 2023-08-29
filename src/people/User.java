package people;

public class User {
	String name;
	String username;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
	}

	public User(String username, String name) {
		this.username = username;
		this.setName(name);
	}

}
