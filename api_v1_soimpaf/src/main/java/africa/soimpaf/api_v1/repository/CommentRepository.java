/**
 * 
 */
package africa.soimpaf.api_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1.models.Comment;

/**
 * @author digitalci
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
