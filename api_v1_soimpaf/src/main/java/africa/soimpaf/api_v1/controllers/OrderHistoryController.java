/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.OrderHistory;
import africa.soimpaf.api_v1.services.OrderHistoryService;
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
@RequestMapping("/api/orderHistorys")
public class OrderHistoryController {
	@Autowired
	private OrderHistoryService orderHistoryService;

	@GetMapping
	public  ResponseEntity<List<OrderHistory>> getAllOrderHistory() {
		return new ResponseEntity<>(orderHistoryService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<OrderHistory>> getSingleOrderHistory(@PathVariable("id") long id) {
		return new ResponseEntity<>(orderHistoryService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<OrderHistory> createsSingleOrderHistory(@Validated @RequestBody OrderHistory orderHistory) {
		return new ResponseEntity<>(orderHistoryService.create(orderHistory), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<OrderHistory>  updateSingleOrderHistory(@PathVariable("id") long id ,@Validated @RequestBody OrderHistory orderHistory) {
		return new ResponseEntity<>(orderHistoryService.update(id, orderHistory), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleOrderHistory(@PathVariable("id") long id) {
		orderHistoryService.delete(id);
		return "deleted";
	}

}
