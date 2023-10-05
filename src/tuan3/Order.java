package tuan3;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Order {
	private OrderItem[]items;

	public Order(OrderItem[] items) {
		this.items = items;
	}
	public double cost() {
		double costAll=0;
		for(OrderItem or:items) {
			costAll+=or.costOrderItem();
		}
		return costAll;
		}
		
		// using binary search approach
		public boolean contains(Product p) {
		int low=0,high=items.length-1;
		int mid=(low+high)/2;
		if(p.getId().compareToIgnoreCase(items[mid].getP().getId())==0) {
			return true;
		}else {
			if(p.getId().compareToIgnoreCase(items[mid].getP().getId())>0){
				low=mid+1;
			}else {
				if(p.getId().compareToIgnoreCase(items[mid].getP().getId())<0){
					high=mid-1;
				}
			}
		}
		return false; 
		}
		
		// get all products based on the given type using 
		
		public Product[] filter(String type) {
		int length=0;
		for(OrderItem i:items) {
			if(i.getP().getType().compareToIgnoreCase(type)==0) {
				length++;
			}
		}
		Product[]result=new Product[length];
		
		for(OrderItem i:items) {
			if(i.getP().getType().compareToIgnoreCase(type)==0) {
				result[--length]=i.getP();
				
			}
		}
			
		return result; 
		}
		
		public OrderItem[] getItems() {
			return items;
		}
		public static void main(String[] args) {
			
			Product p1=new Product("A15","Milk",10,"Good");
			Product p2=new Product("A13","CoCa",5.6,"Very good");
			Product p3=new Product("A14","Chocolate",22.4,"Very good");
			Product p4=new Product("A11","Pepsi",20.4,"Good");
			
			OrderItem or1=new OrderItem(p1, 20);
			OrderItem or2=new OrderItem(p2, 10);
			OrderItem or3=new OrderItem(p3, 12);
			
			OrderItem list[]= {or1,or2,or3};
			
			// bang nhau tra ve 0 compareTo
			Order o= new Order(list);
			System.out.println(o.cost());
			
		
			Sort s= new Sort();
			s.sort(o);
			
			System.out.println(Arrays.toString(list));
			
			System.out.println(o.contains(p4));
			
			System.out.println(Arrays.toString(o.filter("Very good")));
		}
		
		
		
		
		
		
		
		
		
	
}
