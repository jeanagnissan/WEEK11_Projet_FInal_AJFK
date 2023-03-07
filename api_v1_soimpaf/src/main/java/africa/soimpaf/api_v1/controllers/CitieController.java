/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Citie;
import africa.soimpaf.api_v1.services.CitieService;
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
@RequestMapping("/api/cities")
public class CitieController {
	@Autowired
	private CitieService citieService;

	@GetMapping
	public  ResponseEntity<List<Citie>> getAllCitie() {
		return new ResponseEntity<>(citieService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Citie>> getSingleCitie(@PathVariable("id") long id) {
		return new ResponseEntity<>(citieService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Citie> createsSingleCitie(@Validated @RequestBody Citie citie) {
		return new ResponseEntity<>(citieService.create(citie), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Citie>  updateSingleCitie(@PathVariable("id") long id ,@Validated @RequestBody Citie citie) {
		return new ResponseEntity<>(citieService.update(id, citie), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleCitie(@PathVariable("id") long id) {
		citieService.delete(id);
		return "deleted";
	}

}
