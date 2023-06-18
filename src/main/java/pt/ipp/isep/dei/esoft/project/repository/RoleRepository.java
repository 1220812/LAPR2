package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Role repository.
 */
public class RoleRepository implements Serializable {
    private List<Role> roleList = new ArrayList<>();

    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(Role role){
        if(validateRole(role)){
            roleList.add(role);
        }
    }

    /**
     * Get role list list.
     *
     * @return the list
     */
    public List<Role> getRoleList(){
        return List.copyOf(this.roleList);
    }

    /**
     * Create role role.
     *
     * @param description the description
     * @return the role
     */
    public static Role CreateRole(String description){
        return new Role(description);
    }

    /**
     * Add list.
     *
     * @param role the role
     * @return the list
     */
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
