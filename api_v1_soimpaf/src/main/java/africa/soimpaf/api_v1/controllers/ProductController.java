/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Product;
import africa.soimpaf.api_v1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping()
	public  ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable("id") long id) {
		return new ResponseEntity<>(productService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Product> createsSingleProduct(@Validated @RequestBody Product product) {
		return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Product>  updateSingleProduct(@PathVariable("id") long id ,@Validated @RequestBody Product product) {
		return new ResponseEntity<>(productService.update(id, product), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}")
	public  String deleteSingleProduct(@PathVariable("id") long id) {
		productService.delete(id);
		return "deleted";
	}

}
