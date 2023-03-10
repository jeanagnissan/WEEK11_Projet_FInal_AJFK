package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.FarmerInterface;
import africa.soimpaf.api_v1.models.Farmer;
import africa.soimpaf.api_v1.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService implements FarmerInterface {
    @Autowired FarmerRepository famerRepository;

    @Override
    public List<Farmer> getAll() {
        return (List<Farmer>) famerRepository.findAll();
    }

    @Override
    public Farmer create(Farmer farmer) {
        return famerRepository.save(farmer);
    }

    @Override
    public Optional<Farmer> getSingle(long id) {
        return  famerRepository.findById(id);
    }

    @Override
    public Farmer update(long id, Farmer farmer) {
        return famerRepository.save(farmer);
    }

    @Override
    public void delete(long id) {
        famerRepository.deleteById(id);
    }

    @Override
    public Optional<Farmer> getById(long id) {
        return  famerRepository.findById(id);
    }

}
