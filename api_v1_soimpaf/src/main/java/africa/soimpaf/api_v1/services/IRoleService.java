package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.exeptions.EntityException;
import africa.soimpaf.api_v1.models.Role;
import java.util.List;

public interface IRoleService {
    public Role saveRole(Role role);

    List<Role> fetchRoleList();

    Role fetchRole(Long idARole) throws EntityException;

    void deleteRole(Long idRole) throws EntityException;

    Role updateRole(Long idRole, Role role) throws EntityException;
}
