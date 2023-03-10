/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Warehouse;
import africa.soimpaf.api_v1.services.WarehouseService;
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
@RequestMapping("/api/warehouses")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;

	@GetMapping()
	public  ResponseEntity<List<Warehouse>> getAllWarehouse() {
		return new ResponseEntity<>(warehouseService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Warehouse>> getSingleWarehouse(@PathVariable("id") long id) {
		return new ResponseEntity<>(warehouseService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Warehouse> createsSingleWarehouse(@Validated @RequestBody Warehouse warehouse) {
		return new ResponseEntity<>(warehouseService.create(warehouse), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  ResponseEntity<Warehouse>  updateSingleWarehouse(@PathVariable("id") long id ,@Validated @RequestBody Warehouse warehouse) {
		return new ResponseEntity<>(warehouseService.update(id, warehouse), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}")
	public  String deleteSingleWarehouse(@PathVariable("id") long id) {
		warehouseService.delete(id);
		return "deleted";
	}

}
