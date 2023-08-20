package event_type;

public class Event {
    private String themeColor;
    private String dateOfEvent;
    private String food;

    public Event() {
    }

    public Event(String themeColor, String food, String dateOfEvent) {
        this.themeColor = themeColor;
        this.dateOfEvent = dateOfEvent;
        this.food = food;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
