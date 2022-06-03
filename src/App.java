import java.awt.EventQueue;

import controller.LoginController;

public class App {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginController loginController = new LoginController();
					loginController.showLoginView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
