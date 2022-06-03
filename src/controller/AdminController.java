package controller;

import view.AdminView;
import view.UserView;

public class AdminController {
	public static AdminView adminView;
	public static UserView userView;
	
	public AdminController() {
		adminView = new AdminView();
		userView = new UserView();
	}
	
	public void showAdminView() {
		adminView.setVisible(true);
	}
	
	public void showUserView() {
		userView.setVisible(true);
	}
}
