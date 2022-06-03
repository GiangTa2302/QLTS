package entity;

public class Khoi {
	private int maKhoi;
	private String tenKhoi;
	
	public Khoi() {
		maKhoi = 0;
		tenKhoi = "";
	}
	
	public Khoi(int maKhoi, String tenKhoi) {
		this.setMaKhoi(maKhoi);
		this.setTenKhoi(tenKhoi);
	}

	public int getMaKhoi() {
		return maKhoi;
	}

	public void setMaKhoi(int maKhoi) {
		this.maKhoi = maKhoi;
	}

	public String getTenKhoi() {
		return tenKhoi;
	}

	public void setTenKhoi(String tenKhoi) {
		this.tenKhoi = tenKhoi;
	}
}
