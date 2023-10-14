package tuan3;



public class Product  {
	private String id;
	private String name;
	private double price;
	private String type;
	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return  id + ", " + name + ", " + price + ", " + type + "]";
	}
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	
	
	

}
