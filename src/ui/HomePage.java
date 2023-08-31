package ui;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;

import inside.User;

import javax.swing.JButton;

public class HomePage extends MainFrame {
	private User user;

	private final int FRAME_WIDTH, FRAME_HEIGHT;

	private Container c;
	private JPanel mainBoxPnl;
	private JPanel sideBarPnl;

	private JLabel usernameLbl, nameLbl;
	private JButton checkoutBtn, exitBtn, logoutBtn;

	public HomePage getWelcomePage() {
		return this;
	}

	public HomePage(User user) {
		this.user = user;
		FRAME_WIDTH = DEVICE_WIDTH - 50;
		FRAME_HEIGHT = DEVICE_HEIGHT - 50;

		setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		setTitle("Event Management App");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		c = getContentPane();
		c.setLayout(null);

		panel();
		c.add(mainBoxPnl);
		c.add(sideBarPnl);

		lebel();
		button();

		sideBarPnl.add(logoutBtn);
		sideBarPnl.add(usernameLbl);
		sideBarPnl.add(nameLbl);

		mainBoxPnl.add(checkoutBtn);
		mainBoxPnl.add(exitBtn);

		setVisible(true);
	}

	private void panel() {
		mainBoxPnl = new JPanel();
		sideBarPnl = new JPanel();
		mainBoxPnl.setLayout(null);
		sideBarPnl.setLayout(null);

		int x, y, w, h;

		x = 0;
		y = 0;
		w = FRAME_WIDTH / 6;
		h = FRAME_HEIGHT;
		sideBarPnl.setBackground(Color.LIGHT_GRAY);
		sideBarPnl.setBounds(x, y, w, h);

		x = FRAME_WIDTH / 6;
		y = 0;
		w = FRAME_WIDTH - (FRAME_WIDTH / 6) - 10;
		h = FRAME_HEIGHT;
		mainBoxPnl.setBounds(x, y, w, h);
	}

	private void lebel() {
		int x, y, w, h;

		usernameLbl = new JLabel(user.getUsername());
		x = (sideBarPnl.getWidth() + (sideBarPnl.getWidth() / 10)) - sideBarPnl.getWidth();
		y = sideBarPnl.getHeight() / 20;
		w = sideBarPnl.getWidth() - x;
		h = 25;
		usernameLbl.setBounds(x, y, w, h);

		nameLbl = new JLabel(user.getName());
		x = (sideBarPnl.getWidth() + (sideBarPnl.getWidth() / 10)) - sideBarPnl.getWidth();
		y = sideBarPnl.getHeight() / 20 + y;
		w = sideBarPnl.getWidth() - x;
		h = 25;
		nameLbl.setBounds(x, y, w, h);
	}

	private void button() {
		checkoutBtn = new JButton("checkout");
		exitBtn = new JButton("exit");
		int x = mainBoxPnl.getWidth() - (mainBoxPnl.getWidth() / 8);
		int y = mainBoxPnl.getHeight() - (mainBoxPnl.getHeight() / 5);
		int w = 100;
		int h = 25;
		checkoutBtn.setBounds(x, y, w, h);
		exitBtn.setBounds(x - w - 5, y, w, h);

		logoutBtn = new JButton("Log out");
		x = (sideBarPnl.getWidth() + (sideBarPnl.getWidth() / 50)) - sideBarPnl.getWidth();
		y = sideBarPnl.getHeight() - (sideBarPnl.getHeight() / 5);
		w = sideBarPnl.getWidth() - x;
		h = 25;
		logoutBtn.setBounds(x, y, w, h);
	}
}
