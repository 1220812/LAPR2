package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pt.ipp.isep.dei.esoft.project.repository.Repositories.roleRepository;

public class RoleRepository {
    private List<Role> roleList = new ArrayList<>();
    public void addRole(Role role){
        if(validateRole(role)){
            roleList.add(role);
        }
    }
    public List<Role> getRoleList(){
        return List.copyOf(this.roleList);
    }
    public static Role CreateRole(String description){
        return new Role(description);
    }

    public List<Role> add(Role role) {

        roleList.add(role);

        Optional<Role> newRole = Optional.empty();
        boolean operationSuccess = false;

        if (validateRole(role)) {
            newRole = Optional.of((Role) role.clone());
            operationSuccess = roleList.add((Role) newRole.get());
        }

        if (!operationSuccess) {
            newRole = Optional.empty();
        }
        return roleList;
    }

    private boolean validateRole(Role role) {
        boolean isValid = !roleList.contains(role);
        return isValid;
    }



}
