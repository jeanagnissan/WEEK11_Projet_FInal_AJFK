package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.BuyerInterface;
import africa.soimpaf.api_v1.models.Buyer;
import africa.soimpaf.api_v1.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService implements BuyerInterface {
    @Autowired BuyerRepository buyerRepository;

    @Override
    public List<Buyer> getAll() {
        return (List<Buyer>) buyerRepository.findAll();
    }

    @Override
    public Buyer create(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Optional<Buyer> getSingle(long id) {
        return  buyerRepository.findById(id);
    }

    @Override
    public Buyer update(long id, Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public String delete(long id) {
        if(!buyerRepository.existProduct(id).isEmpty()){
            return "Impossible de suprimer ce acheteur car ce element à au moin 1 commande";
        } else if (!buyerRepository.existNotification(id).isEmpty()) {
            return "Impossible de suprimer ce acheteur car ce element à deja recus au moin une notification";
        } else{
            buyerRepository.deleteById(id);
            return "success delete";
        }

    }

    @Override
    public Optional<Buyer> getById(long id) {
        return  buyerRepository.findById(id);
    }

}
