package com.event.management;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton loginButton;
    private JLabel titleLbl, unlbl, pwlbl;

    private User user;

    public final Dimension LOGIN_FRAME_D;

    private WelcomePage wlc;

    public LoginPage(WelcomePage wlc) {
        this.user = new User();
        this.wlc = wlc;
        LOGIN_FRAME_D = new Dimension(2 * Main.DEVICE_WIDTH / 9, 2 * Main.DEVICE_HEIGHT / 4);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login EMA");
        setSize(LOGIN_FRAME_D);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        confiqLebels();
        usernameField();
        passwordField();
        confiqButtons();
        confiqLookFeel();

        getContentPane().add(titleLbl);
        getContentPane().add(unlbl);
        getContentPane().add(usernameField);
        getContentPane().add(pwlbl);
        getContentPane().add(passwordField);
        getContentPane().add(loginButton);

        setVisible(true);
    }

    private void confiqButtons() {
        loginButton = new JButton("Login");
        int x = 5;
        int y = passwordField.getY() + passwordField.getHeight() + 15;
        int width = passwordField.getWidth();
        int height = passwordField.getHeight();
        loginButton.setBounds(x, y, width, height);

        loginButton.addActionListener((el) -> {
            loginAL();
        });
    }

    private void passwordField() {
        pwlbl = new JLabel("Enter password:");
        int x = 5;
        int y = usernameField.getY() + usernameField.getHeight() + 10;
        int width = titleLbl.getWidth();
        int height = 15;
        pwlbl.setBounds(x, y, width, height);

        passwordField = new JPasswordField("", 1);
        x = 5;
        y = pwlbl.getY() + pwlbl.getHeight() + 5;
        width = usernameField.getWidth();
        height = 30;
        passwordField.setBounds(x, y, width, height);
    }

    private void usernameField() {
        unlbl = new JLabel("Enter username:");
        int x = 5;
        int y = titleLbl.getY() + titleLbl.getHeight() + 30;
        int width = titleLbl.getWidth();
        int height = 15;
        unlbl.setBounds(x, y, width, height);

        usernameField = new JTextField(1);
        x = 5;
        y = unlbl.getY() + unlbl.getHeight() + 5;
        width = titleLbl.getWidth();
        height = 30;
        usernameField.setBounds(x, y, width, height);
    }

    private void confiqLookFeel() {
        // loginButton.setBackground(TempColor.DARK_CYAN);
        // loginButton.setForeground(TempColor.WHITE);
        // loginButton.setBorder(null);
        loginButton.setFocusable(false);
    }

    private void confiqLebels() {
        titleLbl = new JLabel("Log in");
        int x = 5;
        int y = getHeight() / 20;
        int width = getWidth() - 21;
        int height = 35;
        titleLbl.setBounds(x, y, width, height);
        titleLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        titleLbl.setHorizontalAlignment(JLabel.CENTER);
    }

    private void loginAL() {
        String inputUsername = this.usernameField.getText().trim();
        String inputPassword = new String(this.passwordField.getPassword());
        inputPassword = inputPassword.trim();

        try {
            if (inputUsername.isBlank() || inputPassword.isBlank()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please input something",
                        "Invalid Username or password",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] userInfo = Auth.findRgisteredUser(inputUsername);
            if (userInfo == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid username",
                        "Invalid Username or password",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (userInfo.length != 5) {
                JOptionPane.showMessageDialog(null,
                        "There is something wrong in user data. We have to reset our all the data. Restart the app",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                FileHandle.resetFile(FileHandle.REGISTERED_USER, "username firstName lastName password");
                return;
            }
            if (!inputPassword.equals(userInfo[4])) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid password",
                        "Invalid Username or password",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            user.setUsername(userInfo[0]);
            user.setName(userInfo[1], userInfo[2]);
            user.setEmail(userInfo[3]);
            user.setPassword(userInfo[3]);

            wlc.disposeAndstopSlideShow();
            new HomePage(user);

        } finally {
            this.dispose();
        }
    }

}
