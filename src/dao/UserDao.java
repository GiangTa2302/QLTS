package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.User;
import utils.ConnJDBC;

public class UserDao {
	public static boolean checkUser(String tenDN, String matKhau) {
		
		String query = "SELECT * FROM user WHERE tenDN = '"+tenDN+"' AND matKhau = '"+matKhau+"'";
		User user = null;
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("tenDN"),
						rs.getString("matKhau"),
						rs.getString("hoTen"),
						rs.getString("diaChi"),
						rs.getString("gioiTinh"),
						rs.getInt("chuVu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user != null)
			return true;
		else return false;
	}
	
	public static User getUser(String tenDN, String matKhau) {
		User user = new User();
		String query = "SELECT * FROM user WHERE tenDN = '"+tenDN+"' AND matKhau = '"+matKhau+"'";
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("tenDN"),
						rs.getString("matKhau"),
						rs.getString("hoTen"),
						rs.getString("diaChi"),
						rs.getString("gioiTinh"),
						rs.getInt("chuVu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void register(User user)
	{
		String query = "INSERT INTO user(tenDN, matKhau, hoTen, diaChi, gioiTinh) VALUES (?,?,?,?,?)";
		try {
			Connection connection = ConnJDBC.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, user.getTenDN());
			pstmt.setString(2, user.getMatKhau());
			pstmt.setString(3, user.getHoTen());
			pstmt.setString(4, user.getGioiTinh());
			pstmt.setString(5, user.getDiaChi());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
