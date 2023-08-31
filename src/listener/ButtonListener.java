package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import auth.*;
import inside.*;
import ui.*;
import utility.*;

public class ButtonListener {

	public class DirectLogin implements ActionListener {
		private WelcomePage wlc;
		private User user;
		LoginUserHandle loginUserHandle;

		public DirectLogin(WelcomePage wlc) {
			this.wlc = wlc;
			loginUserHandle = new LoginUserHandle();
			user = new User();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String loggedInUsername = loginUserHandle.findLoggedInUsername();
			if (loggedInUsername == null) {
				FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");
				return;
			}

			String[] userInfo = loginUserHandle.findRgisteredUser(loggedInUsername);
			if (userInfo == null) {
				FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");
				return;
			}
			if (userInfo.length != 5) {
				JOptionPane.showMessageDialog(null,
						"There is something wrong in user data. We have to reset our all the data. Restart the app",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");
				FileDir.resetFile(FilePaths.REGISTERED_USER, "username firstName lastName password");
				return;
			}

			user.setUsername(userInfo[0]);
			user.setName(userInfo[1], userInfo[2]);
			user.setEmail(userInfo[3]);
			user.setPassword(userInfo[3]);

			wlc.dispose();

			new HomePage(user);
		}
	}

	public class LoginBtnFromLoginPage implements ActionListener {
		private LoginPage loginPage;
		private WelcomePage wlc;
		private User user;
		LoginUserHandle loginUserHandle;

		public LoginBtnFromLoginPage(LoginPage loginPage, WelcomePage wlc) {
			this.loginPage = loginPage;
			this.wlc = wlc;
			loginUserHandle = new LoginUserHandle();
			user = new User();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String inputUsername = loginPage.getUsernameField().getText().trim();
			String inputPassword = new String(loginPage.getPasswordField().getPassword());
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

				String[] userInfo = loginUserHandle.findRgisteredUser(inputUsername);
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
					FileDir.resetFile(FilePaths.REGISTERED_USER, "username firstName lastName password");
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

				wlc.dispose();
				new HomePage(user);

			} finally {
				loginPage.dispose();
			}
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
