package tuan9_task2;

import java.util.List;

public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int nxb;
	protected String tacGia;
	protected double giaTien;
	public AnPham(String tieuDe, int soTrang, int nxb, String tacGia, double giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.nxb = nxb;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}
	protected abstract String getType();
	protected abstract boolean checkType();
	protected abstract List<Chuong>getListChuong();
	protected abstract String isName();
	public boolean publicationTime() {//thời gian xuất bản cách đây 10 năm hay ko(2021)
		return checkType()==false&&2021-this.nxb==10?true:false;
		
	}
	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", nxb=" + nxb + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]";
	}
	
	
}
