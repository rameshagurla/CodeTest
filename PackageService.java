import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service("packageService")
public class PackageService {
	private static List<Product> products = populateProducts();
	
	public Product findById(String id) {
		 for(Product product : products){
	            if(product.getId() == id){
	                return product;
	            }
	        }
	        return null;
	}
	public boolean isProductExist(Product product) {
		return findById(product.getId())!=null;
	}
	public void saveProduct(Product product) {
		products.add(product);
		
	}
	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);
		
	}
	public List<Product> getAll() {
		return products;
	}

    private static List<Product> populateProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("VqKb4tyj9V6i","Shield", 1149));
        products.add(new Product("DXSQpv6XVeJm","Helmet", 999));
        products.add(new Product("7dgX6XzU3Wds","Sword", 899));
        products.add(new Product("PKM5pGAh9yGm","Axe", 799));
        products.add(new Product("7Hv0hA2nmci7","Knief", 349));
        products.add(new Product("500R5EHvNlNB","Gold Coin", 249));
        products.add(new Product("IP3cv7TcZhQn","Platinum Coin", 399));
        products.add(new Product("IJOHGYkY2CYq","Bow", 649));
        products.add(new Product("8anPsR2jbfNW","Silver Coin", 50));
        return products;
    }
}
