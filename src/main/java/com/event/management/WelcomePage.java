package com.event.management;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WelcomePage extends JFrame {
	public final Dimension WELCOME_FRAME_D;

	private boolean isLoggedIn;
	private String[] picsPath;
	private Thread changeBannerThread;
	private User user;

	private CardLayout cardsPics;
	private ImageIcon img;
	private JPanel slideShowPanel;
	private JLabel bannerLbl, titleLbl;
	private JButton loginBtn;
	private JButton registerBtn;

	protected User getUser() {
		return this.user;
	}

	protected WelcomePage getWelcomePage() {
		return this;
	}

	public WelcomePage() {
		user = new User();
		isLoggedIn = FileHandle.isAlreadyLoggedIn();
		picsPath = grabPicsPath();

		WELCOME_FRAME_D = new Dimension(Main.DEVICE_WIDTH / 3, 2 * Main.DEVICE_HEIGHT / 3);

		setTitle("Event management system");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WELCOME_FRAME_D);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		cardsPics = new CardLayout();

		setSideShowPanel();
		setBanner();
		setTitleLbl();
		grabButtons();

		getContentPane().add(titleLbl);
		getContentPane().add(loginBtn);
		if (!this.isLoggedIn)
			getContentPane().add(registerBtn);

		nextSlide();
		setVisible(true);
	}

	private void setTitleLbl() {
		titleLbl = new JLabel("Event Management App");
		int x = getWidth() / 10;
		int y = getHeight() - (getHeight() / 3);
		int width = getHeight();
		int heigth = getHeight() / 20;
		titleLbl.setBounds(x, y, width, heigth);
		titleLbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		titleLbl.setHorizontalTextPosition(0);
	}

	private void setSideShowPanel() {
		slideShowPanel = new JPanel(cardsPics);
		int x = 0;
		int y = 0;
		int width = this.getWidth();
		int heigth = this.getHeight() - (this.getHeight() / 3);
		slideShowPanel.setBounds(x, y, width, heigth);
		getContentPane().add(slideShowPanel);
	}

	private void setBanner() {
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

	private void nextSlide() {
		changeBannerThread = new Thread((Runnable) () -> {
			while (true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					System.out.println("thread interrupted");
					break;
				}
				cardsPics.next(slideShowPanel);
				System.out.println("Changing");
			}
		});
		changeBannerThread.start();
	}

	private void grabButtons() {
		String loginBtnText;
		int width = getWidth() / 5;
		int x = getWidth() / 10;
		int y = getHeight() - (getHeight() / 5);
		int heigth = getHeight() / 20;

		loginBtn = new JButton();
		registerBtn = new JButton("Register");

		if (this.isLoggedIn) {
			width *= 2;
			loginBtnText = "Continue (already logged in)";

			loginBtn.addActionListener((ap) -> {
				String loggedInUsername = Auth.findLoggedInUsername();
				if (loggedInUsername == null) {
					FileHandle.resetFile(FileHandle.LOGGED_IN_USERNAME, "username");
					return;
				}

				String[] userInfo = Auth.findRgisteredUser(loggedInUsername);
				if (userInfo == null) {
					FileHandle.resetFile(FileHandle.LOGGED_IN_USERNAME, "username");
					return;
				}
				if (userInfo.length != 5) {
					JOptionPane.showMessageDialog(null,
							"There is something wrong in user data. We have to reset our all the data. Restart the app",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					FileHandle.resetFile(FileHandle.LOGGED_IN_USERNAME, "username");
					FileHandle.resetFile(FileHandle.REGISTERED_USER, "username firstName lastName password");
					return;
				}

				user.setUsername(userInfo[0]);
				user.setName(userInfo[1], userInfo[2]);
				user.setEmail(userInfo[3]);
				user.setPassword(userInfo[3]);

				this.disposeAndstopSlideShow();

				new HomePage(this.user);
				;
			});
		} else {
			loginBtnText = "Log in";

			loginBtn.addActionListener((ap) -> {
				new LoginPage(this);
			});
			registerBtn.addActionListener((ap) -> {
				new RegisterPage();
				this.disposeAndstopSlideShow();
			});
		}

		loginBtn.setText(loginBtnText);
		loginBtn.setBounds(x, y, width, heigth);
		registerBtn.setBounds(x + width + 5, y, width, heigth);

		// loginBtn.setBackground(TempColor.DARK_CYAN);
		// loginBtn.setForeground(TempColor.WHITE);
		// loginBtn.setBorder(null);
		loginBtn.setFocusable(false);

		// registerBtn.setBackground(TempColor.WHITE);
		// registerBtn.setForeground(TempColor.DARK_CYAN);
		// registerBtn.setBorder(null);
		registerBtn.setFocusable(false);
	}

	public void disposeAndstopSlideShow() {
		this.dispose();
		changeBannerThread.interrupt();
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
