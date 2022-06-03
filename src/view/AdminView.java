package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import dao.ThiSinhDao;
import entity.Diem;
import entity.ThiSinh;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, Search, detailTS, QLTS, panel;
	private JTextField SBD, hoTen, diaChi, uuTien, diemMon1, diemMon2, diemMon3, txtSBD3;
	private JTable table, table_1;
	private JComboBox<Object> cbKhoi;
	private JLabel lblNewLabel, lblSBD, lblMon3, lblMon2, lblMon1, lblKhoi, lblUuTien, lblDiaChi, lblHoTen, lblHoTen2,
			lblTmKimTheo, lblNewLabel_1;
	private JButton btnTimKiem, btnXoa, btnLamMoi, btnSXDiem, btnSXKhoi, btnThem, btnSua, btnThongTin;
	private JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, mon1, mon2, mon3;
	private JTextField txtHoTen, txtDiaChi, txtUuTien, txtKhoi, txtMon1, txtMon2, txtMon3, txtSBD2;

//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminView adminView = new AdminView();
//					adminView.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminView() {
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

		lblNewLabel = new JLabel("QUẢN LÝ THÍ SINH");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(343, 10, 222, 53);
		QLTS.add(lblNewLabel);

		lblSBD = new JLabel("SBD");
		lblSBD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSBD.setBounds(23, 70, 63, 30);
		QLTS.add(lblSBD);

		lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblHoTen.setBounds(23, 125, 63, 30);
		QLTS.add(lblHoTen);

		lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiaChi.setBounds(23, 182, 63, 30);
		QLTS.add(lblDiaChi);

		lblUuTien = new JLabel("Ưu tiên");
		lblUuTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUuTien.setBounds(23, 242, 63, 30);
		QLTS.add(lblUuTien);

		lblKhoi = new JLabel("Khối");
		lblKhoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhoi.setBounds(23, 303, 63, 30);
		QLTS.add(lblKhoi);

		lblMon1 = new JLabel("Toán");
		lblMon1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMon1.setBounds(23, 365, 63, 30);
		QLTS.add(lblMon1);

		lblMon2 = new JLabel("Lý");
		lblMon2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMon2.setBounds(23, 429, 63, 30);
		QLTS.add(lblMon2);

		lblMon3 = new JLabel("Hóa");
		lblMon3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMon3.setBounds(23, 486, 63, 30);
		QLTS.add(lblMon3);

		SBD = new JTextField();
		SBD.setBounds(79, 77, 80, 23);
		QLTS.add(SBD);
		SBD.setColumns(10);

		hoTen = new JTextField();
		hoTen.setColumns(10);
		hoTen.setBounds(79, 125, 209, 30);
		QLTS.add(hoTen);

		diaChi = new JTextField();
		diaChi.setColumns(10);
		diaChi.setBounds(79, 182, 209, 30);
		QLTS.add(diaChi);

		uuTien = new JTextField();
//		uuTien.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				try {
//					float ut = Float.parseFloat(uuTien.getText());
//					if (ut < 0 || ut > 3)
//						throw new NumberFormatException();
//				} catch (NumberFormatException e2) {
//					JOptionPane.showMessageDialog(null, "Ưu tiên không hợp lệ!");
//					uuTien.requestFocusInWindow();
//				}
//			}
//		});
		uuTien.setColumns(10);
		uuTien.setBounds(79, 242, 110, 30);
		QLTS.add(uuTien);

		cbKhoi = new JComboBox<Object>();
		cbKhoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbKhoi.getSelectedIndex() == 0) {
					lblMon1.setText("Toán");
					lblMon2.setText("Lý");
					lblMon3.setText("Hóa");
				} else if (cbKhoi.getSelectedIndex() == 1) {
					lblMon1.setText("Toán");
					lblMon2.setText("Hóa");
					lblMon3.setText("Sinh");
				} else {
					lblMon1.setText("Văn");
					lblMon2.setText("Sử");
					lblMon3.setText("Địa");
				}
			}
		});
		cbKhoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbKhoi.setModel(new DefaultComboBoxModel<Object>(new String[] { "Khối A", "Khối B", "Khối C" }));
		cbKhoi.setBounds(77, 303, 122, 30);
		QLTS.add(cbKhoi);

		diemMon1 = new JTextField();
