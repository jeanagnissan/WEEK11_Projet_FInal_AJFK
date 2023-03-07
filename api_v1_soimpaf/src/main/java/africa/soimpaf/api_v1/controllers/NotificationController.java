/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Notification;
import africa.soimpaf.api_v1.services.NotificationService;
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
@RequestMapping("/api/notifications")
public class NotificationController {
	@Autowired
	private NotificationService notificationService;

	@GetMapping
	public  ResponseEntity<List<Notification>> getAllNotification() {
		return new ResponseEntity<>(notificationService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Notification>> getSingleNotification(@PathVariable("id") long id) {
		return new ResponseEntity<>(notificationService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Notification> createsSingleNotification(@Validated @RequestBody Notification notification) {
		return new ResponseEntity<>(notificationService.create(notification), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Notification>  updateSingleNotification(@PathVariable("id") long id ,@Validated @RequestBody Notification notification) {
		return new ResponseEntity<>(notificationService.update(id, notification), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleNotification(@PathVariable("id") long id) {
		notificationService.delete(id);
		return "deleted";
	}

}
