/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Order;
import africa.soimpaf.api_v1.services.OrderService;
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
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping()
	public  ResponseEntity<List<Order>> getAllOrder() {
		return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Order>> getSingleOrder(@PathVariable("id") long id) {
		return new ResponseEntity<>(orderService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Order> createsSingleOrder(@Validated @RequestBody Order order) {
		return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Order>  updateSingleOrder(@PathVariable("id") long id ,@Validated @RequestBody Order order) {
		return new ResponseEntity<>(orderService.update(id, order), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public  String deleteSingleOrder(@PathVariable("id") long id) {
		orderService.delete(id);
		return "deleted";
	}

}
