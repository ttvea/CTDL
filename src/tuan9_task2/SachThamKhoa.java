package tuan9_task2;

import java.util.List;

public class SachThamKhoa extends AnPham{
	private String linhVuc;
	private List<Chuong>cacChuong;
	public SachThamKhoa(String tieuDe, int soTrang, int nxb, String tacGia, double giaTien, String linhVuc,
			List<Chuong> cacChuong) {
		super(tieuDe, soTrang, nxb, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.cacChuong = cacChuong;
	}
	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "SachThamKhao";
	}
	@Override
	protected boolean checkType() {
		// TODO Auto-generated method stub
		return true;
	}
	protected int SizeList() {
		return cacChuong.size();
	}
	@Override
	protected List<Chuong> getListChuong() {
		// TODO Auto-generated method stub
		return cacChuong;
	}
	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", nxb=" + nxb + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]"+"SachThamKhoa [linhVuc=" + linhVuc + ", cacChuong=" + cacChuong + "]";
	}
	@Override
	protected String isName() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
}
