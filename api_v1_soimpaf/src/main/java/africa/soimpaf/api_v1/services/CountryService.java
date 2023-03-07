package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.CountryInterface;
import africa.soimpaf.api_v1.models.Country;
import africa.soimpaf.api_v1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements CountryInterface {
    @Autowired CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> getSingle(long id) {
        return  countryRepository.findById(id);
    }

    @Override
    public Country update(long id, Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(long id) {
        countryRepository.deleteById(id);
    }
    
    @Override
    public Optional<Country> getById(long id) {
        return  countryRepository.findById(id);
    }

}
