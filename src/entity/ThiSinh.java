package entity;

public class ThiSinh{
	private int id;
	private String sbd;
	private String hoTen, diaChi;
	private float uuTien;
	private Khoi khoi = new Khoi();
	private Diem diem = new Diem();
	
	public ThiSinh() {}
	
	public ThiSinh(int id, String sbd, String hoTen, String diaChi, float uuTien, int maKhoi, String tenKhoi, float d1, float d2, float d3)
	{
		this.id = id;
		this.setSbd(sbd);
		this.setHoTen(hoTen);
		this.setDiaChi(diaChi);
		this.setUuTien(uuTien);
		this.khoi = new Khoi(maKhoi, tenKhoi);
		this.setDiem(new Diem(d1, d2, d3));
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

	public float getUuTien() {
		return uuTien;
	}

	public void setUuTien(float uuTien) {
		this.uuTien = uuTien;
	}

	public Khoi getKhoi() {
		return khoi;
	}

	public void setKhoi(int maKhoi) {
		this.khoi.setMaKhoi(maKhoi);
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

	public String getSbd() {
		return sbd;
	}

	public void setSbd(String sbd) {
		this.sbd = sbd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float TongDiem() {
		return diem.Tong() + uuTien;
	}
	
	public String toString() {
		return "id: " + id + "Ho ten: " + hoTen + ", dia chi: " + diaChi + ", uu tien: " + uuTien + ", ten khoi: " + khoi.getTenKhoi() + ", diem1: " + diem.getDiem1()
		+ ", diem2: " + diem.getDiem2() + ", diem3: " + diem.getDiem3() + "\n";
	}
}
