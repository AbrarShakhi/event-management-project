package program;

import ui.MainFrame;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends MainFrame {
    private int FRAME_WIDTH;
    private int FRAME_HEIGHT;

    private Container c;

    private JButton loginBtn;
    private JButton registerBtn;

    public WelcomePage() {
        FRAME_WIDTH = DEVICE_WIDTH / 2;
        FRAME_HEIGHT = 2 * DEVICE_HEIGHT / 3;

        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setTitle("Event Management App");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        c = getContentPane();
        c.setLayout(null);

        button();
    }

    private void button() {
        loginBtn = new JButton("Log in");
        registerBtn = new JButton("Register");
        int x = FRAME_WIDTH / 10;
        int y = FRAME_HEIGHT - (FRAME_HEIGHT / 5);
        int width = FRAME_WIDTH / 8;
        int heigth = FRAME_HEIGHT / 20;

        loginBtn.setBounds(x, y, width, heigth);
        registerBtn.setBounds(x + width + 5, y, width, heigth);

        c.add(loginBtn);
        c.add(registerBtn);
    }
}
