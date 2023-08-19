public class Client {
    private String address;
    private String contacts;
    private int clientId;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public int getClientId() {
        return clientId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void create() {
    }

    public void update(String address, String contacts, int clientId, String name) {
        this.address = address;
        this.contacts = contacts;
        this.clientId = clientId;
        this.name = name;
    }

    public Client() {
    }

    public Client(String address, String contacts, int clientId, String name) {
        this.address = address;
        this.contacts = contacts;
        this.clientId = clientId;
        this.name = name;
    }

}