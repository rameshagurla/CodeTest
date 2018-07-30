import java.util.List;


public class Package {
		int id;
		String name;
		String description;
		List<Product> products;
		double price;
		
		public Package(int id, String name, String description,
				List<Product> products, double price) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.products = products;
			this.price = price;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		   @Override
		    public int hashCode() {
		        final int prime = 31;
		        int result = 1;
		        result = prime * result + (int) (id ^ (id >>> 32));
		        return result;
		    }
		 
		    @Override
		    public boolean equals(Object obj) {
		        if (this == obj)
		            return true;
		        if (obj == null)
		            return false;
		        if (getClass() != obj.getClass())
		            return false;
		        return true;
		    }
		 
		    @Override
		    public String toString() {
		        return "Product [id=" + id + ", name=" + name + ", usdPrice=" + price + "]";
		    }
}
