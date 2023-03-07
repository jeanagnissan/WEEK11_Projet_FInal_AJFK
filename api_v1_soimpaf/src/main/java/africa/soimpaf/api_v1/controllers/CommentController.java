/**
 * 
 */
package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.models.Comment;
import africa.soimpaf.api_v1.services.CommentService;
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
@RequestMapping("/api/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@GetMapping
	public  ResponseEntity<List<Comment>> getAllComment() {
		return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}/single")
	public ResponseEntity<Optional<Comment>> getSingleComment(@PathVariable("id") long id) {
		return new ResponseEntity<>(commentService.getSingle(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Comment> createsSingleComment(@Validated @RequestBody Comment comment) {
		return new ResponseEntity<>(commentService.create(comment), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update")
	public  ResponseEntity<Comment>  updateSingleComment(@PathVariable("id") long id ,@Validated @RequestBody Comment comment) {
		return new ResponseEntity<>(commentService.update(id, comment), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping("/{id}/delete")
	public  String deleteSingleComment(@PathVariable("id") long id) {
		commentService.delete(id);
		return "deleted";
	}

}
