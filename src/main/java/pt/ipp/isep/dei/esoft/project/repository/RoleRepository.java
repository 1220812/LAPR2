package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private List<Role> roleList = new ArrayList<>();
    public void addRole(Role role){
        if(validateRole(role)){
            roleList.add(role);
        }
    }
    public boolean validateRole(Role role){
        return !this.roleList.contains(role);
    }
    public List<Role> getRoleList(){
        return List.copyOf(this.roleList);
    }
    public static Role CreateRole(String description){
        return new Role(description);
    }
}
