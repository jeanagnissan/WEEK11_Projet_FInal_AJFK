
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Famer;

import java.util.List;
import java.util.Optional;

public interface FamerInterface {

    List<Famer> getAll();

    Famer create(Famer famer);

    Optional<Famer> getSingle(long id);

    void delete (long id);

    Famer update(long id, Famer famer);

    Optional<Famer> getById(long id);

}
