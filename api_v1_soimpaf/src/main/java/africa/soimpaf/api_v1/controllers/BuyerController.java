/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Buyer;
import africa.soimpaf.api_v1.services.BuyerService;
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
@RequestMapping("/api/buyers")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;

	@GetMapping
	public  ResponseEntity<List<Buyer>> getAllBuyer() {
		return new ResponseEntity<>(buyerService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Buyer>> getSingleBuyer(@PathVariable("id") long id) {
		return new ResponseEntity<>(buyerService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Buyer> createsSingleBuyer(@Validated @RequestBody Buyer buyer) {
		return new ResponseEntity<>(buyerService.create(buyer), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Buyer>  updateSingleBuyer(@PathVariable("id") long id ,@Validated @RequestBody Buyer buyer) {
		return new ResponseEntity<>(buyerService.update(id, buyer), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleBuyer(@PathVariable("id") long id) {
		buyerService.delete(id);
		return "deleted";
	}

}
