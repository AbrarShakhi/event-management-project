package ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import auth.RegisterUserHandle;
import listener.ButtonListener;
import utility.TempColor;

public class RegisterPage extends MainFrame {
	private ButtonListener btnListener;
	private Container c;
	private JPasswordField passwordField;
	private String username;
	private JTextField firstNameFileld, lastNameFileld, emailFeild;
	private JLabel showUsername;
	private JButton registerBtn;

	public RegisterUserHandle registerUserHandle;

	public String getUsername() {
		return username;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getFirstNameFileld() {
		return firstNameFileld;
	}

	public JTextField getLastNameFileld() {
		return lastNameFileld;
	}

	public JTextField getEmailFeild() {
		return emailFeild;
	}

	private final int FRAME_WIDTH, FRAME_HEIGHT;

	public RegisterPage() {
		btnListener = new ButtonListener();
		registerUserHandle = new RegisterUserHandle();
		FRAME_WIDTH = 2 * DEVICE_WIDTH / 9;
		FRAME_HEIGHT = 2 * DEVICE_HEIGHT / 4;

		setResizable(false);
		setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		setTitle("Register EMA");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		c = getContentPane();
		c.setLayout(null);
		initComponents();
	}

	public void initComponents() {
		if (!takeUsername()) {
			this.dispose();
			return;
		}

		lebel();
		nameFileld();
		passwordField();
		button();
		lookFeel();

		c.add(showUsername);
		c.add(firstNameFileld);
		c.add(lastNameFileld);
		c.add(emailFeild);
		c.add(passwordField);
		c.add(registerBtn);

		setVisible(true);
	}

	private void lookFeel() {
		registerBtn.setBackground(TempColor.DARK_CYAN);
		registerBtn.setForeground(TempColor.WHITE);
		registerBtn.setBorder(null);
		registerBtn.setFocusable(false);
	}

	private boolean takeUsername() {

		do {
			String un = JOptionPane.showInputDialog("Enter yourname", null);

			if (un == null)
				return false;
			un = un.trim();
			if (un.isEmpty()) {
				continue;
			}
			if (registerUserHandle.checkUserAvailibility(un)) {
				this.username = un;
				break;
			}

		} while (true);
		return true;
	}

	private void lebel() {
		int x, y, w, h;
		showUsername = new JLabel(this.username);
		x = 5;
		y = FRAME_HEIGHT / 100;
		w = FRAME_WIDTH - 21;
		h = 30;
		showUsername.setBounds(x, y, w, h);
		showUsername.setHorizontalAlignment(0);
	}

	private void nameFileld() {
		int x, y, w, h;
		firstNameFileld = new JTextField("firstName", 1);
		lastNameFileld = new JTextField("lastName", 1);

		x = 5;
		y = showUsername.getY() + showUsername.getHeight() + 10;
		w = showUsername.getWidth();
		h = showUsername.getHeight();
		firstNameFileld.setBounds(x, y, w, h);

		x = 5;
		y = firstNameFileld.getY() + firstNameFileld.getHeight() + 10;
		w = firstNameFileld.getWidth();
		h = firstNameFileld.getHeight();
		lastNameFileld.setBounds(x, y, w, h);
		emailFeild = new JTextField("Email", 1);

		x = 5;
		y = lastNameFileld.getY() + lastNameFileld.getHeight() + 10;
		w = lastNameFileld.getWidth();
		h = lastNameFileld.getHeight();
		emailFeild.setBounds(x, y, w, h);
	}

	private void passwordField() {
		passwordField = new JPasswordField(1);

		int x, y, w, h;
		x = 5;
		y = emailFeild.getY() + emailFeild.getHeight() + 10;
		w = emailFeild.getWidth();
		h = emailFeild.getHeight();

		passwordField.setBounds(x, y, w, h);
	}

	private void button() {
		registerBtn = new JButton("Register");
		int x, y, w, h;

		x = 5;
		y = passwordField.getY() + passwordField.getHeight() + 10;
		w = passwordField.getWidth();
		h = passwordField.getHeight();

		registerBtn.setBounds(x, y, w, h);
		ButtonListener.RegisterFromRegisterPage registerFromRegisterPage = btnListener.new RegisterFromRegisterPage(
				this);

		registerBtn.addActionListener(registerFromRegisterPage);
	}

}