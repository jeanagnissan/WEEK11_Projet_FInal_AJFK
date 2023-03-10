package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.ProductInterface;
import africa.soimpaf.api_v1.models.Product;
import africa.soimpaf.api_v1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements ProductInterface {
    @Autowired ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getSingle(long id) {
        return  productRepository.findById(id);
    }

    @Override
    public Product update(long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getById(long id) {
        return  productRepository.findById(id);
    }

}
