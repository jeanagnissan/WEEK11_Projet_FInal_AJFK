/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Rating;
import africa.soimpaf.api_v1.services.RatingService;
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
@RequestMapping("/api/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@GetMapping
	public  ResponseEntity<List<Rating>> getAllRating() {
		return new ResponseEntity<>(ratingService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Rating>> getSingleRating(@PathVariable("id") long id) {
		return new ResponseEntity<>(ratingService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Rating> createsSingleRating(@Validated @RequestBody Rating rating) {
		return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Rating>  updateSingleRating(@PathVariable("id") long id ,@Validated @RequestBody Rating rating) {
		return new ResponseEntity<>(ratingService.update(id, rating), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public  String deleteSingleRating(@PathVariable("id") long id) {
		ratingService.delete(id);
		return "deleted";
	}

}
