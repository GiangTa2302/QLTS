package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.ThiSinh;
import entity.ThiSinhXML;
import utils.ConnJDBC;
import utils.FileUtils;

public class ThiSinhDao {
	public static final String TS_FILE_NAME = "thisinh.xml";

	public static void writeThiSinh(List<ThiSinh> DS) {
		ThiSinhXML thiSinhXML = new ThiSinhXML();
		thiSinhXML.setThiSinh(DS);
		FileUtils.writeXMLtoFile(TS_FILE_NAME, thiSinhXML);
	}

	public static List<ThiSinh> findAll() {
		List<ThiSinh> DSTS = new ArrayList<>();
		String query = "SELECT * FROM diem INNER JOIN khoi on diem.maKhoi = khoi.maKhoi\r\n"
				+ "INNER JOIN thisinh ON thisinh.sbd = diem.sbd";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ThiSinh ts = new ThiSinh(rs.getInt("id"), rs.getString("sbd"), rs.getString("hoTen"),
						rs.getString("diaChi"), rs.getFloat("uuTien"), rs.getInt("maKhoi"), rs.getString("tenKhoi"),
						rs.getFloat("diemMon1"), rs.getFloat("diemMon2"), rs.getFloat("diemMon3"));
				DSTS.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeThiSinh(DSTS);
		return DSTS;
	}

	public static void insertTS(ThiSinh ts) {
		String query_TS = "INSERT INTO thisinh(sbd, hoTen, diaChi, uuTien) VALUES (?,?,?,?)";
		String query_Diem = "INSERT INTO diem(diemMon1, diemMon2, diemMon3, maKhoi, sbd) VALUES (?,?,?,?,?)";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query_TS);
			pstmt.setString(1, ts.getSbd());
			pstmt.setString(2, ts.getHoTen());
			pstmt.setString(3, ts.getDiaChi());
			pstmt.setFloat(4, ts.getUuTien());
			pstmt.execute();
			PreparedStatement pstmt1 = connection.prepareStatement(query_Diem);
			pstmt1.setFloat(1, ts.getDiem().getDiem1());
			pstmt1.setFloat(2, ts.getDiem().getDiem2());
			pstmt1.setFloat(3, ts.getDiem().getDiem3());
			pstmt1.setInt(4, ts.getKhoi().getMaKhoi());
			pstmt1.setString(5, ts.getSbd());
			pstmt1.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkSBD(String sbd) {
		List<ThiSinh> DSTS = new ArrayList<>();
		String query = "SELECT * FROM thisinh";

		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ThiSinh ts = new ThiSinh();
				ts.setSbd(rs.getString("sbd"));
				DSTS.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ThiSinh thiSinh : DSTS)
			if (thiSinh.getSbd().equalsIgnoreCase(sbd)) {
				return false;
			}

		return true;
	}

	public static void delete(String sbd) {
		String query = "DELETE FROM thisinh WHERE sbd = '" + sbd + "'";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update(ThiSinh ts) {
		String query_TS = "UPDATE thisinh SET hoTen=?,diaChi=?,uuTien= ? WHERE sbd = '" + ts.getSbd() + "'";
		String query_Diem = "UPDATE diem SET diemMon1=?,diemMon2=?,diemMon3=?,maKhoi=? WHERE sbd = '" + ts.getSbd()
				+ "'";
		try {
			Connection connection = ConnJDBC.getConnection();

			PreparedStatement pstmt = connection.prepareStatement(query_TS);
			pstmt.setString(1, ts.getHoTen());
			pstmt.setString(2, ts.getDiaChi());
			pstmt.setFloat(3, ts.getUuTien());
			pstmt.executeUpdate();

			PreparedStatement pstmt1 = connection.prepareStatement(query_Diem);
			pstmt1.setFloat(1, ts.getDiem().getDiem1());
			pstmt1.setFloat(2, ts.getDiem().getDiem2());
			pstmt1.setFloat(3, ts.getDiem().getDiem3());
			pstmt1.setInt(4, ts.getKhoi().getMaKhoi());
			pstmt1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<ThiSinh> findByName(String name) {
		List<ThiSinh> DS = new ArrayList<>();
		String query = "SELECT * FROM thisinh INNER JOIN diem ON thisinh.sbd = diem.sbd\r\n"
				+ "INNER JOIN khoi ON khoi.maKhoi = diem.maKhoi WHERE hoTen LIKE '%" + name + "%'";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ThiSinh ts = new ThiSinh(rs.getInt("id"), rs.getString("sbd"), rs.getString("hoTen"),
						rs.getString("diaChi"), rs.getFloat("uuTien"), rs.getInt("maKhoi"), rs.getString("tenKhoi"),
						rs.getFloat("diemMon1"), rs.getFloat("diemMon2"), rs.getFloat("diemMon3"));
				DS.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DS;
	}

	public static ThiSinh getBySBD(String sbd) {
		ThiSinh ts = null;
		String query = "SELECT * FROM thisinh INNER JOIN diem ON thisinh.sbd = diem.sbd\r\n"
				+ "INNER JOIN khoi ON khoi.maKhoi = diem.maKhoi WHERE thisinh.sbd = '" + sbd + "'";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ts = new ThiSinh(rs.getInt("id"), rs.getString("sbd"), rs.getString("hoTen"), rs.getString("diaChi"),
						rs.getFloat("uuTien"), rs.getInt("maKhoi"), rs.getString("tenKhoi"), rs.getFloat("diemMon1"),
						rs.getFloat("diemMon2"), rs.getFloat("diemMon3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	public static void sortByScore(List<ThiSinh> DSTS) {
		Collections.sort(DSTS, new sortByScore());
	}

	public static void sortByGroup(List<ThiSinh> DSTS) {
		Collections.sort(DSTS, new sortByGroup());
	}

}

class sortByScore implements Comparator<ThiSinh> {
	@Override
	public int compare(ThiSinh t1, ThiSinh t2) {
		if (t1.TongDiem() < t2.TongDiem())
			return 1;
		else
			return -1;
	}
}

class sortByGroup implements Comparator<ThiSinh> {
	@Override
	public int compare(ThiSinh t1, ThiSinh t2) {
		if (t1.TongDiem() < t2.TongDiem() && t1.getKhoi().getMaKhoi() == t2.getKhoi().getMaKhoi())
			return 1;
		else
			return -1;
	}
}
