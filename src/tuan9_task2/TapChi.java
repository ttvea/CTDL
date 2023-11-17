package tuan9_task2;

import java.util.List;

public class TapChi extends AnPham{
	private String name;

	public TapChi(String tieuDe, int soTrang, int nxb, String tacGia, double giaTien, String name) {
		super(tieuDe, soTrang, nxb, tacGia, giaTien);
		this.name = name;
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "TapChi";
	}

	@Override
	protected boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected List<Chuong> getListChuong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String isName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", nxb=" + nxb + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]"+"TapChi [name=" + name + "]"+"\n";
	}
	
	
	
	
}
