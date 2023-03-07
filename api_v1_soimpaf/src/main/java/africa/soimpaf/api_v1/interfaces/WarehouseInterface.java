
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseInterface {

    List<Warehouse> getAll();

    Warehouse create(Warehouse warehouse);

    Optional<Warehouse> getSingle(long id);

    void delete (long id);

    Warehouse update(long id, Warehouse warehouse);

    Optional<Warehouse> getById(long id);

}
