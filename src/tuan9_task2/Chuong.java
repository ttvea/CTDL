package tuan9_task2;

public class Chuong {
	private String tieuDe;
	private int soTrang;
	public Chuong(String tieuDe,int soTrang) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
	}
	@Override
	public String toString() {
		return "Chuong [tieuDe=" + tieuDe + ", soTrang=" + soTrang + "]";
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	
	
}
