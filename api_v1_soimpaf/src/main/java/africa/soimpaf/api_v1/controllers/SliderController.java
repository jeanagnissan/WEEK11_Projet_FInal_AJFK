/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Slider;
import africa.soimpaf.api_v1.services.SliderService;
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
@RequestMapping("/api/sliders")
public class SliderController {
	@Autowired
	private SliderService sliderService;

	@GetMapping
	public  ResponseEntity<List<Slider>> getAllSlider() {
		return new ResponseEntity<>(sliderService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Slider>> getSingleSlider(@PathVariable("id") long id) {
		return new ResponseEntity<>(sliderService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Slider> createsSingleSlider(@Validated @RequestBody Slider slider) {
		return new ResponseEntity<>(sliderService.create(slider), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Slider>  updateSingleSlider(@PathVariable("id") long id ,@Validated @RequestBody Slider slider) {
		return new ResponseEntity<>(sliderService.update(id, slider), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleSlider(@PathVariable("id") long id) {
		sliderService.delete(id);
		return "deleted";
	}

}
