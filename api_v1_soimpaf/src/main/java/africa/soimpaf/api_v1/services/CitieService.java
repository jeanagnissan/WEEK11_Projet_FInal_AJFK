package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.CitieInterface;
import africa.soimpaf.api_v1.models.Citie;
import africa.soimpaf.api_v1.repository.CitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitieService implements CitieInterface {
    @Autowired CitieRepository citieRepository;

    @Override
    public List<Citie> getAll() {
        return (List<Citie>) citieRepository.findAll();
    }

    @Override
    public Citie create(Citie citie) {
        return citieRepository.save(citie);
    }

    @Override
    public Optional<Citie> getSingle(long id) {
        return  citieRepository.findById(id);
    }

    @Override
    public Citie update(long id, Citie citie) {
        return citieRepository.save(citie);
    }

    @Override
    public void delete(long id) {
        citieRepository.deleteById(id);
    }

    @Override
    public Optional<Citie> getById(long id) {
        return  citieRepository.findById(id);
    }

}
