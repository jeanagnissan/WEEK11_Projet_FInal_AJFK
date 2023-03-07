/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import java.util.List;
import java.util.Optional;

import africa.soimpaf.api_v1.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import africa.soimpaf.api_v1.models.Admin;

/**
 * @author digitalci
 *
 */
@RestController
@RequestMapping("/api/admins")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping
	public  ResponseEntity<List<Admin>> getAllAdmin() {
		return new ResponseEntity<>(adminService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Admin>> getSingleAdmin(@PathVariable("id") long id) {
		return new ResponseEntity<>(adminService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Admin> createsSingleAdmin(@Validated @RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.create(admin), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Admin>  updateSingleAdmin(@PathVariable("id") long id ,@Validated @RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.update(id, admin), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleAdmin(@PathVariable("id") long id) {
		adminService.delete(id);
		return "deleted";
	}

}
