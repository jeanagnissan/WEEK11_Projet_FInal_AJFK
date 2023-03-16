package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.TypeCropInterface;
import africa.soimpaf.api_v1.models.TypeCrop;
import africa.soimpaf.api_v1.repository.ProductRepository;
import africa.soimpaf.api_v1.repository.TypeCropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeCropService implements TypeCropInterface{
    @Autowired TypeCropRepository typeCropRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<TypeCrop> getAll() {
        return (List<TypeCrop>) typeCropRepository.findAll();
    }

    @Override
    public TypeCrop create(TypeCrop typeCrop) {
        return typeCropRepository.save(typeCrop);
    }

    @Override
    public Optional<TypeCrop> getSingle(Long id) {
        return  typeCropRepository.findById(id);
    }

    @Override
    public TypeCrop update(Long id, TypeCrop typeCrop) {
        return typeCropRepository.save(typeCrop);
    }

    @Override
    public String delete(Long id) {
        if(!typeCropRepository.existTypeCrop(id).isEmpty()){
            /*System.out.println("==================================");
            System.out.println(typeCropRepository.existTypeCrop(id));*/
            return "Impossible de suprimer le type de culture car ce element est utilisé dans d'autre table";
        }else{
            typeCropRepository.deleteById(id);
            return "success delete";
        }
    }

    @Override
    public Optional<TypeCrop> getById(Long id) {
        return  typeCropRepository.findById(id);
    }

}
