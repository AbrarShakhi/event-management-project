package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import auth.LoginPage;
import people.User;
import program.HomePage;
import program.WelcomePage;

public class ButtonListener {

	public class LoginBtnAl implements ActionListener {
		private LoginPage loginPage;
		private WelcomePage wlc;
		private User user;

		public LoginBtnAl(LoginPage loginPage, WelcomePage wlc) {
			this.loginPage = loginPage;
			this.wlc = wlc;
			user = new User();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String inputUsername = loginPage.getUsernameField().getText();

				if (inputUsername.isBlank()) {
					JOptionPane.showMessageDialog(
							null,
							"Please input something",
							"Invalid Username ir password",
							JOptionPane.ERROR_MESSAGE);

					return;
				}

				user.setUsername(inputUsername);
				wlc.dispose();
				new HomePage(user);

			} finally {
				loginPage.dispose();
			}
		}
	}

	public class DirectLogin implements ActionListener {
		private WelcomePage wlc;
		private User user;

		public DirectLogin(WelcomePage wlc) {
			this.wlc = wlc;
			user = new User();
			user.setUsername("username");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			wlc.dispose();
			new HomePage(user);
		}

	}

	public class OpenLoginPageAl implements ActionListener {
		private WelcomePage wlc;

		public OpenLoginPageAl(WelcomePage wlc) {
			this.wlc = wlc;
		}

		@Override
		public void actionPerformed(ActionEvent ev) {

			new LoginPage(wlc);
			// wlc.setVisible(false);

		}
	}

	public class OpenRegestrationPageAl implements ActionListener {
		private WelcomePage wlc;

		public OpenRegestrationPageAl(WelcomePage wlc) {
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
			new HomePage(new User()); // it wiil have user information
		}
	}
}
