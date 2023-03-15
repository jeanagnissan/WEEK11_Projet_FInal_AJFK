package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.RegionInterface;
import africa.soimpaf.api_v1.models.Region;
import africa.soimpaf.api_v1.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService implements RegionInterface {
    @Autowired RegionRepository regionRepository;

    @Override
    public List<Region> getAll() {
        return (List<Region>) regionRepository.findAll();
    }

    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Optional<Region> getSingle(long id) {
        return  regionRepository.findById(id);
    }

    @Override
    public Region update(long id, Region region) {


        return regionRepository.save(region);
    }

    @Override
    public void delete(long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Optional<Region> getById(long id) {
        return  regionRepository.findById(id);
    }

}
