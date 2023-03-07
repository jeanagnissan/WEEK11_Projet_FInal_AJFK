package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.FamerInterface;
import africa.soimpaf.api_v1.models.Famer;
import africa.soimpaf.api_v1.repository.FamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamerService implements FamerInterface {
    @Autowired FamerRepository famerRepository;

    @Override
    public List<Famer> getAll() {
        return (List<Famer>) famerRepository.findAll();
    }

    @Override
    public Famer create(Famer famer) {
        return famerRepository.save(famer);
    }

    @Override
    public Optional<Famer> getSingle(long id) {
        return  famerRepository.findById(id);
    }

    @Override
    public Famer update(long id, Famer famer) {
        return famerRepository.save(famer);
    }

    @Override
    public void delete(long id) {
        famerRepository.deleteById(id);
    }

    @Override
    public Optional<Famer> getById(long id) {
        return  famerRepository.findById(id);
    }

}
