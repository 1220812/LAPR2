package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class userRepository {
    private static List<String> user=new ArrayList<String>(){{
       user = Employee.toString();
       add(user);
    }
    };

    public static void save(){
        for (String item : user){
            System.out.println(item);
        }
    }
}
