package com.event.management;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

public class HomePage extends JFrame {
	private User user;
	private ArrayList<UserEvent> eventList;

	public final Dimension HOME_FRAME_D;

	private JButton createEventBtn, exiButton, refressW;
	private JLabel noEventlbl;
	private BoxLayout box;
	private JPanel dashpane;

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

		if (user.getEventList().size() < 1) {
			noEventlbl = new JLabel("No event booked", 0);
			int x, y, w, h;
			x = getWidth() / 4;
			y = getHeight() / 4;
			w = getWidth() / 2;
			h = getHeight() / 2;
			noEventlbl.setBounds(x, y, w, h);
			noEventlbl.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30));

			getContentPane().add(noEventlbl);
		} else {
			dashpane = new JPanel();
			int x, y, w, h;
			x = 5;
			y = createEventBtn.getY() + createEventBtn.getHeight() + 10;
			w = getWidth() - 25;
			h = getHeight() - createEventBtn.getHeight() - 60;
			dashpane.setBounds(x, y, w, h);
			box = new BoxLayout(dashpane, BoxLayout.Y_AXIS);
			dashpane.setLayout(box);

			for (int i = 0; i < user.getEventList().size() && i < 5; i++) {
				JLabel name = new JLabel(user.getEventList().get(i).getEventName());
				JLabel type = new JLabel(user.getEventList().get(i).getEventType());
				JLabel date = new JLabel(user.getEventList().get(i).getDate());
				JLabel evntclass = new JLabel(user.getEventList().get(i).getEventClass());
				JLabel address = new JLabel(user.getEventList().get(i).getAddress());
				JLabel status = new JLabel(user.getEventList().get(i).getStatus());

				JPanel p = new JPanel();
				x = 0;
				y = dashpane.getY();
				w = dashpane.getWidth() - 10;
				h = dashpane.getHeight() / 6;
				p.setBounds(x, y, w, h);
				p.setLayout(null);

				x = 5;
				y = 5;
				w = p.getWidth() / 4;
				h = 40;
				name.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
				name.setBounds(x, y, w, h);

				x = name.getX() + 3;
				y = name.getY() + name.getHeight();
				w = name.getWidth() / 4;
				h = 30;
				type.setBounds(x, y, w, h);

				x = p.getWidth() - 100;
				y = p.getHeight() / 2;
				w = 100;
				h = 20;
				date.setBounds(x, y + (h * 3), w, h);

				x = 5;
				y = date.getY() + date.getHeight();
				w = date.getWidth() / 4;
				h = 30;
				evntclass.setBounds(x, (h * 4) + w, w, h);

				x = 5;
				y = p.getY() + 25;
				w = p.getWidth() / 2;
				h = 25;
				address.setBounds(x, y + (h * 5), w, h);

				x = p.getWidth() - 100;
				y = p.getHeight();
				w = 100;
				h = 20;
				status.setForeground(Color.RED);
				status.setBounds(x, y, w, h);

				p.add(name);
				p.add(type);
				p.add(date);
				p.add(evntclass);
				p.add(address);
				p.add(status);

				p.setBackground(new Color(200, 200, 200));
				p.setBorder(null);
				dashpane.add(p);
				dashpane.add(Box.createVerticalStrut(5));
			}
			getContentPane().add(dashpane);
		}

		setVisible(true);
	}

	private void getEventInfo() {
		eventList = FileHandle.getEventList();
		this.user.setEventList(eventList);
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

			dispose();
			new WelcomePage();
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
