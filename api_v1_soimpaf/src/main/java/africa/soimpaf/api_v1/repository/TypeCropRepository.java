/**
 * 
 */
package africa.soimpaf.api_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import africa.soimpaf.api_v1.models.TypeCrop;

/**
 * @author digitalci
 *
 */
@Repository
public interface TypeCropRepository extends JpaRepository<TypeCrop, Long> {

    @Query(value = "SELECT COUNT(id) FROM products WHERE type_crop_id=:type_id", nativeQuery = true)
    String existTypeCrop(long type_id);

    //List<Product> findAllById(List<Long> TypeCrop);
}
