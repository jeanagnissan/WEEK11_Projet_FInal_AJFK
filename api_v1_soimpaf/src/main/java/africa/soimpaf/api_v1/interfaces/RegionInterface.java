
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Region;

import java.util.List;
import java.util.Optional;

public interface RegionInterface {

    List<Region> getAll();

    Region create(Region region);

    Optional<Region> getSingle(long id);

    void delete (long id);

    Region update(long id, Region region);

    Optional<Region> getById(long id);

}
