package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.AdminInterface;
import africa.soimpaf.api_v1.models.Admin;
import africa.soimpaf.api_v1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminInterface {
    @Autowired AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> getSingle(long id) {
        return  adminRepository.findById(id);
    }

    @Override
    public Admin update(long id, Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void delete(long id) {
        adminRepository.deleteById(id);
    }

    /*@Override
    public Optional<String> delete(long id) {
        Optional<Admin> admin = getSingle(id);
        if (admin.isPresent()) {
            //return ResponseEntity.ok().body(buyer.get());
            return "null";

        } else {
            adminRepository.deleteById(id);
            return "supression";
        }
    }*/

    @Override
    public Optional<Admin> getById(long id) {
        return  adminRepository.findById(id);
    }

}
