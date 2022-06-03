package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdminController;
import controller.LoginController;
import controller.RegisterController;
import dao.UserDao;
import entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPass;
	private JButton btnDangNhap;
	public static boolean isLogin;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("ĐĂNG NHẬP");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setBounds(338, 30, 190, 77);
		contentPane.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(180, 137, 119, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("M\u1EADt kh\u1EA9u");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(180, 201, 119, 36);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(357, 139, 309, 36);
		contentPane.add(txtUsername);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tenDN = txtUsername.getText();
					String matKhau = txtPass.getText();
					if(UserDao.checkUser(tenDN, matKhau)) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
						User user = UserDao.getUser(tenDN, matKhau);
						AdminController adminController = new AdminController();
						if(user.getChuVu() == 1) {
							LoginController.loginView.setVisible(false);
							adminController.showAdminView();
						}
						else {
							LoginController.loginView.setVisible(false);
							adminController.showUserView();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
					}
				}
		});
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDangNhap.setBounds(357, 300, 182, 36);
		contentPane.add(btnDangNhap);
		
		JLabel lblBnC = new JLabel();
		lblBnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterController registerController = new RegisterController();
				registerController.showRegisterView();
				
				//
				LoginController.loginView.setVisible(false);
				//
			}
		});
		lblBnC.setText("<HTML>Bạn chưa có tài khoản? <FONT color=\"#000099\"><u> Đăng ký </u></FONT></HTML>");
		lblBnC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBnC.setBounds(578, 375, 226, 36);
		contentPane.add(lblBnC);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(357, 203, 309, 36);
		contentPane.add(txtPass);
		
	}
	
}
