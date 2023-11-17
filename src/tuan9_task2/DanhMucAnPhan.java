package tuan9_task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPhan {
	private List<AnPham>danhSachAnPham;

	public DanhMucAnPhan(List<AnPham> danhSachAnPham) {
		this.danhSachAnPham = danhSachAnPham;
	}
	public List<AnPham> getDanhSachAnPham() {
		return danhSachAnPham;
	}
	public void setDanhSachAnPham(List<AnPham> danhSachAnPham) {
		this.danhSachAnPham = danhSachAnPham;
	}
	public boolean sameTypeAndSameAuthor(AnPham a, AnPham b) {
		return a.getType().equals(b.getType())&&a.tacGia.equals(b.tacGia)?true:false;
	}
	public double Sum() {
		double sum=0;
		for(AnPham a:danhSachAnPham) {
			sum+=a.giaTien;
		}
		return sum;
	}
	public SachThamKhoa maxPage(){
		int max=0;
		AnPham result=null;
		for(AnPham a:danhSachAnPham) {
		if(a.getListChuong()!=null) {
			List<Chuong>list=a.getListChuong();
			for(Chuong c:list) {
				if(c.getSoTrang()>=max) {
					max=c.getSoTrang();
					result=a;
				}
			}
		}
		}
		return (SachThamKhoa) result;
	}
	public boolean checkTenTapChi(String name) {
		boolean check=false;
		for(AnPham a:danhSachAnPham) {
			if(a.checkType()==false&&a.isName().equals(name)) {
				check=true;
			}
		}
		return check;
		
	}
	public List<TapChi>dsTapChi(){//xuat ban 1 nam trc
		List<TapChi>list=new ArrayList<>();
		for(AnPham a:danhSachAnPham) {
			if(a.checkType()==false&&2021-a.nxb==1) {
				list.add((TapChi)a);
			}
		}
		return list;
	}
	public void sort() {
		danhSachAnPham.sort(new Comparator<AnPham>() {

			@Override
			public int compare(AnPham o1, AnPham o2) {
				// TODO Auto-generated method stub
				int theoTieuDe=o1.tieuDe.compareTo(o2.tieuDe);
				int theoNxb=o2.nxb-o1.nxb;
				return theoTieuDe!=0?theoTieuDe:theoNxb;
			}
		});
	}
	public void print() {
		for(AnPham a:danhSachAnPham) {
			System.out.println(a.toString());
		}
	}
	public Map<Integer,Integer>thongKe(){
		Map<Integer, Integer>map=new HashMap<>();
		
		for(AnPham a:danhSachAnPham) {
			map.put(a.nxb,map.getOrDefault(a.nxb,0)+1);//số 0 có ý nghĩa là:nếu a.nxb chưa có trong map
										//thì mặc định là 1, nếu có rồi thì lấy cái cũ +1
		}
		return map;
	}
	
}
