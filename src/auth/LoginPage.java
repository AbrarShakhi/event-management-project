package auth;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listener.ButtonListener;
import program.WelcomePage;
import ui.MainFrame;

public class LoginPage extends MainFrame {
	private WelcomePage welcomePage;
	private Container c;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JButton loginButton;
	private JLabel titleLbl;
	private ButtonListener btnListener;

	private final int FRAME_WIDTH, FRAME_HEIGHT;

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public LoginPage(WelcomePage wlc) {
		btnListener = new ButtonListener();
		welcomePage = wlc;
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
		usernameField();
		passwordField();
		button();

		c.add(titleLbl);
		c.add(usernameField);
		c.add(passwordField);
		c.add(loginButton);

		// for test...
		var zzz = new JLabel("Login don't work. input anything");
		zzz.setBounds(1, FRAME_HEIGHT - 100, FRAME_WIDTH, 100);
		c.add(zzz);
		// end

		setVisible(true);
	}

	private void lebel() {
		titleLbl = new JLabel("Input username and password");
		int x = 5;
		int y = FRAME_HEIGHT / 7;
		int width = FRAME_WIDTH - 21;
		int height = 30;
		titleLbl.setBounds(x, y, width, height);
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
	}

	private void usernameField() {
		usernameField = new JTextField(1);
		int x = 5;
		int y = titleLbl.getY() + titleLbl.getHeight() + 10;
		int width = titleLbl.getWidth();
		int height = titleLbl.getHeight();
		usernameField.setBounds(x, y, width, height);
	}

	private void passwordField() {
		passwordField = new JPasswordField("", 1);
		int x = 5;
		int y = usernameField.getY() + usernameField.getHeight() + 10;
		int width = usernameField.getWidth();
		int height = usernameField.getHeight();
		passwordField.setBounds(x, y, width, height);
	}

	private void button() {
		loginButton = new JButton("Login");
		int x = 5;
		int y = passwordField.getY() + passwordField.getHeight() + 10;
		int width = passwordField.getWidth();
		int height = passwordField.getHeight();
		loginButton.setBounds(x, y, width, height);
		ButtonListener.LoginBtnAl loginBtn = btnListener.new LoginBtnAl(this, welcomePage);
		loginButton.addActionListener(loginBtn);
	}

}
