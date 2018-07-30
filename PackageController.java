import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/")
// @RequestMapping("https://product-service.herokuapp.com/api/v1/products")
public class PackageController {

	public static final Logger logger = LoggerFactory
			.getLogger(PackageController.class);

	@Autowired
	PackageService packageService;

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> products = packageService.getAll();
		if (products.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
		logger.info("Fetching Product with id {}", id);
		Product product = packageService.findById(id);
		if (product == null) {
			logger.error("Product with id {} not found.", id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating Product : {}", product);

		if (packageService.isProductExist(product)) {
			logger.error("Unable to create. A Product with name {} already exist", product.getName());
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		packageService.saveProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/product/{id}")
				.buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable("id") String id,
			@RequestBody Product product) {
		logger.info("Updating Product with id {}", id);

		Product currentProduct = packageService.findById(id);

		if (currentProduct == null) {
			logger.error("Unable to update. Product with id {} not found.", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		currentProduct.setName(product.getName());
		currentProduct.setId(product.getId());
		currentProduct.setUsdPrice(product.getUsdPrice());

		packageService.updateProduct(currentProduct);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}

}
