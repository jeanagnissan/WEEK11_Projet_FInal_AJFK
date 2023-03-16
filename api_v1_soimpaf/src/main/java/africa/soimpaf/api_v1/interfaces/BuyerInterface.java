
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerInterface {

    List<Buyer> getAll();

    Buyer create(Buyer buyer);

    Optional<Buyer> getSingle(long id);

    String delete (long id);

    Buyer update(long id, Buyer buyer);

    Optional<Buyer> getById(long id);

}
