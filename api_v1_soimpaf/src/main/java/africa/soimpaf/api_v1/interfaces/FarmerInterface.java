
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Farmer;

import java.util.List;
import java.util.Optional;

public interface FarmerInterface {

    List<Farmer> getAll();

    Farmer create(Farmer farmer);

    Optional<Farmer> getSingle(long id);

    void delete (long id);

    Farmer update(long id, Farmer farmer);

    Optional<Farmer> getById(long id);

}
