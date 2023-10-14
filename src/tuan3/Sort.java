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
	public void swap(OrderItem[] arr, int index1, int index2) {
		OrderItem change = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = change;
	}
	public void bubbleSort(Order o1) {
		boolean check=false;
		for(int i=0;i<o1.getItems().length-1;i++) {
			for(int j=i+1;j<o1.getItems().length-i;j++) {
				if(o1.getItems()[i].getP().getId().compareTo
						(o1.getItems()[j].getP().getId())>0) {
					swap(o1.getItems(), i, j);
					check=true;
				}
				if(check==false) {
					break;
				}
			}
			
			
		}
	}
	
	
}
