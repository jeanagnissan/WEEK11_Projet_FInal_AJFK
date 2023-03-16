package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.WarehouseInterface;
import africa.soimpaf.api_v1.models.Warehouse;
import africa.soimpaf.api_v1.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService implements WarehouseInterface {
    @Autowired WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAll() {
        return (List<Warehouse>) warehouseRepository.findAll();
    }

    @Override
    public Warehouse create(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Optional<Warehouse> getSingle(long id) {
        return  warehouseRepository.findById(id);
    }

    @Override
    public Warehouse update(long id, Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public Optional<Warehouse> getById(long id) {
        return  warehouseRepository.findById(id);
    }

}
