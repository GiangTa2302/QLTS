package entity;

public class Diem {
	private float diem1, diem2, diem3;
	
	public Diem() {}
	
	public Diem(float diem1,float diem2, float diem3) {
		this.setDiem1(diem1);
		this.setDiem2(diem2);
		this.setDiem3(diem3);
	}

	public float getDiem1() {
		return diem1;
	}

	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	public float getDiem2() {
		return diem2;
	}

	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	public float getDiem3() {
		return diem3;
	}

	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}
	
	public float Tong() {
		return diem1 + diem2 + diem3;
	}
}
