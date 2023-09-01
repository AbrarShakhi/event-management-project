package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import auth.*;
import inside.*;
import ui.*;
import utility.*;

public class ButtonListener {
	public class LogoutAl implements ActionListener {
		private HomePage homePage;

		public LogoutAl(HomePage homePage) {
			this.homePage = homePage;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");

			try {
				homePage.dispose();
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			} finally {
				System.exit(0);
			}
		}
	}

	public class ExitProgram implements ActionListener {
		LoginUserHandle loginUserHandle;
		private HomePage homePage;
		private User user;

		public ExitProgram(HomePage homePage, User user) {
			this.homePage = homePage;
			this.user = user;
			loginUserHandle = new LoginUserHandle();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int choice = JOptionPane.showOptionDialog(null, "Do you want to save login info?", "exit",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
			switch (choice) {
				case 0:
					FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username " + user.getUsername());
					break;
				case 1:
					FileDir.resetFile(FilePaths.LOGGED_IN_USERNAME, "username");
					break;
				default:
					return;
			}
			try {
				homePage.dispose();
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			} finally {
				System.exit(0);
			}
		}

	}

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

			wlc.disposeAndstopSlideShow();
			;

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
			this.loginUserHandle = new LoginUserHandle();
			this.user = new User();
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

				wlc.disposeAndstopSlideShow();
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
			// RegisterPage rgp =
			new RegisterPage();

			wlc.disposeAndstopSlideShow();
		}
	}

	public class RegisterFromRegisterPage implements ActionListener {
		private RegisterPage registerPage;
		private User user;

		public RegisterFromRegisterPage(RegisterPage registerPage) {
			this.registerPage = registerPage;
			this.user = new User();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String username = registerPage.getUsername();
			String firstName = registerPage.getFirstNameFileld().getText();
			String lastName = registerPage.getLastNameFileld().getText();
			String email = registerPage.getEmailFeild().getText();
			String password = new String(registerPage.getPasswordField().getPassword());

			if (username == null || firstName == null ||
					lastName == null || email == null || password == null)
				return;

			if (username.isEmpty() || firstName.isEmpty() ||
					lastName.isEmpty() || email.isEmpty() || password.isEmpty())
				return;

			username = username.trim();
			firstName = firstName.trim();
			lastName = lastName.trim();
			email = email.trim();
			password = password.trim();

			FileDir.AppendFile(FilePaths.REGISTERED_USER,
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
			registerPage.dispose();
		}
	}
}
