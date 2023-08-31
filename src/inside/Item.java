package inside;

import java.awt.Color;

public class Item {
	private String eventType;
	private Color color;
	private boolean music;
	private int helper;
	private int estimatedPeople;
	private String msgPrompt;
	private Food food;
	private boolean decoration;

	public Item() {
	}

	public Item(String eventType, Color color,
			boolean music, int helper,
			int estimatedPeople, String msgPrompt,
			Food food, boolean decoration) {
		this.eventType = eventType;
		this.color = color;
		this.music = music;
		this.helper = helper;
		this.estimatedPeople = estimatedPeople;
		this.msgPrompt = msgPrompt;
		this.food = food;
		this.decoration = decoration;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}

	public int getHelper() {
		return helper;
	}

	public void setHelper(int helper) {
		this.helper = helper;
	}

	public int getEstimatedPeople() {
		return estimatedPeople;
	}

	public void setEstimatedPeople(int estimatedPeople) {
		this.estimatedPeople = estimatedPeople;
	}

	public String getMsgPrompt() {
		return msgPrompt;
	}

	public void setMsgPrompt(String msgPrompt) {
		this.msgPrompt = msgPrompt;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public boolean getDecoration() {
		return decoration;
	}

	public void setDecoration(boolean decoration) {
		this.decoration = decoration;
	}

}