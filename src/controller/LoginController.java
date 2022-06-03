package controller;

import view.LoginView;

public class LoginController {
	public static LoginView loginView;
	public LoginController() {
		loginView = new LoginView();
	}
	
	public void showLoginView() {
		loginView.setVisible(true);
	}
}
