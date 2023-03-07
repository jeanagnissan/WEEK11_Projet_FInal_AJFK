package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.TypeCropInterface;
import africa.soimpaf.api_v1.models.TypeCrop;
import africa.soimpaf.api_v1.repository.TypeCropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCropService implements TypeCropInterface {
    @Autowired TypeCropRepository typeCropRepository;

    @Override
    public List<TypeCrop> getAll() {
        return (List<TypeCrop>) typeCropRepository.findAll();
    }

    @Override
    public TypeCrop create(TypeCrop typeCrop) {
        return typeCropRepository.save(typeCrop);
    }

    @Override
    public Optional<TypeCrop> getSingle(long id) {
        return  typeCropRepository.findById(id);
    }

    @Override
    public TypeCrop update(long id, TypeCrop typeCrop) {
        return typeCropRepository.save(typeCrop);
    }

    @Override
    public void delete(long id) {
        typeCropRepository.deleteById(id);
    }

    @Override
    public Optional<TypeCrop> getById(long id) {
        return  typeCropRepository.findById(id);
    }

}
