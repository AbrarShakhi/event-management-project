package com.event.management;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Main {
	private final static Dimension DEVICE_SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public final static int DEVICE_HEIGHT = (int) (DEVICE_SCREEN_SIZE.getHeight());
	public final static int DEVICE_WIDTH = (int) (DEVICE_SCREEN_SIZE.getWidth());

	private Main() {
	}

	public static void main(String[] args) {
		new WelcomePage();
	}

}
