
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Slider;

import java.util.List;
import java.util.Optional;

public interface SliderInterface {

    List<Slider> getAll();

    Slider create(Slider slider);

    Optional<Slider> getSingle(long id);

    void delete (long id);

    Slider update(long id, Slider slider);

    Optional<Slider> getById(long id);

}
