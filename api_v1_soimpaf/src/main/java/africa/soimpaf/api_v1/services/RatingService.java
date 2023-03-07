package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.RatingInterface;
import africa.soimpaf.api_v1.models.Rating;
import africa.soimpaf.api_v1.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService implements RatingInterface {
    @Autowired RatingRepository ratingRepository;

    @Override
    public List<Rating> getAll() {
        return (List<Rating>) ratingRepository.findAll();
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating> getSingle(long id) {
        return  ratingRepository.findById(id);
    }

    @Override
    public Rating update(long id, Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void delete(long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Optional<Rating> getById(long id) {
        return  ratingRepository.findById(id);
    }

}