//		diemMon1.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				try {
//					float diem = Float.parseFloat(diemMon1.getText());
//					if (diem < 0 || diem > 10)
//						throw new NumberFormatException();
//				} catch (NumberFormatException e2) {
//					JOptionPane.showMessageDialog(null, "Nhập điểm môn " + lblMon1.getText() + " không hợp lệ");
//					diemMon1.requestFocusInWindow();
//				}
//			}
//		});
		diemMon1.setColumns(10);
		diemMon1.setBounds(79, 372, 110, 23);
		QLTS.add(diemMon1);

		diemMon2 = new JTextField();
//		diemMon2.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				try {
//					float diem = Float.parseFloat(diemMon2.getText());
//					if (diem < 0 || diem > 10)
//						throw new NumberFormatException();
//				} catch (NumberFormatException e2) {
//					JOptionPane.showMessageDialog(null, "Nhập điểm môn " + lblMon2.getText() + " không hợp lệ");
//					diemMon2.requestFocusInWindow();
//				}
//			}
//		});
		diemMon2.setColumns(10);
		diemMon2.setBounds(79, 436, 110, 23);
		QLTS.add(diemMon2);

		diemMon3 = new JTextField();
//		diemMon3.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				try {
//					float diem = Float.parseFloat(diemMon3.getText());
//					if (diem < 0 || diem > 10)
//						throw new NumberFormatException();
//				} catch (NumberFormatException e2) {
//					JOptionPane.showMessageDialog(null, "Nhập điểm môn " + lblMon3.getText() + " không hợp lệ");
//					diemMon3.requestFocusInWindow();
//				}
//			}
//		});
		diemMon3.setColumns(10);
		diemMon3.setBounds(79, 493, 110, 23);
		QLTS.add(diemMon3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 55, 553, 309);
		QLTS.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

				SBD.setEnabled(false);

				// set data to text field when raw is selected
				String tblSbd = tblModel.getValueAt(table.getSelectedRow(), 0).toString();
				String tblHoTen = tblModel.getValueAt(table.getSelectedRow(), 1).toString();
				String tblDiaChi = tblModel.getValueAt(table.getSelectedRow(), 2).toString();
				String tblUuTien = tblModel.getValueAt(table.getSelectedRow(), 3).toString();
				String tblTenKhoi = tblModel.getValueAt(table.getSelectedRow(), 4).toString();
				String tblDiem1 = tblModel.getValueAt(table.getSelectedRow(), 5).toString();
				String tblDiem2 = tblModel.getValueAt(table.getSelectedRow(), 6).toString();
				String tblDiem3 = tblModel.getValueAt(table.getSelectedRow(), 7).toString();

				SBD.setText(tblSbd);
				hoTen.setText(tblHoTen);
				diaChi.setText(tblDiaChi);
				uuTien.setText(tblUuTien);
				if (tblTenKhoi.equals("Khối A"))
					cbKhoi.setSelectedIndex(0);
				else if (tblTenKhoi.equals("Khối B"))
					cbKhoi.setSelectedIndex(1);
				else
					cbKhoi.setSelectedIndex(2);
				diemMon1.setText(tblDiem1);
				diemMon2.setText(tblDiem2);
				diemMon3.setText(tblDiem3);

			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "SBD", "H\u1ECD t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "\u01AFu ti\u00EAn",
						"T\u00EAn kh\u1ED1i", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2",
						"\u0110i\u1EC3m m\u00F4n 3", "T\u1ED5ng" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(141);
		table.getColumnModel().getColumn(2).setPreferredWidth(159);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		table.getColumnModel().getColumn(4).setPreferredWidth(61);
		table.getColumnModel().getColumn(7).setPreferredWidth(71);
		scrollPane.setViewportView(table);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ThiSinh ts = new ThiSinh();
				boolean check = true;

				if (ThiSinhDao.checkSBD(SBD.getText())) {
					if (SBD.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "SBD không được để trống!");
						check = false;
					} else if (hoTen.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
						check = false;
					} else if (diaChi.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
						check = false;
					} else if (uuTien.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Ưu tiên không được để trống!");
						check = false;
					} else if (diemMon1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Môn " + lblMon1.getText() + " không được để trống!");
						check = false;
					} else if (diemMon2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Môn " + lblMon2.getText() + " không được để trống!");
						check = false;
					} else if (diemMon3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Môn " + lblMon3.getText() + " không được để trống!");
						check = false;
					} else if(!uuTien.getText().equals("")) {
						try {
							float ut = Float.parseFloat(uuTien.getText());
							if (ut < 0 || ut > 3)
								throw new NumberFormatException();
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Ưu tiên không hợp lệ");
							check = false;
						}
					}
					
					try {
						float d1 = Float.parseFloat(diemMon1.getText());
						if (d1 < 0 || d1 > 10)
							throw new NumberFormatException();
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Điểm môn " + lblMon1.getText() + " không hợp lệ!");
						check = false;
					}
					
					try {
						float d2 = Float.parseFloat(diemMon2.getText());
						if (d2 < 0 || d2 > 10)
							throw new NumberFormatException();
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Điểm môn " + lblMon2.getText() + " không hợp lệ!");
						check = false;
					}
					
					try {
						float d3 = Float.parseFloat(diemMon3.getText());
						if (d3 < 0 || d3 > 10)
							throw new NumberFormatException();
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Điểm môn " + lblMon3.getText() + " không hợp lệ!");
						check = false;
					}
					
					if (check) {
						ts.setSbd(SBD.getText());
						ts.setHoTen(hoTen.getText());
						ts.setDiaChi(diaChi.getText());
						ts.setUuTien(Float.parseFloat(uuTien.getText()));
						ts.setKhoi(cbKhoi.getSelectedIndex() + 1);

						Diem diem = new Diem(Float.parseFloat(diemMon1.getText()), Float.parseFloat(diemMon2.getText()),
								Float.parseFloat(diemMon3.getText()));
						ts.setDiem(diem);

						ThiSinhDao.insertTS(ts);
						JOptionPane.showMessageDialog(null, "Thêm thí sinh mới thành công!");
						
						SBD.setText("");
						hoTen.setText("");
						diaChi.setText("");
						uuTien.setText("");
						cbKhoi.setSelectedIndex(0);
						diemMon1.setText("");
						diemMon2.setText("");
						diemMon3.setText("");
					}

					showData(ThiSinhDao.findAll(), table);
				} else {
					JOptionPane.showMessageDialog(null, "SDB đã tồn tại!");
				}
			}
		});
		btnThem.setBounds(23, 533, 80, 30);
		QLTS.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(true);
				ThiSinh ts = new ThiSinh();

				ts.setSbd(SBD.getText());
				ts.setHoTen(hoTen.getText());
				ts.setDiaChi(diaChi.getText());
				ts.setUuTien(Float.parseFloat(uuTien.getText()));
				ts.setKhoi(cbKhoi.getSelectedIndex() + 1);
				Diem diem = new Diem();
				diem.setDiem1(Float.parseFloat(diemMon1.getText()));
				diem.setDiem2(Float.parseFloat(diemMon2.getText()));
				diem.setDiem3(Float.parseFloat(diemMon3.getText()));
				ts.setDiem(diem);
				ThiSinhDao.update(ts);

				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");

				showData(ThiSinhDao.findAll(), table);
			}
		});
		btnSua.setEnabled(false);
		btnSua.setBounds(139, 533, 80, 30);
		QLTS.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

				String Sbd = tblModel.getValueAt(table.getSelectedRow(), 0).toString();

				ThiSinhDao.delete(Sbd);

				SBD.setText("");
				hoTen.setText("");
				diaChi.setText("");
				uuTien.setText("");
				cbKhoi.setSelectedIndex(0);
				diemMon1.setText("");
				diemMon2.setText("");
				diemMon3.setText("");

				JOptionPane.showMessageDialog(null, "Delete Successful");

				showData(ThiSinhDao.findAll(), table);
			}
		});
		btnXoa.setEnabled(false);
		btnXoa.setBounds(251, 533, 80, 30);
		QLTS.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(true);
				SBD.setText("");
				hoTen.setText("");
				diaChi.setText("");
				uuTien.setText("");
				cbKhoi.setSelectedIndex(0);
				diemMon1.setText("");
				diemMon2.setText("");
				diemMon3.setText("");
			}
		});
		btnLamMoi.setBounds(371, 533, 99, 30);
		QLTS.add(btnLamMoi);

		btnSXDiem = new JButton("Sắp xếp theo điểm");
		btnSXDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ThiSinh> list = new ArrayList<ThiSinh>();
				list = ThiSinhDao.findAll();
				ThiSinhDao.sortByScore(list);
				showData(list, table);
			}
		});
		btnSXDiem.setBounds(511, 397, 174, 30);
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
		btnSXKhoi.setBounds(721, 397, 160, 30);
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
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "SBD", "H\u1ECD t\u00EAn", "\u0110\u1ECBa ch\u1EC9", "\u01AFu ti\u00EAn", "Kh\u1ED1i",
						"\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3",
						"T\u1ED5ng" }));
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
				if(ts == null) {
					JOptionPane.showMessageDialog(null, "Không tồn tại thí sinh này!");
				}
				else {
					txtHoTen.setText(ts.getHoTen());
					txtDiaChi.setText(ts.getDiaChi());
					txtUuTien.setText(String.valueOf(ts.getUuTien()));
					if (ts.getKhoi().getMaKhoi() == 1) {
						txtKhoi.setText("Khối A");
						mon1.setText("Toán");
						mon2.setText("Lý");
						mon3.setText("Hóa");
						txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
						txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
						txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
					} else if (ts.getKhoi().getMaKhoi() == 2) {
						txtKhoi.setText("Khối B");
						mon1.setText("Toán");
						mon2.setText("Hóa");
						mon3.setText("Sinh");
						txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
						txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
						txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
					} else {
						txtKhoi.setText("Khối C");
						mon1.setText("Văn");
						mon2.setText("Sử");
						mon3.setText("Địa");
						txtMon1.setText(String.valueOf(ts.getDiem().getDiem1()));
						txtMon2.setText(String.valueOf(ts.getDiem().getDiem2()));
						txtMon3.setText(String.valueOf(ts.getDiem().getDiem3()));
					}
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

		panel = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel, null);
		showData(ThiSinhDao.findAll(), table);

		JFreeChart pieChart = createChart(createDataset());
		panel.setLayout(null);
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(8, 10, 921, 569);
		panel.add(chartPanel);
		chartPanel.setLayout(null);
	}

	public void showData(List<ThiSinh> dsts1, JTable tableName) {
		List<ThiSinh> dsts = new ArrayList<>();
		dsts = dsts1;
		DefaultTableModel tableModel;
		tableName.getModel();
		tableModel = (DefaultTableModel) tableName.getModel();
		tableModel.setRowCount(0);
		dsts.forEach((thiSinh) -> {
			tableModel.addRow(new Object[] { thiSinh.getSbd(), thiSinh.getHoTen(), thiSinh.getDiaChi(),
					thiSinh.getUuTien(), thiSinh.getKhoi().getTenKhoi(), thiSinh.getDiem().getDiem1(),
					thiSinh.getDiem().getDiem2(), thiSinh.getDiem().getDiem3(), thiSinh.TongDiem() });
		});
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("THỐNG KÊ ĐIỂM CỦA SINH VIÊN", dataset, true, true, true);
		return chart;
	}

	private static PieDataset createDataset() {
		List<ThiSinh> list = new ArrayList<ThiSinh>();
		list = ThiSinhDao.findAll();
		float diem18 = 0, diem24 = 0;
		for (ThiSinh thiSinh : list) {
			if (thiSinh.TongDiem() < 18)
				diem18 += thiSinh.TongDiem();
			else if (thiSinh.TongDiem() < 24)
				diem24 += thiSinh.TongDiem();
		}

		int n = list.size();

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Dưới 18 điểm(" + diem18 / n + "%)", (double) diem18 / n);
		dataset.setValue("Dưới 24 điểm(" + diem24 / n + "%)", (double) diem24 / n);
		dataset.setValue("Trên 24 điểm(" + (100 - diem18 / n - diem24 / n) + "%)",
				(double) (100 - diem18 / n - diem24 / n));
		return dataset;
	}
}
