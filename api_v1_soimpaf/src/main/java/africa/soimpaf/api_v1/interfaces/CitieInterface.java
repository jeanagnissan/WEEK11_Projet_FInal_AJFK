
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Citie;

import java.util.List;
import java.util.Optional;

public interface CitieInterface {

    List<Citie> getAll();

    Citie create(Citie citie);

    Optional<Citie> getSingle(long id);

    void delete (long id);

    Citie update(long id, Citie citie);

    Optional<Citie> getById(long id);

}
