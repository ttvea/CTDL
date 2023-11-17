package tuan9_task2;

import java.util.ArrayList;
import java.util.List;

public class TestAnPham {
	public static void main(String[] args) {
		Chuong c1= new Chuong("Chuong1",10);
		Chuong c2= new Chuong("Chuong2",15);
		Chuong c3= new Chuong("Chuong3",20);
		List<Chuong>ch=new ArrayList<>();
		ch.add(c1);
		ch.add(c2);
		
		List<Chuong>ch2=new ArrayList<>();
		ch2.add(c3);
		AnPham a1=new SachThamKhoa("ChienTranh",200,1990,"Nguyen A",12500,"LichSu",ch);
		AnPham a2=new TapChi("Tieude",10,2020,"Nguyen Van A",10000,"TapChi1");
		AnPham a3=new TapChi("Tieude",10,2021,"Nguyen Van B",10000,"TapChi2");
		AnPham a4=new SachThamKhoa("ChienTranh2",200,1990,"Nguyen A",12500,"LichSu",ch2);
//		System.out.println(a2.getType());
//		System.out.println(a2.publicationTime());
		List<AnPham>dsAnPham=new ArrayList<>();
		dsAnPham.add(a2);
		dsAnPham.add(a3);
		dsAnPham.add(a1);
		dsAnPham.add(a4);
		DanhMucAnPhan dm=new DanhMucAnPhan(dsAnPham);
//		System.out.println(dm.sameTypeAndSameAuthor(a2, a3));;
//		System.out.println(dm.Sum());
//		System.out.println(dm.maxPage());
//		System.out.println(dm.checkTenTapChi("TapChi1"));
//		System.out.println(dm.dsTapChi());
//		dm.sort();
//		dm.print();
		System.out.println(dm.thongKe());
	}
}
