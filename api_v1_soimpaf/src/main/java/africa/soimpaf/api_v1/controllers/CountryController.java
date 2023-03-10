/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Country;
import africa.soimpaf.api_v1.services.CountryService;
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
@RequestMapping("/api/countrys")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping()
	public  ResponseEntity<List<Country>> getAllCountry() {
		return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Country>> getSingleCountry(@PathVariable("id") long id) {
		return new ResponseEntity<>(countryService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Country> createsSingleCountry(@Validated @RequestBody Country country) {
		return new ResponseEntity<>(countryService.create(country), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Country>  updateSingleCountry(@PathVariable("id") long id ,@Validated @RequestBody Country country) {
		return new ResponseEntity<>(countryService.update(id, country), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}")
	public  String deleteSingleCountry(@PathVariable("id") long id) {
		countryService.delete(id);
		return "deleted";
	}

}
