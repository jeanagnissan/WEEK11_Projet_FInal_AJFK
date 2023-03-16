/**
 * 
 */
package africa.soimpaf.api_v1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1.models.Buyer;

/**
 * @author digitalci
 *
 */
@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> {

    @Query(value = "SELECT COUNT(id) FROM orders WHERE buyer_id=:type_id", nativeQuery = true)
    String existProduct(long type_id);

    @Query(value = "SELECT COUNT(id) FROM notifications WHERE buyer_id=:type_id", nativeQuery = true)
    String existNotification(long type_id);

}
