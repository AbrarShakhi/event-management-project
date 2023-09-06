package com.event.management;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CreateEventPage extends JFrame {
	private User user;
	public final Dimension CREATEEVENT_FRAME_D;

	private JButton create, cancel;

	public CreateEventPage(User user) {
		this.user = user;
		CREATEEVENT_FRAME_D = new Dimension(2 * Main.DEVICE_WIDTH / 9, 2 * Main.DEVICE_HEIGHT / 3);

		setTitle("Create Event");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(CREATEEVENT_FRAME_D);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		//

		setVisible(true);
	}
}
