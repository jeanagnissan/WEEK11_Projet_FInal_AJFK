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

    /*
     * Methode de recuperation de tous les admin
     */
    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    /*
     * Methode de modification d'un admin
     */
    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    /*
     * Methode de recuperation d'un admin
     */
    @Override
    public Optional<Admin> getSingle(long id) {
        return  adminRepository.findById(id);
    }

    /*
     * Methode de modification d'un admin
     */
    @Override
    public Admin update(long id, Admin admin) {
        return adminRepository.save(admin);
    }

    /*
    *Methode de supression d'un admin
     */
    @Override
    public void delete(long id) {
        adminRepository.deleteById(id);
    }

}
