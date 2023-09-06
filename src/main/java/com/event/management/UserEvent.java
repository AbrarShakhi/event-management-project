package com.event.management;

public class UserEvent {
    private String eventName;
    private String eventType;
    private String date;
    private String eventClass;
    private String address;
    private String status;

    public UserEvent() {
    }

    public UserEvent(String eventName, String eventType, String date, String eventClass, String address,
            String status) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.date = date;
        this.eventClass = eventClass;
        this.address = address;
        this.status = status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
