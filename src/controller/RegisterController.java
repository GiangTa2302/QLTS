package controller;

import view.RegisterView;

public class RegisterController {
	public static RegisterView registerView;
	
	public RegisterController() {
		registerView = new RegisterView();
	}
	
	public void showRegisterView() {
		
		registerView.setVisible(true);
	}
}
