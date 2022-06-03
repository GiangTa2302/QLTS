package entity;

public class User {
	private int id;
	private String tenDN, matKhau, hoTen, diaChi, gioiTinh;
	private int chuVu;
	
	public User() {}
	
	public User(int id, String tenDN, String matKhau, String hoTen, String diaChi, String gioiTinh, int chucVu) {
		this.id = id;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.chuVu = chucVu;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getChuVu() {
		return chuVu;
	}
	public void setChuVu(int chuVu) {
		this.chuVu = chuVu;
	}
	
	
}
