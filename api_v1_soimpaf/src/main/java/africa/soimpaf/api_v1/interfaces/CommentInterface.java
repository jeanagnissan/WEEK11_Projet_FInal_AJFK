
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentInterface {

    List<Comment> getAll();

    Comment create(Comment comment);

    Optional<Comment> getSingle(long id);

    void delete (long id);

    Comment update(long id, Comment comment);

    Optional<Comment> getById(long id);

}
