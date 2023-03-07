
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderInterface {

    List<Order> getAll();

    Order create(Order order);

    Optional<Order> getSingle(long id);

    void delete (long id);

    Order update(long id, Order order);

    Optional<Order> getById(long id);

}
