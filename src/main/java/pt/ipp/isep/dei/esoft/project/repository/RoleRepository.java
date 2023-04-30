package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private static List<String> role=new ArrayList<String>(){{
        add("1. System adminstrator");
        add("2. Agent");
        add("3. Store manager");
        add("4. Network manager");
    }
    };

    public static void getEmployeeRoles(){
        for (String item : role){
            System.out.println(item);
        }
    }
}
