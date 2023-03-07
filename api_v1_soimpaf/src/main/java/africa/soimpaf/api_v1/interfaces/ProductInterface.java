
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {

    List<Product> getAll();

    Product create(Product product);

    Optional<Product> getSingle(long id);

    void delete (long id);

    Product update(long id, Product product);

    Optional<Product> getById(long id);

}
