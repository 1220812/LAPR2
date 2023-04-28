package pt.ipp.isep.dei.esoft.project.domain.Places;

import java.util.ArrayList;
import java.util.Arrays;
public enum Role {

    Employee,
    Store_Network_Manager,
    Roles_Store_Manager;

    public static ArrayList<Role> getRolesList() {
        return new ArrayList<>(Arrays.asList(Role.values()));}

}
