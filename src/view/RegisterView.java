package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.RegisterController;
import dao.UserDao;
import entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JRadioButton rdoNam, rdoNu, rdoKhac;
	private JPasswordField txtPass;
	private JPasswordField txtRePass;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterView frame = new RegisterView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setTitle("Đăng ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("\u0110\u0102NG K\u00DD T\u00C0I KHO\u1EA2N");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setBounds(296, 33, 289, 77);
		contentPane.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(38, 97, 119, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("M\u1EADt kh\u1EA9u");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(38, 161, 119, 36);
		contentPane.add(lblPassword);
		
		JLabel lblXcNhnMt = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u");
		lblXcNhnMt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblXcNhnMt.setBounds(38, 233, 138, 36);
		contentPane.add(lblXcNhnMt);
		
		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHVTn.setBounds(453, 97, 138, 36);
		contentPane.add(lblHVTn);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblaCh.setBounds(453, 161, 138, 36);
		contentPane.add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGiiTnh.setBounds(453, 233, 138, 36);
		contentPane.add(lblGiiTnh);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdoNam.setBounds(559, 233, 85, 36);
		contentPane.add(rdoNam);
		
		rdoNu = new JRadioButton("N\u1EEF");
		rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdoNu.setBounds(667, 233, 85, 36);
		contentPane.add(rdoNu);
		
		rdoKhac = new JRadioButton("Kh\u00E1c");
		rdoKhac.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdoKhac.setBounds(784, 233, 85, 36);
		contentPane.add(rdoKhac);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(165, 97, 216, 36);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(536, 97, 216, 36);
		contentPane.add(txtHoTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(536, 161, 216, 36);
		contentPane.add(txtDiaChi);
		
		JButton btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPass.getText().equals(txtRePass.getText())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu và khẳng định mật khẩu không giống nhau!");
				}
				else {
					User user = new User();
					user.setTenDN(txtUserName.getText());
					user.setMatKhau(txtPass.getText());
					user.setHoTen(txtHoTen.getText());
					user.setDiaChi(txtDiaChi.getText());
					if(rdoNam.isSelected())
						user.setGioiTinh("Nam");
					else if(rdoNu.isSelected())
						user.setGioiTinh("Nữ");
					else user.setGioiTinh("Khác");
					
					UserDao.register(user);
					JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
															
					LoginController loginController = new LoginController();
					loginController.showLoginView();
					
					RegisterController.registerView.setVisible(false);
				}
			}
		});
		btnDangKy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDangKy.setBounds(359, 318, 182, 36);
		contentPane.add(btnDangKy);
		
		JLabel lblBnC = new JLabel();
		lblBnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginController loginController = new LoginController();
				loginController.showLoginView();
				RegisterController.registerView.setVisible(false);
			}
		});
		lblBnC.setText("<HTML>Bạn đã có tài khoản? <FONT color=\"#000099\"><u> Đăng nhập </u></FONT></HTML>");
		lblBnC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBnC.setBounds(578, 375, 226, 36);
		contentPane.add(lblBnC);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(165, 163, 216, 36);
		contentPane.add(txtPass);
		
		txtRePass = new JPasswordField();
		txtRePass.setBounds(165, 235, 216, 36);
		contentPane.add(txtRePass);
		
	}
}
