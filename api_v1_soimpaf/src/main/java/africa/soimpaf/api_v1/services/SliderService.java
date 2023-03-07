package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.SliderInterface;
import africa.soimpaf.api_v1.models.Slider;
import africa.soimpaf.api_v1.repository.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SliderService implements SliderInterface {
    @Autowired SliderRepository sliderRepository;

    @Override
    public List<Slider> getAll() {
        return (List<Slider>) sliderRepository.findAll();
    }

    @Override
    public Slider create(Slider slider) {
        return sliderRepository.save(slider);
    }

    @Override
    public Optional<Slider> getSingle(long id) {
        return  sliderRepository.findById(id);
    }

    @Override
    public Slider update(long id, Slider slider) {
        return sliderRepository.save(slider);
    }

    @Override
    public void delete(long id) {
        sliderRepository.deleteById(id);
    }

    @Override
    public Optional<Slider> getById(long id) {
        return  sliderRepository.findById(id);
    }

}
