package com.event.management;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateEventPage extends JFrame {
	private User user;
	public final Dimension CREATEEVENT_FRAME_D;

	private JButton create, cancel;
	private JLabel enlbl;
	private JTextField evntNameInputFeild;
	private JLabel etlbl;
	private JLabel dtlbl;
	private JLabel eclbl;
	private JTextField evntClass;
	private JTextField eventType;
	private JLabel adrslbl;
	private JTextField eventAddress;
	private JLabel titlelbl;
	private JTextField evntDate;

	public CreateEventPage(User user) {
		this.user = user;
		CREATEEVENT_FRAME_D = new Dimension(2 * Main.DEVICE_WIDTH / 9, 2 * Main.DEVICE_HEIGHT / 3);

		setTitle("Create Event");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(CREATEEVENT_FRAME_D);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		title();
		input();
		buttons();

		getContentPane().add(titlelbl);
		getContentPane().add(enlbl);
		getContentPane().add(evntNameInputFeild);
		getContentPane().add(etlbl);
		getContentPane().add(eventType);
		getContentPane().add(dtlbl);
		getContentPane().add(evntDate);
		getContentPane().add(eclbl);
		getContentPane().add(evntClass);
		getContentPane().add(adrslbl);
		getContentPane().add(eventAddress);
		getContentPane().add(create);
		getContentPane().add(cancel);

		setVisible(true);
	}

	private void buttons() {
		create = new JButton("Create");
		cancel = new JButton("Cancel");

		int x = 5;
		int y = eventAddress.getY() + eventAddress.getHeight() + 5;
		int w = eventAddress.getWidth();
		int h = 30;
		create.setBounds(x, y, w, h);
		create.addActionListener(ae -> {
			createPressed();
		});

		x = 5;
		y = create.getY() + create.getHeight() + 5;
		w = create.getWidth();
		h = 30;
		cancel.setBounds(x, y, w, h);
		cancel.addActionListener(ep -> {
			dispose();
			new HomePage(user);
		});
	}

	private void createPressed() {
		StringBuffer en = new StringBuffer(evntNameInputFeild.getText().trim());
		StringBuffer et = new StringBuffer(eventType.getText().trim());
		StringBuffer ed = new StringBuffer(evntDate.getText().trim());
		StringBuffer ec = new StringBuffer(evntClass.getText().trim());
		StringBuffer ea = new StringBuffer(eventAddress.getText().trim());

		if (en == null || et == null || ed == null || ec == null || ea == null)
			return;
		if (en.isEmpty() || et.isEmpty() || ed.isEmpty() || ec.isEmpty() || ea.isEmpty())
			return;

		for (int i = 0; i < en.length(); i++) {
			if (en.charAt(i) == ';') {
				JOptionPane.showMessageDialog(null, "Cannot have ';'", "Invalid char", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		for (int i = 0; i < et.length(); i++) {
			if (en.charAt(i) == ';') {
				JOptionPane.showMessageDialog(null, "Cannot have ';'", "Invalid char", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		for (int i = 0; i < ed.length(); i++) {
			if (en.charAt(i) == ';') {
				JOptionPane.showMessageDialog(null, "Cannot have ';'", "Invalid char", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		for (int i = 0; i < ec.length(); i++) {
			if (en.charAt(i) == ';') {
				JOptionPane.showMessageDialog(null, "Cannot have ';'", "Invalid char", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		for (int i = 0; i < ea.length(); i++) {
			if (en.charAt(i) == ';') {
				JOptionPane.showMessageDialog(null, "Cannot have ';'", "Invalid char", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}

		String out = en + ";" + et + ";" + ed + ";" + ec + ";" + ea + ";" + "pending";
		FileHandle.AppendFile(FileHandle.ADDED_EVENT, out);
		user.getEventList().add(new UserEvent(en.toString(), et.toString(), ed.toString(), ec.toString(), ea.toString(), "pending"));
		this.dispose();
		new HomePage(user);
	}

	private void title() {
		titlelbl = new JLabel("Create Event");
		int x = 5;
		int y = getHeight() / 20;
		int width = getWidth() - 21;
		int height = 20;
		titlelbl.setBounds(x, y, width, height);
		titlelbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		titlelbl.setHorizontalAlignment(JLabel.CENTER);
	}

	private void input() {
		int x, y, w, h;
		enlbl = new JLabel("Enter event name: ");
		evntNameInputFeild = new JTextField("", 1);
		etlbl = new JLabel("Enter event Type: ");
		eventType = new JTextField("", 1);
		dtlbl = new JLabel("Enter date: ");
		evntDate = new JTextField("", 1);
		eclbl = new JLabel("Enter Class: ");
		evntClass = new JTextField("", 1);
		adrslbl = new JLabel("Enter Adress: ");
		eventAddress = new JTextField("", 1);

		x = 5;
		y = titlelbl.getY() + titlelbl.getHeight() + 30;
		w = titlelbl.getWidth();
		h = 15;
		enlbl.setBounds(x, y, w, h);

		x = 5;
		y = enlbl.getY() + enlbl.getHeight() + 5;
		w = enlbl.getWidth();
		h = 30;
		evntNameInputFeild.setBounds(x, y, w, h);

		x = 5;
		y = evntNameInputFeild.getY() + evntNameInputFeild.getHeight() + 10;
		w = evntNameInputFeild.getWidth();
		h = 15;
		etlbl.setBounds(x, y, w, h);

		x = 5;
		y = etlbl.getY() + etlbl.getHeight() + 5;
		w = etlbl.getWidth();
		h = 30;
		eventType.setBounds(x, y, w, h);

		x = 5;
		y = eventType.getY() + eventType.getHeight() + 10;
		w = eventType.getWidth();
		h = 15;
		dtlbl.setBounds(x, y, w, h);

		x = 5;
		y = dtlbl.getY() + dtlbl.getHeight() + 5;
		w = dtlbl.getWidth();
		h = 30;
		evntDate.setBounds(x, y, w, h);

		x = 5;
		y = evntDate.getY() + evntDate.getHeight() + 10;
		w = evntDate.getWidth();
		h = 15;
		eclbl.setBounds(x, y, w, h);

		x = 5;
		y = eclbl.getY() + eclbl.getHeight() + 5;
		w = eclbl.getWidth();
		h = 30;
		evntClass.setBounds(x, y, w, h);

		x = 5;
		y = evntClass.getY() + evntClass.getHeight() + 10;
		w = evntClass.getWidth();
		h = 15;
		adrslbl.setBounds(x, y, w, h);

		x = 5;
		y = adrslbl.getY() + adrslbl.getHeight() + 5;
		w = adrslbl.getWidth();
		h = 30;
		eventAddress.setBounds(x, y, w, h);
	}
}
