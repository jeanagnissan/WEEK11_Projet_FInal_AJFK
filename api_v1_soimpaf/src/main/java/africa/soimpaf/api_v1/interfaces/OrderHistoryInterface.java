
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.OrderHistory;

import java.util.List;
import java.util.Optional;

public interface OrderHistoryInterface {

    List<OrderHistory> getAll();

    OrderHistory create(OrderHistory orderHistory);

    Optional<OrderHistory> getSingle(long id);

    void delete (long id);

    OrderHistory update(long id, OrderHistory orderHistory);

    Optional<OrderHistory> getById(long id);

}
