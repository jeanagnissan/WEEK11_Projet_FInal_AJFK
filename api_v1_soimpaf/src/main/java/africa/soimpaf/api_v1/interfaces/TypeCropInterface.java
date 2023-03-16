
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.TypeCrop;

import java.util.List;
import java.util.Optional;

public interface TypeCropInterface {

    List<TypeCrop> getAll();

    TypeCrop create(TypeCrop typeCrop);

    Optional<TypeCrop> getSingle(Long id);

    String delete (Long id);

    TypeCrop update(Long id, TypeCrop typeCrop);

    Optional<TypeCrop> getById(Long id);

}
