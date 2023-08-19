public class Admin {
    private int adminId;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getAdminId() {
        return this.adminId;
    }

    public void update(int adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    public Admin() {
    }

    public Admin(int adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }
}
