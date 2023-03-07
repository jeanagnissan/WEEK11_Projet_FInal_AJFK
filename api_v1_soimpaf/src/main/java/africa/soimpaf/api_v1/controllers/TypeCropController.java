/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.TypeCrop;
import africa.soimpaf.api_v1.services.TypeCropService;
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
@RequestMapping("/api/typeCrops")
public class TypeCropController {
	@Autowired
	private TypeCropService typeCropService;

	@GetMapping
	public  ResponseEntity<List<TypeCrop>> getAllTypeCrop() {
		return new ResponseEntity<>(typeCropService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<TypeCrop>> getSingleTypeCrop(@PathVariable("id") long id) {
		return new ResponseEntity<>(typeCropService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<TypeCrop> createsSingleTypeCrop(@Validated @RequestBody TypeCrop typeCrop) {
		return new ResponseEntity<>(typeCropService.create(typeCrop), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<TypeCrop>  updateSingleTypeCrop(@PathVariable("id") long id ,@Validated @RequestBody TypeCrop typeCrop) {
		return new ResponseEntity<>(typeCropService.update(id, typeCrop), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleTypeCrop(@PathVariable("id") long id) {
		typeCropService.delete(id);
		return "deleted";
	}

}
