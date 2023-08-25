package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import program.HomePage;
import program.WelcomePage;

public class ButtonListener {

    public class LoginBtnAl implements ActionListener {
        private WelcomePage wlc;

        public LoginBtnAl(WelcomePage wel) {
            this.wlc = wel;
        }

        @Override
        public void actionPerformed(ActionEvent ev) {
            // need some work
            JOptionPane.showMessageDialog(
                    null,
                    "I am working on it.\nPlease click ok to login as a TESTUSER",
                    "login",
                    JOptionPane.INFORMATION_MESSAGE);

            // It will dispose and open Homepage if user is valid
            wlc.dispose();
            new HomePage("username'TEST' (from login)"); // it wiil have user information
        }
    }

    public class RegisterBtnAl implements ActionListener {
        private WelcomePage wlc;

        public RegisterBtnAl(WelcomePage wlc) {
            this.wlc = wlc;
        }

        @Override
        public void actionPerformed(ActionEvent ev) {
            // need some work
            JOptionPane.showMessageDialog(
                    null,
                    "I am working on it.\nPlease click ok to register as a TESTUSER",
                    "register",
                    JOptionPane.INFORMATION_MESSAGE);

            // It will dispose and open Homepage if user is valid
            wlc.dispose();
            new HomePage("username'TEST' (from register)"); // it wiil have user information
        }
    }
}
