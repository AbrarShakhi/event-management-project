package account;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

public class StartPage {
    private final int WIDTH;
    private final int HEIGHT;

    private JFrame frame;
    private Container c;

    public JFrame getFrame() {
        return frame;
    }

    public Container getC() {
        return c;
    }

    private JLabel titleLBL;
    private Font titleFNT, buttonFNT;
    private JButton loginBTN, registerBTN;
    private Cursor handCursor;

    public StartPage(int width, int height) {
        WIDTH = width;
        HEIGHT = height;

        frame = new JFrame("Event management project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        c = frame.getContentPane();
        handCursor = new Cursor(Cursor.HAND_CURSOR);
    }

    public void initComponent() {
        c.setLayout(null);
        initFont();
        initLebel();
        initButton();

        c.add(titleLBL);
        c.add(loginBTN);
        c.add(registerBTN);
    }

    private void initLebel() {
        titleLBL = new JLabel("Event Management Application");
        int x = WIDTH / 10;
        int y = HEIGHT / 4;
        int width = WIDTH;
        int height = HEIGHT / 3;
        titleLBL.setBounds(x, y, width, height);
        titleLBL.setFont(titleFNT);
    }

    private void initFont() {
        titleFNT = new Font("Kristen ITC", Font.BOLD, 50);
        buttonFNT = new Font("Segoe UI", 0, 12);
    }

    private void initButton() {
        loginBTN = new JButton("Login");

        int x = WIDTH / 10;
        int y = HEIGHT - 100;
        int width = WIDTH / 10;
        int height = HEIGHT / 20;
        loginBTN.setBounds(x, y, width, height);
        loginBTN.setBackground(Color.WHITE);
        loginBTN.setForeground(Color.blue);

        x = (WIDTH / 5) + 5;
        y = HEIGHT - 100;
        width = WIDTH / 10;
        height = HEIGHT / 20;
        registerBTN = new JButton("Regester");
        registerBTN.setBounds(x, y, width, height);
        registerBTN.setBackground(Color.blue);
        registerBTN.setForeground(Color.WHITE);

        registerBTN.setFont(buttonFNT);
        loginBTN.setFont(buttonFNT);
        registerBTN.setCursor(handCursor);
        loginBTN.setCursor(handCursor);
    }

    public void setBtnEvent() {
        loginBTN.addActionListener(loginPressed);
        registerBTN.addActionListener(registrationPressed);
    }

    private ActionListener loginPressed = e -> {
        // frame.setVisible(false);
        Login login  = new Login();
    };
    private ActionListener registrationPressed = e -> {
        Register register = new Register();
    };
}