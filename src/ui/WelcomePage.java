package ui;

import listener.ButtonListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

public class WelcomePage extends MainFrame {
	private ButtonListener btnListener;

	private final int FRAME_WIDTH, FRAME_HEIGHT;

	private Container c;
	private JButton loginBtn, registerBtn;
	private JLabel titleLbl, bannerLbl;
	private ImageIcon img;
	private JPanel slideShowPanel;
	private CardLayout cardsPics;
	private Font titleFont;

	private boolean isLoggedIn;

	private String[] picsPath;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public WelcomePage(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;

		FRAME_WIDTH = DEVICE_WIDTH / 3;
		FRAME_HEIGHT = 2 * DEVICE_HEIGHT / 3;

		btnListener = new ButtonListener();
		picsPath = grabPicsPath();
		titleFont = new Font(Font.MONOSPACED, Font.BOLD, 20);

		setResizable(false);
		setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		setTitle("Event Management App");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);

		initComponents();
	}

	public void initComponents() {
		c = getContentPane();
		c.setLayout(null);

		cardsPics = new CardLayout();
		panel();
		c.add(slideShowPanel);

		image();
		lebel();
		button();

		c.add(titleLbl);
		c.add(loginBtn);
		if (!this.isLoggedIn)
			c.add(registerBtn);

		setVisible(true);
		nextSlide();
	}

	private void nextSlide() {
		Runnable r = () -> {

			int i = 1;
			while (picsPath.length * 2 >= i) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					break;
				}
				cardsPics.next(slideShowPanel);
				System.out.println("Changing");
			}
			i++;
		};

		new Thread(r).start();
	}

	private void panel() {
		slideShowPanel = new JPanel(cardsPics);
		int x = 0;
		int y = 0;
		int width = FRAME_WIDTH;
		int heigth = FRAME_HEIGHT - (FRAME_HEIGHT / 3);
		slideShowPanel.setBounds(x, y, width, heigth);
	}

	private void image() {
		for (int i = 0; i < picsPath.length; i++) {
			Image p = new ImageIcon(picsPath[i]).getImage();

			img = new ImageIcon(p.getScaledInstance(
					slideShowPanel.getWidth(),
					slideShowPanel.getHeight(),
					Image.SCALE_SMOOTH));

			bannerLbl = new JLabel(img);
			slideShowPanel.add(bannerLbl);
		}
	}

	private void lebel() {
		titleLbl = new JLabel("Event Management App");
		int x = FRAME_WIDTH / 10;
		int y = FRAME_HEIGHT - (FRAME_HEIGHT / 3);
		int width = FRAME_WIDTH;
		int heigth = FRAME_HEIGHT / 20;
		titleLbl.setBounds(x, y, width, heigth);
		titleLbl.setFont(titleFont);
		titleLbl.setHorizontalTextPosition(0);
	}

	private void button() {
		String loginBtnText;
		int width = FRAME_WIDTH / 5;
		int x = FRAME_WIDTH / 10;
		int y = FRAME_HEIGHT - (FRAME_HEIGHT / 5);
		int heigth = FRAME_HEIGHT / 20;

		loginBtn = new JButton();
		registerBtn = new JButton("Register");

		if (this.isLoggedIn) {
			width *= 2;
			loginBtnText = "Continue (already logged in)";

			ButtonListener.DirectLogin directLogin = btnListener.new DirectLogin(this);
			loginBtn.addActionListener(directLogin);
		} else {
			loginBtnText = "Log in";

			ButtonListener.OpenLoginPageAl openLoginPageAl = btnListener.new OpenLoginPageAl(this);
			ButtonListener.OpenRegestrationPageAl openRegestrationPageAl = btnListener.new OpenRegestrationPageAl(this);
			loginBtn.addActionListener(openLoginPageAl);
			registerBtn.addActionListener(openRegestrationPageAl);
		}

		loginBtn.setText(loginBtnText);
		loginBtn.setBounds(x, y, width, heigth);
		registerBtn.setBounds(x + width + 5, y, width, heigth);
	}

	private String[] grabPicsPath() {
		String[] picsPath = new String[14];

		for (int i = 0; i < picsPath.length; i++) {
			int num = i + 1;
			picsPath[i] = "media/" + num + ".png";
		}

		return picsPath;
	}
}
