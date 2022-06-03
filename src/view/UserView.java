package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ThiSinhDao;
import entity.ThiSinh;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, Search, detailTS, QLTS;
	private JTextField txtSBD3;
	private JTable table, table_1;
	private JLabel lblNewLabel, lblHoTen2, lblTmKimTheo, lblNewLabel_1;
	private JButton btnTimKiem, btnSXDiem, btnSXKhoi, btnThongTin;
	private JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, mon1, mon2, mon3;
	private JTextField txtHoTen, txtDiaChi, txtUuTien, txtKhoi, txtMon1, txtMon2, txtMon3, txtSBD2;


	/**
	 * Create the frame.
	 */
	public UserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(8, 10, 942, 616);
		contentPane.add(tabbedPane);
		
		QLTS = new JPanel();
		tabbedPane.addTab("Quản lý thí sinh", null, QLTS, null);
		QLTS.setLayout(null);
		
		lblNewLabel = new JLabel("DANH SÁCH THÍ SINH");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(343, 10, 222, 53);
		QLTS.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 55, 855, 410);
		QLTS.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"SBD", "H\u1ECD t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "\u01AFu ti\u00EAn", "T\u00EAn kh\u1ED1i", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3", "T\u1ED5ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(141);
		table.getColumnModel().getColumn(2).setPreferredWidth(159);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		table.getColumnModel().getColumn(4).setPreferredWidth(61);
		table.getColumnModel().getColumn(7).setPreferredWidth(71);
		scrollPane.setViewportView(table);
		
		btnSXDiem = new JButton("Sắp xếp theo điểm");
		btnSXDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ThiSinh> list = new ArrayList<ThiSinh>();
				list = ThiSinhDao.findAll();
				ThiSinhDao.sortByScore(list);
				showData(list, table);
			}
		});
		btnSXDiem.setBounds(41, 518, 174, 30);
		QLTS.add(btnSXDiem);
		
		btnSXKhoi = new JButton("Sắp xếp theo khối");
		btnSXKhoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ThiSinh> list = new ArrayList<ThiSinh>();
				list = ThiSinhDao.findAll();
				ThiSinhDao.sortByGroup(list);
				showData(list, table);
			}
		});
		btnSXKhoi.setBounds(309, 518, 160, 30);
		QLTS.add(btnSXKhoi);
		
		Search = new JPanel();
		tabbedPane.addTab("Tìm kiếm", null, Search, null);
		Search.setLayout(null);
		
		txtSBD2 = new JTextField();
		txtSBD2.setBounds(186, 119, 267, 28);
		Search.add(txtSBD2);
		txtSBD2.setColumns(10);
		
		lblHoTen2 = new JLabel("Họ và tên:");
		lblHoTen2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblHoTen2.setBounds(107, 122, 71, 28);
		Search.add(lblHoTen2);
		
		lblTmKimTheo = new JLabel("TÌM KIẾM THEO TÊN");
		lblTmKimTheo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTmKimTheo.setBounds(296, 44, 205, 28);
		Search.add(lblTmKimTheo);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ThiSinh> list = new ArrayList<ThiSinh>();
				String hoTen = txtSBD2.getText();
				list = ThiSinhDao.findByName(hoTen);
				showData(list, table_1);
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTimKiem.setBounds(477, 119, 111, 28);
		Search.add(btnTimKiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(65, 205, 801, 322);
		Search.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"SBD", "H\u1ECD t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "\u01AFu ti\u00EAn", "Kh\u1ED1i", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3", "T\u1ED5ng"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		detailTS = new JPanel();
		tabbedPane.addTab("Thông tin chi tiết thí sinh", null, detailTS, null);
		detailTS.setLayout(null);
		
		lblNewLabel_1 = new JLabel("THÔNG TIN CHI TIẾT THÍ SINH");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(283, 26, 289, 44);
		detailTS.add(lblNewLabel_1);
		
		txtSBD3 = new JTextField();
		txtSBD3.setBounds(240, 106, 246, 33);
		detailTS.add(txtSBD3);
		txtSBD3.setColumns(10);
		
		lblNewLabel_2 = new JLabel("SBD:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(148, 102, 95, 39);
		detailTS.add(lblNewLabel_2);
		
		btnThongTin = new JButton("Thông tin");
		btnThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sbd = txtSBD3.getText();
				ThiSinh ts = ThiSinhDao.getBySBD(sbd);
				txtHoTen.setText(ts.getHoTen());
				txtDiaChi.setText(ts.getDiaChi());
				txtUuTien.setText(String.valueOf(ts.getUuTien()));
				if(ts.getKhoi().getMaKhoi() == 1)
				{
					txtKhoi.setText("Khối A");
					mon1.setText("Toán");
					mon2.setText("Lý");
					mon3.setText("Hóa");
					txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
					txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
					txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
				}
				else if(ts.getKhoi().getMaKhoi() == 2)
				{
					txtKhoi.setText("Khối B");
					mon1.setText("Toán");
					mon2.setText("Hóa");
					mon3.setText("Sinh");
					txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
					txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
					txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
				}
				else 
				{
					txtKhoi.setText("Khối C");
					mon1.setText("Văn");
					mon2.setText("Sử");
					mon3.setText("Địa");
					txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
					txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
					txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
				}
			}
		});
		btnThongTin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThongTin.setBounds(543, 106, 127, 33);
		detailTS.add(btnThongTin);
		
		lblNewLabel_3 = new JLabel("Họ tên:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(36, 182, 95, 39);
		detailTS.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(36, 251, 95, 39);
		detailTS.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Ưu tiên:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(36, 319, 95, 39);
		detailTS.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Khối");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(453, 182, 95, 33);
		detailTS.add(lblNewLabel_6);
		
		mon1 = new JLabel("Môn 1:");
		mon1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mon1.setBounds(453, 251, 95, 33);
		detailTS.add(mon1);
		
		mon2 = new JLabel("Môn 2:");
		mon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mon2.setBounds(453, 309, 95, 33);
		detailTS.add(mon2);
		
		mon3 = new JLabel("Môn 3:");
		mon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mon3.setBounds(453, 376, 95, 33);
		detailTS.add(mon3);
		
		txtHoTen = new JTextField();
		txtHoTen.setEnabled(false);
		txtHoTen.setBounds(115, 186, 284, 33);
		detailTS.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEnabled(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(115, 251, 284, 33);
		detailTS.add(txtDiaChi);
		
		txtUuTien = new JTextField();
		txtUuTien.setEnabled(false);
		txtUuTien.setColumns(10);
		txtUuTien.setBounds(115, 319, 127, 33);
		detailTS.add(txtUuTien);
		
		txtKhoi = new JTextField();
		txtKhoi.setEnabled(false);
		txtKhoi.setColumns(10);
		txtKhoi.setBounds(521, 182, 208, 33);
		detailTS.add(txtKhoi);
		
		txtMon1 = new JTextField();
		txtMon1.setEnabled(false);
		txtMon1.setColumns(10);
		txtMon1.setBounds(521, 251, 119, 33);
		detailTS.add(txtMon1);
		
		txtMon2 = new JTextField();
		txtMon2.setEnabled(false);
		txtMon2.setColumns(10);
		txtMon2.setBounds(521, 309, 119, 33);
		detailTS.add(txtMon2);
		
		txtMon3 = new JTextField();
		txtMon3.setEnabled(false);
		txtMon3.setColumns(10);
		txtMon3.setBounds(521, 377, 119, 33);
		detailTS.add(txtMon3);
		showData(ThiSinhDao.findAll(), table);
	}
	
	public void showData(List<ThiSinh> dsts1, JTable tableName) {		
		List<ThiSinh> dsts = new ArrayList<>();
		dsts = dsts1;
		DefaultTableModel tableModel;
		tableName.getModel();
		tableModel = (DefaultTableModel) tableName.getModel();
		tableModel.setRowCount(0);
		dsts.forEach((thiSinh)->{
			tableModel.addRow(new Object[] {
					thiSinh.getSbd(), thiSinh.getHoTen(), thiSinh.getDiaChi(), thiSinh.getUuTien(),
					thiSinh.getKhoi().getTenKhoi(), thiSinh.getDiem().getDiem1(), thiSinh.getDiem().getDiem2(), thiSinh.getDiem().getDiem3(), thiSinh.TongDiem()
			});
		});
	}
}
