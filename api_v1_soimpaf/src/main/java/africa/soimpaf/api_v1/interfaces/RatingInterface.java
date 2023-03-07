
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingInterface {

    List<Rating> getAll();

    Rating create(Rating rating);

    Optional<Rating> getSingle(long id);

    void delete (long id);

    Rating update(long id, Rating rating);

    Optional<Rating> getById(long id);

}
