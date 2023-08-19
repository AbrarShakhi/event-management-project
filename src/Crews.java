public class Crews {
    private int crewId;
    private String title;
    private String description;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public void setTitl(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCrewId() {
        return crewId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void create() {
    }

    public void update(int crewId, String title, String description, String name) {
        this.crewId = crewId;
        this.title = title;
        this.description = description;
        this.name = name;
    }

    public Crews() {
    }

    public Crews(int crewId, String title, String description, String name) {
        this.crewId = crewId;
        this.title = title;
        this.description = description;
        this.name = name;
    }

}