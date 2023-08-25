package program;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JButton;

import ui.MainFrame;

public class HomePage extends MainFrame {
    private final String USERNAME;

    private int FRAME_WIDTH, FRAME_HEIGHT;

    private Container c;

    private JLabel usernameLbl;
    private JButton checkoutBtn;

    public HomePage getWelcomePage() {
        return this;
    }

    public HomePage(String username) {
        USERNAME = username;
        FRAME_WIDTH = DEVICE_WIDTH;
        FRAME_HEIGHT = DEVICE_HEIGHT;

        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setTitle("Event Management App");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        c = getContentPane();
        c.setLayout(null);

        lebel();
        button();

        setVisible(true);
    }

    private void lebel() {
        usernameLbl = new JLabel(USERNAME);
        int x = FRAME_WIDTH / 24;
        int y = FRAME_HEIGHT / 24;
        int w = 300;
        int h = 20;
        usernameLbl.setBounds(x, y, w, h);

        c.add(usernameLbl);
    }

    private void button() {
        checkoutBtn = new JButton("checkout");
        int x = FRAME_WIDTH / 24;
        int y = FRAME_HEIGHT - (FRAME_HEIGHT / 5);
        int w = 100;
        int h = 20;
        checkoutBtn.setBounds(x, y, w, h);

        c.add(checkoutBtn);
    }
}
