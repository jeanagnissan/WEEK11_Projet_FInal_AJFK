/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Famer;
import africa.soimpaf.api_v1.services.FamerService;
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
@RequestMapping("/api/famers")
public class FamerController {
	@Autowired
	private FamerService famerService;

	@GetMapping
	public  ResponseEntity<List<Famer>> getAllFamer() {
		return new ResponseEntity<>(famerService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Famer>> getSingleFamer(@PathVariable("id") long id) {
		return new ResponseEntity<>(famerService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Famer> createsSingleFamer(@Validated @RequestBody Famer famer) {
		return new ResponseEntity<>(famerService.create(famer), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Famer>  updateSingleFamer(@PathVariable("id") long id ,@Validated @RequestBody Famer famer) {
		return new ResponseEntity<>(famerService.update(id, famer), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleFamer(@PathVariable("id") long id) {
		famerService.delete(id);
		return "deleted";
	}

}
