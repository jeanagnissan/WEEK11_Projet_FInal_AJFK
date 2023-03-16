/**
 * 
 */
package africa.soimpaf.api_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1.models.Product;

import java.util.List;

/**
 * @author digitalci
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   //List<Product> findProductByTypeCropId(Long idtypecrop);
}
