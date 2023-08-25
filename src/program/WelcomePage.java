package program;

import ui.MainFrame;
import listener.ButtonListener;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends MainFrame {
    private ButtonListener btnListener;

    private int FRAME_WIDTH, FRAME_HEIGHT;

    private Container c;

    private JButton loginBtn, registerBtn;

    public WelcomePage getWelcomePage() {
        return this;
    }

    public WelcomePage() {
        FRAME_WIDTH = DEVICE_WIDTH / 2;
        FRAME_HEIGHT = 2 * DEVICE_HEIGHT / 3;

        btnListener = new ButtonListener();

        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setTitle("Event Management App");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        c = getContentPane();
        c.setLayout(null);

        button();

        setVisible(true);
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

        ButtonListener.LoginBtnAl loginBtnAl = btnListener.new LoginBtnAl(this);
        ButtonListener.RegisterBtnAl registerBtnAl = btnListener.new RegisterBtnAl(this);
        loginBtn.addActionListener(loginBtnAl);
        registerBtn.addActionListener(registerBtnAl);

        c.add(loginBtn);
        c.add(registerBtn);
    }
}
