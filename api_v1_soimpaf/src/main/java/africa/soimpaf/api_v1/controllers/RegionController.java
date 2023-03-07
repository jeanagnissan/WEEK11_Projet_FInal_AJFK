/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Region;
import africa.soimpaf.api_v1.services.RegionService;
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
@RequestMapping("/api/regions")
public class RegionController {
	@Autowired
	private RegionService regionService;

	@GetMapping
	public  ResponseEntity<List<Region>> getAllRegion() {
		return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Region>> getSingleRegion(@PathVariable("id") long id) {
		return new ResponseEntity<>(regionService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Region> createsSingleRegion(@Validated @RequestBody Region region) {
		return new ResponseEntity<>(regionService.create(region), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Region>  updateSingleRegion(@PathVariable("id") long id ,@Validated @RequestBody Region region) {
		return new ResponseEntity<>(regionService.update(id, region), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleRegion(@PathVariable("id") long id) {
		regionService.delete(id);
		return "deleted";
	}

}
