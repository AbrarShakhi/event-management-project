package inside;

import java.util.HashMap;

public class Item {
	private HashMap<String, Integer> eventType;
	private HashMap<String, Integer> color;
	private HashMap<Boolean, Integer> music;
	private HashMap<Integer, Integer> helper;
	private HashMap<Integer, Integer> estimatedPeople;
	private HashMap<String, Integer> msgPrompt;
	private HashMap<Boolean, Integer> decoration;
	private Food food;

	public Item() {
		this.eventType = new HashMap<>();
		this.color = new HashMap<>();
		this.music = new HashMap<>();
		this.helper = new HashMap<>();
		this.estimatedPeople = new HashMap<>();
		this.msgPrompt = new HashMap<>();
		this.decoration = new HashMap<>();
		this.food = new Food();
	}

	public HashMap<String, Integer> getEventType() {
		return eventType;
	}

	public void setEventType(HashMap<String, Integer> eventType) {
		this.eventType = eventType;
	}

	public HashMap<String, Integer> getColor() {
		return color;
	}

	public void setColor(HashMap<String, Integer> color) {
		this.color = color;
	}

	public HashMap<Boolean, Integer> getMusic() {
		return music;
	}

	public void setMusic(HashMap<Boolean, Integer> music) {
		this.music = music;
	}

	public HashMap<Integer, Integer> getHelper() {
		return helper;
	}

	public void setHelper(HashMap<Integer, Integer> helper) {
		this.helper = helper;
	}

	public HashMap<Integer, Integer> getEstimatedPeople() {
		return estimatedPeople;
	}

	public void setEstimatedPeople(HashMap<Integer, Integer> estimatedPeople) {
		this.estimatedPeople = estimatedPeople;
	}

	public HashMap<String, Integer> getMsgPrompt() {
		return msgPrompt;
	}

	public void setMsgPrompt(HashMap<String, Integer> msgPrompt) {
		this.msgPrompt = msgPrompt;
	}

	public HashMap<Boolean, Integer> getDecoration() {
		return decoration;
	}

	public void setDecoration(HashMap<Boolean, Integer> decoration) {
		this.decoration = decoration;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}