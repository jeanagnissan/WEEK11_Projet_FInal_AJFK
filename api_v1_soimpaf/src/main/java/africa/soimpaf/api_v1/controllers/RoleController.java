package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.exeptions.EntityException;
import africa.soimpaf.api_v1.models.Role;
import africa.soimpaf.api_v1.repository.IRoleRepository;
import africa.soimpaf.api_v1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/rest/role")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public List<Role> fetchRole() {
        return roleService.fetchRoleList();
    }

    @GetMapping("{id}")
    public Role fetchRoleById(@PathVariable("id") Long idRole) throws EntityException {

        return roleService.fetchRole(idRole);
    }

    @DeleteMapping("{id}")
    public String deleteAnalyse(@PathVariable("id") Long idRole) throws EntityException{
        roleService.deleteRole(idRole);
        return "Delete successfull";
    }

    @PostMapping()
    public Role saveRole(@Validated @RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping("{id}")
    public Role updateRole(@PathVariable("id") Long idRole, @Valid @RequestBody Role role) throws EntityException{

        return  roleService.updateRole(idRole, role);
    }
}
