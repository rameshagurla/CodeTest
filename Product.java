
public class Product {
	String id;
	String name;
	double usdPrice;
	public Product(String id, String name, double usdPrice) {
		this.id = id;
		this.name = name;
		this.usdPrice = usdPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUsdPrice() {
		return usdPrice;
	}
	public void setUsdPrice(double usdPrice) {
		this.usdPrice = usdPrice;
	}

}
