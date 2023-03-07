
package africa.soimpaf.api_v1.interfaces;
        import africa.soimpaf.api_v1.models.Admin;
        import java.util.List;
        import java.util.Optional;

public interface AdminInterface {

    List<Admin> getAll();

    Admin create(Admin admin);

    Optional<Admin> getSingle(long id);

    void delete (long id);

    Admin update(long id, Admin admin);

    Optional<Admin> getById(long id);

}
