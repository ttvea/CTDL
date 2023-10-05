package tuan3;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
	
	public void sort(Order o1) {
		Arrays.sort(o1.getItems(),new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				// TODO Auto-generated method stub
				return o1.getP().getId().compareToIgnoreCase(o2.getP().getId());
			}
		});
	}
	
	
}
