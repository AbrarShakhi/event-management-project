package people;

import event_type.*;

public class User extends Information {
    private String userType;
    private String username;
    private String password;
    private Event event;

    public User() {
        userType = "default";
        int id = new java.util.Random().nextInt();
        setIdNumber(Integer.toString(id));
    }

    public User(String FirstName, String LastName, String username, String password) {
        setName(FirstName + " " + LastName);
        setUsername(username);
        setPassword(password);
        userType = "default";
        int id = new java.util.Random().nextInt();
        setIdNumber(Integer.toString(id));
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void add() {
    }

    public void delete() {
    }
}