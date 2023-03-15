/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Farmer;
import africa.soimpaf.api_v1.services.FarmerService;
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
@RequestMapping("/api/farmers")
public class FarmerController {
	@Autowired
	private FarmerService famerService;

	@GetMapping()
	public  ResponseEntity<List<Farmer>> getAllFarmer() {
		return new ResponseEntity<>(famerService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Farmer>> getSingleFarmer(@PathVariable("id") long id) {
		return new ResponseEntity<>(famerService.getSingle(id), HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<Farmer> createsSingleFarmer(@Validated @RequestBody Farmer farmer) {
		return new ResponseEntity<>(famerService.create(farmer), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public  ResponseEntity<Farmer>  updateSingleFarmer(@PathVariable("id") long id ,@Validated @RequestBody Farmer farmer) {
		return new ResponseEntity<>(famerService.update(id, farmer), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public  String deleteSingleFarmer(@PathVariable("id") long id) {
		famerService.delete(id);
		return "deleted";
	}

}
