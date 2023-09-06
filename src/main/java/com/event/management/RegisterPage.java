package com.event.management;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPage extends JFrame {
    private String username;

    private User user;

    private JPasswordField passwordField;
    private JTextField firstNameFileld, lastNameFileld, emailFeild;
    private JLabel showUsername, fnlbl, lnlbl, pwlbl, emlbl;
    private JButton registerBtn;
    private Dimension REGI_FRAME_D;

    public RegisterPage() {
        user = new User();
        REGI_FRAME_D = new Dimension(2 * Main.DEVICE_WIDTH / 9, 2 * Main.DEVICE_HEIGHT / 3);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sign up");
        setSize(REGI_FRAME_D);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        if (!takeUsername()) {
            this.dispose();
            return;
        }
        title();
        nameFileld();
        passwordField();
        buttons();
        lookFeel();

        getContentPane().add(showUsername);
        getContentPane().add(fnlbl);
        getContentPane().add(firstNameFileld);
        getContentPane().add(lnlbl);
        getContentPane().add(lastNameFileld);
        getContentPane().add(emlbl);
        getContentPane().add(emailFeild);
        getContentPane().add(pwlbl);
        getContentPane().add(passwordField);
        getContentPane().add(registerBtn);

        setVisible(true);
    }

    private void buttons() {
        registerBtn = new JButton("Login");
        int x = 5;
        int y = passwordField.getY() + passwordField.getHeight() + 15;
        int width = passwordField.getWidth();
        int height = passwordField.getHeight();
        registerBtn.setBounds(x, y, width, height);

        registerBtn.addActionListener((el) -> {
            registerAL();
        });
    }

    private void registerAL() {
        String firstName = this.firstNameFileld.getText().trim();
        String lastName = this.lastNameFileld.getText().trim();
        String email = this.emailFeild.getText().trim();
        String password = new String(this.passwordField.getPassword());

        if (username == null || firstName == null ||
                lastName == null || email == null || password == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "First name, last name, email and password required",
                    "input is null",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "First name, last name, email and password required",
                    "input is empty",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Auth.validInfoToRegister(username)) {
            JOptionPane.showMessageDialog(
                    null,
                    "First name, last name, email and password required",
                    "input is empty",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!Auth.validInfoToRegister(firstName)) {
            JOptionPane.showMessageDialog(
                    null,
                    "First name can not have any space inside them",
                    "Not vallid",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!Auth.validInfoToRegister(lastName)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Last name can not have any space inside them",
                    "Not vallid",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!Auth.validInfoToRegister(email)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Email is not valid",
                    "Not vallid",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (Auth.passwordType(password)) {
            case 1:
                JOptionPane.showMessageDialog(
                        null,
                        "choose a strong password (length > 7 , mixing of special chars, number, upper and lower case)",
                        "Not vallid",
                        JOptionPane.WARNING_MESSAGE);
                return;
            case -1:
                JOptionPane.showMessageDialog(
                        null,
                        "password can not have leading and trailing space",
                        "Not vallid",
                        JOptionPane.WARNING_MESSAGE);
                return;
        }

        username = username.trim();
        firstName = firstName.trim();
        lastName = lastName.trim();
        email = email.trim();
        password = password.trim();

        FileHandle.AppendFile(FileHandle.REGISTERED_USER,
                username + " " + firstName + " " + lastName + " " + email + " " + password);

        user.setUsername(username);
        user.setName(firstName, lastName);
        user.setEmail(email);
        user.setPassword(password);

        try {
            Thread.sleep(200);
        } catch (Exception ex) {
            return;
        }

        new HomePage(user);
        this.dispose();
    }

    private void passwordField() {
        pwlbl = new JLabel("Enter password:");
        int x = 5;
        int y = emailFeild.getY() + emailFeild.getHeight() + 10;
        int width = showUsername.getWidth();
        int height = 15;
        pwlbl.setBounds(x, y, width, height);

        passwordField = new JPasswordField("", 1);
        x = 5;
        y = pwlbl.getY() + pwlbl.getHeight() + 5;
        width = showUsername.getWidth();
        height = 30;
        passwordField.setBounds(x, y, width, height);
    }

    private void nameFileld() {
        int x, y, w, h;
        fnlbl = new JLabel("Enter your first name: ");
        firstNameFileld = new JTextField("", 1);
        lnlbl = new JLabel("Enter your last name: ");
        lastNameFileld = new JTextField("", 1);
        emlbl = new JLabel("Enter your email: ");
        emailFeild = new JTextField("", 1);

        x = 5;
        y = showUsername.getY() + showUsername.getHeight() + 30;
        w = showUsername.getWidth();
        h = 15;
        fnlbl.setBounds(x, y, w, h);

        x = 5;
        y = fnlbl.getY() + fnlbl.getHeight() + 5;
        w = fnlbl.getWidth();
        h = 30;
        firstNameFileld.setBounds(x, y, w, h);

        x = 5;
        y = firstNameFileld.getY() + firstNameFileld.getHeight() + 10;
        w = showUsername.getWidth();
        h = 15;
        lnlbl.setBounds(x, y, w, h);

        x = 5;
        y = lnlbl.getY() + lnlbl.getHeight() + 5;
        w = showUsername.getWidth();
        h = 30;
        lastNameFileld.setBounds(x, y, w, h);

        x = 5;
        y = lastNameFileld.getY() + lastNameFileld.getHeight() + 10;
        w = showUsername.getWidth();
        h = 15;
        emlbl.setBounds(x, y, w, h);

        x = 5;
        y = emlbl.getY() + emlbl.getHeight() + 5;
        w = showUsername.getWidth();
        h = 30;
        emailFeild.setBounds(x, y, w, h);

    }

    private void title() {
        showUsername = new JLabel("Sign up");
        int x = 5;
        int y = getHeight() / 20;
        int width = getWidth() - 21;
        int height = 35;
        showUsername.setBounds(x, y, width, height);
        showUsername.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        showUsername.setHorizontalAlignment(JLabel.CENTER);
    }

    private void lookFeel() {
        // registerBtn.setBackground(TempColor.DARK_CYAN);
        // registerBtn.setForeground(TempColor.WHITE);
        // registerBtn.setBorder(null);
        registerBtn.setFocusable(false);
    }

    private boolean takeUsername() {

        do {
            String un = JOptionPane.showInputDialog("Enter an unique username", null);

            if (un == null)
                return false;
            if (un.isEmpty()) {
                continue;
            }
            un = un.trim();
            if (Auth.checkUserAvailibility(un)) {
                this.username = un;
                break;
            }

        } while (true);
        return true;
    }
}
