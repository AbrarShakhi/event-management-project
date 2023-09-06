package com.event.management;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;

public class HomePage extends JFrame {
	private User user;
	public final Dimension HOME_FRAME_D;

	private JButton createEventBtn, exiButton, refressW;

	public HomePage(User user) {
		this.user = user;
		HOME_FRAME_D = new Dimension(3 * Main.DEVICE_WIDTH / 4, 5 * Main.DEVICE_HEIGHT / 6);

		setTitle("Dashboard");
		setTitle("Event management system");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(HOME_FRAME_D);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		getEventInfo();

		activity();

		getContentPane().add(createEventBtn);
		getContentPane().add(refressW);
		getContentPane().add(exiButton);

		setVisible(true);
	}

	private void getEventInfo() {
		this.user.setEventList(FileHandle.getEventList());
	}

	private void activity() {
		int x, y, w, h;
		createEventBtn = new JButton("Create Event");

		x = 5;
		y = 5;
		w = 100;
		h = 20;
		createEventBtn.setBounds(x, y, w, h);
		createEventBtn.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
		createEventBtn.setFocusable(false);
		createEventBtn.addActionListener(e -> {
			new CreateEventPage(user);
			dispose();
		});

		exiButton = new JButton("Exit");
		x = getWidth() - 100 - 20;
		y = 5;
		w = 100;
		h = 20;
		exiButton.setBounds(x, y, w, h);
		exiButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
		exiButton.setFocusable(false);
		exiButton.addActionListener(e -> {

			int choice = JOptionPane.showOptionDialog(null, "Do you want to save login info?", "exit",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
			switch (choice) {
				case 0:
					FileHandle.resetFile(FileHandle.LOGGED_IN_USERNAME, "username " + user.getUsername());
					break;
				case 1:
					FileHandle.resetFile(FileHandle.LOGGED_IN_USERNAME, "username");
					break;
				default:
					return;
			}

			try {
				dispose();
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				return;
			}

			new WelcomePage();
			dispose();
		});

		refressW = new JButton("Refresh");
		x = createEventBtn.getX() + createEventBtn.getWidth() + 5;
		y = 5;
		w = 100;
		h = 20;
		refressW.setBounds(x, y, w, h);
		refressW.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
		refressW.setFocusable(false);
		refressW.addActionListener(e -> {
			dispose();
			new HomePage(user);
		});
	}
}
