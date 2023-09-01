package ui;

import java.awt.Container;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import listener.ButtonListener;

public class RegisterPage extends MainFrame {
	private ButtonListener btnListener;
	private WelcomePage welcomePage;
	private Container c;
	private JPasswordField passwordField;
	private String username;

	public String getUsername() {
		return username;
	}

	private final int FRAME_WIDTH, FRAME_HEIGHT;

	public RegisterPage(WelcomePage welcomePage) {
		btnListener = new ButtonListener();
		this.welcomePage = welcomePage;
		FRAME_WIDTH = 2 * DEVICE_WIDTH / 9;
		FRAME_HEIGHT = 2 * DEVICE_HEIGHT / 4;

		setResizable(false);
		setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		setTitle("Login EMA");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		c = getContentPane();
		c.setLayout(null);

		lebel();
		passwordField();
		emailFeild();
		nameFileld();
		button();
		takeUsername();
	}

	private void takeUsername() {
		boolean run;
		
		do {
			String un = JOptionPane.showInputDialog("Enter yourname", null);

			if (un == null) continue;
			// if()

		} while (rootPaneCheckingEnabled);
	}

	private void nameFileld() {
	}

	private void emailFeild() {
	}

	private void button() {
	}

	private void passwordField() {
	}

	private void lebel() {
	}

}