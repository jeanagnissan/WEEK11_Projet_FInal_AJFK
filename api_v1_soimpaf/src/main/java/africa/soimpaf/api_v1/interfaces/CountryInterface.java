
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryInterface {

    List<Country> getAll();

    Country create(Country country);

    Optional<Country> getSingle(long id);

    void delete (long id);

    Country update(long id, Country country);

    Optional<Country> getById(long id);

}
