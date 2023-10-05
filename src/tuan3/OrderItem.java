package tuan3;



public class OrderItem  {
	private Product p;
	private int quality;
	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}
	
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public double costOrderItem() {
		return p.getPrice()*this.quality;
	}
	
	@Override
	public String toString() {
		return  p.toString() + ", " + quality;
	}
	
}
